package Judge;


import java.security.SecureRandom;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

class GMailAuthenticator extends Authenticator {
     String user;
     String pw;
     public GMailAuthenticator (String username, String password)
     {
        super();
        this.user = username;
        this.pw = password;
     }
     @Override
    public PasswordAuthentication getPasswordAuthentication()
    {
       return new PasswordAuthentication(user, pw);
    }
}

public class SendEmail {
    
    
    public static boolean sendEmail(String Subject, String Body){
       try
        {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            String username = "selabeval@gmail.com";
            String password = "selabeval123";
            Session session = Session.getInstance(props, new GMailAuthenticator(username, password));
            Message message = new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("selabeval@gmail.com"));
            message.setSubject(Subject);
            message.setText(Body);
            Transport.send(message);
            return true;
        }catch (MessagingException e) {
            ErrorHandling.MessagingError();
            return false;
        }catch(Exception e){        
            ErrorHandling.InternetError();
            return false;
        } 
    }
}
    