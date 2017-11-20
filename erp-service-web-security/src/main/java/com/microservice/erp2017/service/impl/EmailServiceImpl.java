package com.microservice.erp2017.service.impl;

import static com.microservice.erp2017.constant.WebConstant.JavaxMail.EMAIL_SENDER;
import static com.microservice.erp2017.constant.WebConstant.JavaxMail.HOST;
import static com.microservice.erp2017.constant.WebConstant.JavaxMail.PASSWORD;
import static com.microservice.erp2017.constant.WebConstant.JavaxMail.SUBJECT;
import com.microservice.erp2017.service.EmailService;
import org.springframework.stereotype.Service;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author reza
 */
@Service("EmailService")
public class EmailServiceImpl extends Thread implements EmailService {

    private final Properties props = System.getProperties();
    private String activationCode;
    private String email;      
    
    @Override
    public void sendEmail(String activationCode, String email){
        this.activationCode=activationCode;
        this.email=email;
        //----------------------------------------------------------------------
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.user", EMAIL_SENDER);
        props.put("mail.smtp.password", PASSWORD);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        //----------------------------------------------------------------------
        this.start();
    }
    
    private String Message(){
        return "Silahkan aktifkan aktifasi berikut: "+activationCode+"\n\n"
            + "Harap simpan kode tersebut dengan baik, apabila di kemudian hari aplikasi "
            + "terhapus anda bisa menggunakan kode tersebut untuk aktifasi ulang.\n\nApabila ada "
            + "pertanyaan silahkan hubungi kami di No: +6281394020154 (Reza).\n\nHormat kami\nPT. Testing.";
    }
    
    @Override
    public void run(){
        try{
            Session session = Session.getDefaultInstance(props, null);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL_SENDER));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject(SUBJECT);
            message.setText(Message());
            Transport transport = session.getTransport("smtp");
            transport.connect(HOST, EMAIL_SENDER, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }catch(MessagingException ex){
            ex.printStackTrace();
        }
    }
}
