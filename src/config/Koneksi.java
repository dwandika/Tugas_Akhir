package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private static Connection mysqlconfig;
    public static Connection ConfigDB() throws  SQLException{
        try {
           String url = "jdbc:mysql://localhost:3306/db_appkasir";
           String user = "root";
           String password = "";
           mysqlconfig = DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            System.err.println("Koneksi gagal"+e.getMessage());
        }
        return mysqlconfig;
        
    }
    
}
