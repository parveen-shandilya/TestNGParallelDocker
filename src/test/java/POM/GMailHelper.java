package POM;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.search.SearchTerm;

import java.io.IOException;

import java.util.Properties;

public class GMailHelper {

    public static int SearchedMailCount;
    private static String imapHost = "imap.gmail.com";
    private static String imapPort = "993";
    private String userName;
    private String password;
    private Store store;

    public GMailHelper(String userName, String password) throws MessagingException {

    	this.userName = userName;
        this.password = password;

        // Setup Gmail IMAP connection
        Properties properties = new Properties();
        properties.put("mail.store.protocol", "imaps");
        properties.put("mail.imaps.host", "imap.gmail.com");
        properties.put("mail.imaps.port", "993");
        properties.put("mail.imaps.ssl.enable", "true");

        Session session = Session.getInstance(properties);
        this.store = session.getStore("imaps"); // Initialize 'store'
        this.store.connect("imap.gmail.com", userName, password); // Connect 'store' to Gmail
    }

//    public Session setIMAPSession() {
//
//
//        Properties properties = new Properties();
//        properties.put("mail.imap.host", imapHost);
//        properties.put("mail.imap.port", imapPort);
//        properties.setProperty("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        properties.setProperty("mail.imap.socketFactory.fallback", "false");
//        properties.setProperty("mail.imap.socketFactory.port", String.valueOf(imapPort));
//
//        return Session.getInstance(properties);
//    }
    
    public Message getMostRecentEmail(String folderName, String searchBySubject) throws MessagingException {
        
    	Folder[] folders = store.getDefaultFolder().list("*");
        for (Folder folder1 : folders) {
            System.out.println("Folder Name: " + folder1.getFullName());
        }
    	
    	
    	Folder folder = store.getFolder(folderName);
        folder.open(Folder.READ_ONLY);
        
        
       
        Message[] messages = folder.getMessages();
        for (int i = messages.length - 1; i >= 0; i--) { // Start from the newest email
            Message message = messages[i];
            if (message.getSubject() != null && message.getSubject().contains(searchBySubject)) {
                folder.close(false);
                return message; // Return the first matching email
            }
        }

        folder.close(false);
        return null; // Return null if no matching email is found
    }
    
    
    public void close() {
        try {
            if (store != null && store.isConnected()) {
                store.close();
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    public void replyToMostRecentEmail(String userName, String password, String replyMessageContent,String foldername) throws MessagingException {

        try {
            Folder spamFolder = store.getFolder(foldername);
            if (!spamFolder.exists()) {
                throw new MessagingException("Spam folder does not exist.");
            }
            spamFolder.open(Folder.READ_WRITE);

            // Get the most recent email
            Message[] messages = spamFolder.getMessages();
            if (messages.length > 0) {
                Message recentEmail = messages[messages.length - 1];

                // Create a reply
                Message replyMessage = recentEmail.reply(false);
                replyMessage.setFrom(new InternetAddress(userName));
                replyMessage.setText(replyMessageContent);
                replyMessage.setReplyTo(recentEmail.getReplyTo());

                // Setup SMTP properties for sending the email
                Properties smtpProperties = new Properties();
                smtpProperties.put("mail.smtp.auth", "true");
                smtpProperties.put("mail.smtp.starttls.enable", "true");
                smtpProperties.put("mail.smtp.host", "smtp.gmail.com");
                smtpProperties.put("mail.smtp.port", "587");

                Session smtpSession = Session.getInstance(smtpProperties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(userName, password);
                    }
                });

                Transport transport = smtpSession.getTransport("smtp");
                try {
                    transport.connect("smtp.gmail.com", 587, userName, password);
                    transport.sendMessage(replyMessage, replyMessage.getAllRecipients());
                    System.out.println("Reply sent successfully.");
                } finally {
                    transport.close();
                }
               
            } else {
                System.out.println("No emails found in the Spam folder.");
            }

            spamFolder.close(false);
        } catch (MessagingException e) {
            System.err.println("Failed to connect or process emails: " + e.getMessage());
            throw e;
        } finally {
            store.close();
        }
    }


//    public List<Message> searchEmail(int noOfSecToWait, String folderName, final String keyword) throws InterruptedException {
//
//        Session session = setIMAPSession();
//
//        List<Message> returnList = new ArrayList<>();
//
//        try {
//
//            Thread.sleep(noOfSecToWait * 1000);
//
//            Store store = session.getStore("imap");
//            store.connect(this.userName, this.password);
//
//            Folder folderInbox = store.getFolder(folderName);
//            folderInbox.open(Folder.READ_ONLY);
//
//            SearchTerm searchCondition = new SearchTerm() {
//
//                private static final long serialVersionUID = 1L;
//
//                @Override
//                public boolean match(Message message) {
//                    try {
//                        if (message.getSubject().contains(SmsAndEmailVerificationUtility.RandomSubject)) {
//                            return true;
//                        }
//                    } catch (MessagingException ex) {
//                        ex.printStackTrace();
//                    }
//                    return false;
//                }
//            };
//
//            Message[] foundMessages = folderInbox.search(searchCondition);
//
//            SearchedMailCount = foundMessages.length;
//            for (int i = 0; i < foundMessages.length; i++) {
//
//                Message message = foundMessages[i];
//
//                /* assuming you retrieved 'message' from your folder object */
//                Message copyOfMessage = new MimeMessage((MimeMessage) message);
//
//                returnList.add(copyOfMessage);
//            }
//
//            folderInbox.close(false);
//            store.close();
//
//        } catch (NoSuchProviderException ex) {
//            ex.printStackTrace();
//        } catch (MessagingException ex) {
//            ex.printStackTrace();
//        }
//
//        return returnList;
//    }

    /**
     * Return the primary text content of the message part.
     */
    public String getText(boolean textIsHtml, Part p) throws MessagingException, IOException {

        if (p.isMimeType("text/*")) {
            String s = (String) p.getContent();
            textIsHtml = p.isMimeType("text/html");
            return s;
        }

        if (p.isMimeType("multipart/alternative")) {

            Multipart mp = (Multipart) p.getContent();
            String text = null;
            for (int i = 0; i < mp.getCount(); i++) {
                Part bp = mp.getBodyPart(i);
                if (bp.isMimeType("text/plain")) {
                    if (text == null) text = getText(textIsHtml, bp);
                    continue;
                } else if (bp.isMimeType("text/html")) {
                    String s = getText(textIsHtml, bp);
                    if (s != null) return s;
                } else {
                    return getText(textIsHtml, bp);
                }
            }
            return text;
        } else if (p.isMimeType("multipart/*")) {
            Multipart mp = (Multipart) p.getContent();
            for (int i = 0; i < mp.getCount(); i++) {
                String s = getText(textIsHtml, mp.getBodyPart(i));
                if (s != null) return s;
            }
        }

        return null;
    }
}
