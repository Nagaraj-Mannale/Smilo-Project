//"";
package basePage;

import jakarta.mail.*;
import jakarta.mail.internet.MimeMultipart;
import jakarta.mail.search.FlagTerm;

import java.util.*;
import java.util.regex.*;
import org.jsoup.Jsoup;

public class ReadGmailOTP {
    public static void main(String[]args){//public static String fetchOTP() {
        String host = "imap.gmail.com";
        String username = "nagaraj@rokkun.io"; // Replace with your email
        String password = "rtgv usyp nlzq jqqy"; // Replace with your App Password

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

            // Open the INBOX folder and fetch only unread messages
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_WRITE);
            Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false)); // Fetch only unread

            if (messages.length == 0) {
                System.out.println("No unread messages found.");
                inbox.close(false);
                store.close();
              //  return "OTP not found";
            }

            // Sort by recent date (descending order)
            Arrays.sort(messages, (m1, m2) -> {
                try {
                    return m2.getSentDate().compareTo(m1.getSentDate());
                } catch (MessagingException e) {
                    return 0;
                }
            });

            // Process the latest email
            for (Message message : messages) {
                if (isRecentEmail(message)) {  // Check if email is recent (within 5 mins)
                    String emailContent = extractEmailContent(message);
                    String otp = extractOTP(emailContent);

                    // Mark email as read
                    message.setFlag(Flags.Flag.SEEN, true);

                    inbox.close(false);
                    store.close();
                  //  return otp;
                }
            }

            // Close connections if no recent email found
            inbox.close(false);
            store.close();
          //  return "OTP not found";

        } catch (Exception e) {
            e.printStackTrace();
          //  return "Error fetching OTP";
        }
    }

    /**
     * Extracts the latest content from an email.
     */
    private static String extractEmailContent(Message message) throws Exception {
        if (message.isMimeType("text/plain")) {
            return message.getContent().toString();
        } else if (message.isMimeType("text/html")) {
            return Jsoup.parse(message.getContent().toString()).text();
        } else if (message.isMimeType("multipart/*")) {
            return getTextFromMimeMultipart((MimeMultipart) message.getContent());
        }
        return "";
    }

    /**
     * Extracts the text from a multipart email (conversation thread).
     */
    private static String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws Exception {
        for (int i = mimeMultipart.getCount() - 1; i >= 0; i--) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                return bodyPart.getContent().toString();
            } else if (bodyPart.isMimeType("text/html")) {
                return Jsoup.parse(bodyPart.getContent().toString()).text();
            } else if (bodyPart.getContent() instanceof MimeMultipart) {
                return getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
            }
        }
        return "";
    }

    /**
     * Extracts a 6-digit OTP from email content.
     */
    private static String extractOTP(String emailContent) {
        Pattern pattern = Pattern.compile("\\b\\d{6}\\b");
        Matcher matcher = pattern.matcher(emailContent);
        return matcher.find() ? matcher.group() : "OTP not found";
    }

    /**
     * Checks if the email was sent within the last 5 minutes.
     */
    private static boolean isRecentEmail(Message message) {
        try {
            Date sentDate = message.getSentDate();
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MINUTE, -5); // Check emails within last 5 minutes
            return sentDate.after(calendar.getTime());
        } catch (Exception e) {
            return false;
        }
    }
}

