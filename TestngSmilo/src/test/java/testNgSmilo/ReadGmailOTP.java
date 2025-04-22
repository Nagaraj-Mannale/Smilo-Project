      
        package testNgSmilo;

        import jakarta.mail.*;
        import jakarta.mail.internet.MimeMultipart;
        import jakarta.mail.search.FlagTerm;
        import org.jsoup.Jsoup;

        import java.util.*;
        import java.util.regex.*;

        public class ReadGmailOTP {

            public static String fetchOTP() {
                String host = "imap.gmail.com";
                String username = "smilotester@gmail.com";        // ← Replace with your Gmail address
                String password = "oclw bpac sdzg ftwc";          // ← Paste the 16-char app password here

                String otp = "OTP not found";

                try {
                    // Set up IMAP properties
                    Properties properties = new Properties();
                    properties.put("mail.store.protocol", "imaps");
                    properties.put("mail.imap.host", host);
                    properties.put("mail.imap.port", "993");
                    properties.put("mail.imap.ssl.enable", "true");

                    // Create a session
                    Session emailSession = Session.getInstance(properties);
                    Store store = emailSession.getStore();
                    store.connect(host, username, password);

                    // Open inbox
                    Folder inbox = store.getFolder("INBOX");
                    inbox.open(Folder.READ_WRITE);

                    // Wait for new emails
                    int retries = 0;
                    while (retries < 5) {
                        if (hasNewUnreadEmail(inbox)) {
                            break;
                        }
                        System.out.println("Waiting for OTP email...");
                        Thread.sleep(3000);
                        retries++;
                        inbox.getMessageCount(); // refresh
                    }

                    // Read unread email
                    Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
                    if (messages.length > 0) {
                        Message latest = messages[messages.length - 1];
                        String content = extractContent(latest);

                        if (!content.isEmpty()) {
                            otp = extractOTP(content);
                            latest.setFlag(Flags.Flag.SEEN, true); // mark as read
                        }
                    }

                    inbox.close(false);
                    store.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println("Extracted OTP: " + otp);
                return otp;
            }

            private static boolean hasNewUnreadEmail(Folder inbox) throws MessagingException {
                return inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false)).length > 0;
            }

            private static String extractContent(Message message) throws Exception {
                if (message.isMimeType("text/plain")) {
                    return message.getContent().toString();
                } else if (message.isMimeType("text/html")) {
                    return Jsoup.parse(message.getContent().toString()).text();
                } else if (message.isMimeType("multipart/*")) {
                    return getTextFromMultipart((MimeMultipart) message.getContent());
                }
                return "";
            }

            private static String getTextFromMultipart(MimeMultipart mimeMultipart) throws Exception {
                for (int i = 0; i < mimeMultipart.getCount(); i++) {
                    BodyPart part = mimeMultipart.getBodyPart(i);
                    if (part.isMimeType("text/plain")) {
                        return part.getContent().toString();
                    } else if (part.isMimeType("text/html")) {
                        return Jsoup.parse(part.getContent().toString()).text();
                    } else if (part.getContent() instanceof MimeMultipart) {
                        return getTextFromMultipart((MimeMultipart) part.getContent());
                    }
                }
                return "";
            }

            private static String extractOTP(String content) {
                Matcher matcher = Pattern.compile("\\b\\d{6}\\b").matcher(content);
                if (matcher.find()) return matcher.group();
                return "OTP not found";
            }
        }
