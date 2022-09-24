package com.alke.garba.king2.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

@WebServlet(name = "RegistrationServlet", value = "/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PrintWriter out = response.getWriter();
//        out.println("hellooooo");
//    }

    public static String doHashing(String password){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes());

            byte[] resultByteArray = messageDigest.digest();

            StringBuilder sb = new StringBuilder();
            for(byte b : resultByteArray){
                sb.append(String.format("%02X",b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        System.out.println("hashed password: "+ doHashing("123456"));

        String uname = request.getParameter("username");
        String upwd = request.getParameter("password");
        String uemail = request.getParameter("email");
        String re_pwd = request.getParameter("re_password");
        String contact = request.getParameter("contact");
        RequestDispatcher dispatcher = null;
//        PrintWriter out = response.getWriter();
//        out.println(uname+ " || " + upwd+ " || " + re_pwd+ " || " + contact);
        Connection conn = null;

        if(uname == null || uname.equals("")){
            request.setAttribute("status","invalidUsername");
            dispatcher = request.getRequestDispatcher("RegistrationPage.jsp");
            dispatcher.forward(request,response);
        }
        if(upwd == null || upwd.equals("") ||re_pwd == null || re_pwd.equals("")){
            request.setAttribute("status","invalidPassword");
            dispatcher = request.getRequestDispatcher("RegistrationPage.jsp");
            dispatcher.forward(request,response);
        }
        if(uemail == null || uemail.equals("") ){
            request.setAttribute("status","invalidEmail");
            dispatcher = request.getRequestDispatcher("RegistrationPage.jsp");
            dispatcher.forward(request,response);
        }
        if(contact == null || contact.equals("")){
            request.setAttribute("status","invalidContact");
            dispatcher = request.getRequestDispatcher("RegistrationPage.jsp");
            dispatcher.forward(request,response);
        }else if(contact.length()>13){
            request.setAttribute("status","invalidContactLength");
            dispatcher = request.getRequestDispatcher("RegistrationPage.jsp");
            dispatcher.forward(request,response);
        }
        if(!upwd.equals(re_pwd)){
            request.setAttribute("status","differentPasswords");
            dispatcher = request.getRequestDispatcher("RegistrationPage.jsp");
            dispatcher.forward(request,response);
        }


        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "root";
            String pwd = "97970802";
            String url = "jdbc:mysql://localhost:3306/garbaking?useSSL=false";
            conn = DriverManager.getConnection(url, user, pwd);
            String HashedPassword = doHashing(upwd);
            PreparedStatement pst = conn.prepareStatement("insert into users (uname,upwd,uemail,umobile) values(?,?,?,?)");
            pst.setString(1,uname);
            pst.setString(2,HashedPassword);
            pst.setString(3,uemail);
            pst.setString(4,contact);
            int rowCount = pst.executeUpdate();
            dispatcher = request.getRequestDispatcher("login.jsp");

            if(rowCount>0){
                request.setAttribute("status","success");
//                dispatcher.forward("");
            }else{
                request.setAttribute("status","failed");
            }
            Thread.sleep(1000*2);
            dispatcher.forward(request,response);
        } catch (SQLException e) {
            if(e instanceof SQLIntegrityConstraintViolationException){
                dispatcher = request.getRequestDispatcher("RegistrationPage.jsp");
                System.out.println("Duplicate are not allowed for the column uemail");
                request.setAttribute("status","DuplicateEmail");
                dispatcher.forward(request,response);
            }
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
