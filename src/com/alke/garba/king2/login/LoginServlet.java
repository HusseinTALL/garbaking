package com.alke.garba.king2.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
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
        String uname = request.getParameter("username");
        String upwd = request.getParameter("password");
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;
        Connection conn= null;
        if(uname == null || uname.equals("")){
            request.setAttribute("status","invalidUsername");
            dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request,response);
        }
        if(upwd == null || upwd.equals("")){
            request.setAttribute("status","invalidPassword");
            dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request,response);
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "root";
            String pwd = "97970802";
            String url = "jdbc:mysql://localhost:3306/garbaking?useSSL=false";

            String hashedPassword = doHashing(upwd);

            conn = DriverManager.getConnection(url, user, pwd);
            PreparedStatement pst = conn.prepareStatement("select * from users where uname=? and upwd =?");
            pst.setString(1,uname);
            pst.setString(2,hashedPassword);

            ResultSet rs =  pst.executeQuery();
            if(rs.next()){
                session.setAttribute("name",rs.getString("uname"));
                dispatcher = request.getRequestDispatcher("index.jsp");
            }else{
                request.setAttribute("status","failed");
                dispatcher = request.getRequestDispatcher("login.jsp");
            }
            dispatcher.forward(request,response);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
