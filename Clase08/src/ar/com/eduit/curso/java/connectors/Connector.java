package ar.com.eduit.curso.java.connectors;

import java.sql.Connection;
import java.sql.DriverManager;


public class Connector {
    private static String driver="com.mysql.jdbc.Driver"; //driver mysql 5
    //private static String driver="com.mysql.cj.jdbc.Driver"; //driver mysql 6 o sup.
    
    //private static String url="jdbc:mysql://localhost:3306/colegio";
    private static String url="jdbc:mysql://remotemysql.com:3306/XYi1Z7S7xL";
    
    //private static String user="root";
    //private static String pass="";
    
    private static String user="XYi1Z7S7xL";
    private static String pass="Bg1FebesWT";
    
    private static Connection conn=null;
    
    private Connector(){}
    
    public static Connection getConnection(){
        if(conn==null){
            try {
                Class.forName(driver);
                conn=DriverManager.getConnection(url, user, pass);
            } catch (Exception e) { e.printStackTrace(); }
        }
        return conn;
    }
    
}