/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nitcmess;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Prashant
 */
public class sendItNow {
    public static boolean sendMail(String from,String password,String message,String to)
    {
        String host="smtp.gmail.com";
        Properties props=System.getProperties();
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.host",host);
        props.put("mail.smtp.user",from);
        props.put("mail.smtp.password",password);
        props.put("mail.smtp.port",587);
        props.put("mail.smatp.auth","true");
        Session session=Session.getDefaultInstance(props,null);
        MimeMessage mimemessage=new MimeMessage(session);
        try
        {
            mimemessage.setFrom(new InternetAddress(from));
            InternetAddress toaddress=new InternetAddress(to);
            mimemessage.addRecipient(Message.RecipientType.TO,toaddress);
            mimemessage.setSubject("Mail From NITC HOSTEL OFFICE");
            mimemessage.setText(message);
            Transport transport=session.getTransport("smtp");
            transport.connect(host,from,password);
            transport.sendMessage(mimemessage,mimemessage.getAllRecipients());
            transport.close();
            return true;
        } catch (MessagingException ex) {
           ex.printStackTrace();
        }
        return false;
    }

}
