package basePage;

import jakarta.mail.*;
import jakarta.mail.internet.MimeMultipart;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;

public class ReadGmailOTP {
	public static String fetchOTP() {
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

			// Open the INBOX folder
			Folder inbox = store.getFolder("INBOX");
			inbox.open(Folder.READ_ONLY);

			// Fetch only recent unread messages (avoiding old messages)
			Message[] messages = inbox.getMessages();
			if (messages.length == 0) {
				System.out.println("No messages found.");
				return "OTP not found";
			}

			// Get the latest email in the inbox
			Message message = messages[messages.length - 1];
			String emailContent = getLatestPartFromMessage(message); // Extract the latest content

			// Extract OTP using regex (6-digit number)
			Pattern pattern = Pattern.compile("\\b\\d{6}\\b");
			Matcher matcher = pattern.matcher(emailContent);
			String otp = matcher.find() ? matcher.group() : "OTP not found";

			// Close connections
			inbox.close(false);
			store.close();

			return otp;

		} catch (Exception e) {
			e.printStackTrace();
			return "Error fetching OTP";
		}
	}

	/**
	 * Extracts the latest content from a message, including multipart emails.
	 */
	private static String getLatestPartFromMessage(Message message) throws Exception {
		if (message.isMimeType("text/plain")) {
			return message.getContent().toString();
		} else if (message.isMimeType("text/html")) {
			return Jsoup.parse(message.getContent().toString()).text();
		} else if (message.isMimeType("multipart/*")) {
			return getLatestTextFromMimeMultipart((MimeMultipart) message.getContent());
		}
		return "";
	}

	/**
	 * Extracts the latest message part from a multipart email (conversation
	 * thread).
	 */
	private static String getLatestTextFromMimeMultipart(MimeMultipart mimeMultipart) throws Exception {
		String latestMessage = "";
		int count = mimeMultipart.getCount(); // Get total parts
		for (int i = count - 1; i >= 0; i--) { // Iterate from latest to oldest
			BodyPart bodyPart = mimeMultipart.getBodyPart(i);
			if (bodyPart.isMimeType("text/plain")) {
				latestMessage = bodyPart.getContent().toString();
				break;
			} else if (bodyPart.isMimeType("text/html")) {
				latestMessage = Jsoup.parse(bodyPart.getContent().toString()).text();
				break;
			} else if (bodyPart.getContent() instanceof MimeMultipart) {
				latestMessage = getLatestTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
				break;
			}
		}
		return latestMessage;
	}
}
