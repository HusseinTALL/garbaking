package com.alke.garba.king2.login;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class JavaMailUtil {

    public static void sendMail(String recipient) throws Exception {


        Properties prop = new Properties();
        int otp = 5145;
        prop.setProperty("mail.host", "smtp.126.com");
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        //使用JavaMail发送邮件的5个步骤
        //1、创建session
        Session session = Session.getInstance(prop);
        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);
        //2、通过session得到transport对象
        Transport ts = session.getTransport();
        //3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
        ts.connect("smtp.126.com", "tallousseni", "IEMVFUYVHMVKNUEJ");
        //4、创建邮件
        Message message = createSimpleMail(session);
        //5、发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }
    public static MimeMessage createSimpleMail(Session session)
            throws Exception {
        //创建邮件对象
        MimeMessage message = new MimeMessage(session);
        //指明邮件的发件人
        message.setFrom(new InternetAddress("tallousseni@126.com"));
        //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("tall.ousseni@gmail.com"));
        //邮件的标题
        message.setSubject("OTP GARBAKING");
        //邮件的文本内容
        message.setContent("otp ！", "text/html;charset=UTF-8");
        //返回创建好的邮件对象
        return message;
    }

//    System.out.println("Preparing to send email");
//    Properties properties = new Properties();
//
//        properties.put("mail.smtp.auth","true");
//        properties.put("mail.smtp.starttls.enable","true");
//        properties.put("mail.smtp.host","smtp.gmail.com");
//        properties.put("mail.smtp.port","465");
//
//    String myAccountEmail = "tall.ousseni@gmail.com";
//    String password = "97970802";
////    String  recipient = "tall.ousseni@gmail.com";
//    Session session = Session.getInstance(properties, new Authenticator() {
//        @Override
//        protected PasswordAuthentication getPasswordAuthentication() {
//            return new PasswordAuthentication(myAccountEmail,password);
//        }
//    });
//    Message message = prepareMessage(session,myAccountEmail,recipient);
//
//
//        Transport.send(message);
//        System.out.println("Message sent successfully");
//
//
//}
//
//    private static Message prepareMessage(Session session, String myAccountEmail, String recipient) {
//        Message message = new MimeMessage(session);
//        try {
//            message.setFrom(new InternetAddress(myAccountEmail));
//            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
//            message.setSubject("OTP GARBAKING");
//            message.setText("Hey there,\n Look my email !");
//            return message;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;

}
