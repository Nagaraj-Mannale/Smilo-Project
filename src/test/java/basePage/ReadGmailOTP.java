package basePage;

import jakarta.mail.*;
import jakarta.mail.internet.MimeMultipart;
import jakarta.mail.search.FlagTerm;
import org.jsoup.Jsoup;
import java.util.*;
import java.util.regex.*;

public class ReadGmailOTP {
    public static String fetchOTP() {
        String host = "imap.gmail.com";
        String username = "nagaraj@rokkun.io"; // Replace with your email
        String password = "rtgv usyp nlzq jqqy"; // Replace with your App Password

        String otp = "OTP not found"; // Default OTP value

        try {
            // Setup IMAP properties
            Properties properties = new Properties();
            properties.put("mail.store.protocol", "imaps");
            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", "993");
            properties.put("mail.imap.ssl.enable", "true");

            // Create session and connect to Gmail
            Session emailSession = Session.getDefaultInstance(properties);
            Store store = emailSession.getStore();
            store.connect(host, username, password);

            // Open INBOX folder
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_WRITE);

            // 🔄 REFRESH the inbox before fetching emails
            inbox.getMessageCount(); // Force a refresh

            // Wait for new emails (Poll for 15 seconds)
            int retries = 0;
            while (retries < 5) {
                if (hasNewUnreadEmail(inbox)) {
                    break; // New email detected
                }
                System.out.println("Waiting for new email...");
                Thread.sleep(3000); // Wait for 3 seconds before checking again
                retries++;
                inbox.getMessageCount(); // Refresh again
            }

            // Fetch latest unread email
            Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));

            if (messages.length > 0) {
                Message latestMessage = messages[messages.length - 1]; // Get latest unread email
                String emailContent = extractLatestEmailContent(latestMessage);

                if (!emailContent.isEmpty()) {
                    otp = extractOTP(emailContent);
                    latestMessage.setFlag(Flags.Flag.SEEN, true); // Mark email as read
                }
            }

            // ✅ Print OTP before returning
            System.out.println("Extracted OTP: " + otp);

            // ✅ Ensure proper cleanup before returning
            inbox.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return otp; // ✅ Return OTP after printing
    }

    private static boolean hasNewUnreadEmail(Folder inbox) throws MessagingException {
        Message[] unreadMessages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
        return unreadMessages.length > 0;
    }

    private static String extractLatestEmailContent(Message message) throws Exception {
        if (message.isMimeType("text/plain")) {
            return message.getContent().toString();
        } else if (message.isMimeType("text/html")) {
            return Jsoup.parse(message.getContent().toString()).text();
        } else if (message.isMimeType("multipart/*")) {
            return getLatestTextFromMimeMultipart((MimeMultipart) message.getContent());
        }
        return "";
    }

    private static String getLatestTextFromMimeMultipart(MimeMultipart mimeMultipart) throws Exception {
        for (int i = 0; i < mimeMultipart.getCount(); i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                return bodyPart.getContent().toString();
            } else if (bodyPart.isMimeType("text/html")) {
                return Jsoup.parse(bodyPart.getContent().toString()).text();
            } else if (bodyPart.getContent() instanceof MimeMultipart) {
                return getLatestTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
            }
        }
        return "";
    }

    private static String extractOTP(String emailContent) {
        Pattern pattern = Pattern.compile("\\b\\d{6}\\b");
        Matcher matcher = pattern.matcher(emailContent);

        String latestOTP = "OTP not found";
        while (matcher.find()) {
            latestOTP = matcher.group();
        }
        return latestOTP;
    }
}
