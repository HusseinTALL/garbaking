package com.alke.garba.king2.login;

public class JavaMail {
    public static void main(String[] args) {
        try {
            JavaMailUtil.sendMail("tall.ousseni@gmail.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
