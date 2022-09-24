package com.alke.garba.king2.login;

//package com.alke.garba.king2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
        import java.sql.*;
import java.util.Random;

@WebServlet(name = "forgotPassword", value = "/forgotPassword")
public class ForgotPasswordServlet extends HttpServlet {


//    public static String doHashing(String password){
//        try {
//            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
//            messageDigest.update(password.getBytes());
//
//            byte[] resultByteArray = messageDigest.digest();
//
//            StringBuilder sb = new StringBuilder();
//            for(byte b : resultByteArray){
//                sb.append(String.format("%02X",b));
//            }
//            return sb.toString();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        return "";
//    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Session session =request
        HttpSession mySession = request.getSession();
        RequestDispatcher dispatcher = null;
        int otp;
        Random rand = new Random();
        otp = rand.nextInt(1255650);
        String otps = String.valueOf(otp);
        String body = "Your OTP is :".concat(otps);
//        System.out.println(body);
        String recepient = request.getParameter("email");
//        System.out.println("----->"+recepient);
        if (recepient != null && !(recepient.equals(""))) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/garbaking?useSSL=false","root","97970802");
                PreparedStatement pst = conn.prepareStatement("Select * from users where uemail =?");
                pst.setString(1, recepient);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    MailUtil.send("smtp.126.com", "tallousseni@126.com", recepient, "GARBAKING OTP", body, "tallousseni", "IEMVFUYVHMVKNUEJ");
                    dispatcher = request.getRequestDispatcher("EnterOtp.jsp");
                    request.setAttribute("message", "OTP is sent to your email id");
                    //request.setAttribute("connection", con);
                    mySession.setAttribute("otp", otp);
                    mySession.setAttribute("email", recepient);
                    System.out.println(mySession.getAttribute("email"));
                    dispatcher.forward(request, response);
                    //request.setAttribute("status", "success");
                }else{
                    request.setAttribute("status", "failed");
                    request.setAttribute("message","This email address doesn't have an account !!!");
                    dispatcher = request.getRequestDispatcher("forgotPassword.jsp");
                    dispatcher.forward(request, response);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("status", "failed");
            request.setAttribute("message", "please fill the email");
            dispatcher = request.getRequestDispatcher("forgotPassword.jsp");
            dispatcher.forward(request, response);
        }
    }
}




//}
