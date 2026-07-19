package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL="jdbc:postgresql://localhost:5432/sms";
    private static final String USERNAME="postgres";
    private static final String PASSWORD="sameer1234";



     public static Connection getConnection() throws ClassNotFoundException, SQLException {
         try{
             Class.forName("org.postgresql.Driver");
             return DriverManager.getConnection(URL,USERNAME,PASSWORD);
         }catch (SQLException e){
             e.printStackTrace();
             return null;
         }
     }
}