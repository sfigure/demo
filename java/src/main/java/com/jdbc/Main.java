package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author jzx
 * @date 2019/01/31 14:39
 */
public class Main {
    
    @SuppressWarnings("all")
    public static void main(String[] argv) throws Exception {
        try( Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/spring?serverTimezone=GMT", "root", "") ) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT 1 as id,'2' as name,18 as age");
            while (rs.next()) {
                System.out.println(rs.getInt("age"));
            }
        } finally {
        
        }
        
        
    }
}
