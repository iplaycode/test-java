package live.fangwei.gn;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;
import java.util.UUID;

public class TestMail {

    public static void main(String[] args) {

        String host = "smtp.qq.com";
        int port = 587;
        String user = "iplaycode@qq.com";
        String passwd = "******";

        String from = "Test Mail <" + user + ">";
        String to = "iplaycode@qq.com";

        Properties props = System.getProperties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", true);

        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, passwd);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            message.setSubject("Test message " + UUID.randomUUID());

            // text
//            message.setText("这是邮件正文。");

//            String path = TestMail.class.getResource("mail.txt").getPath();
            String path = "/Users/Wei/Documents/work/code/github/test-java/test-java-spring/src/main/resources/mail.txt";
            System.out.println("filepath: " + path);
            // html
//            message.setContent("<h1>This is actual message</h1>", "text/html" );
//            message.setContent(FileUtils.readFileToString(new File(path)), "text/html" );

            // file
            Multipart multipart = new MimeMultipart();

            BodyPart bodyPart = new MimeBodyPart();
            bodyPart.setText("这是邮件正文");
            multipart.addBodyPart(bodyPart);

            BodyPart filePart = new MimeBodyPart();
            DataSource source = new FileDataSource(path);
            filePart.setDataHandler(new DataHandler(source));
            filePart.setFileName(path);
            multipart.addBodyPart(filePart);
            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Sent message successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
