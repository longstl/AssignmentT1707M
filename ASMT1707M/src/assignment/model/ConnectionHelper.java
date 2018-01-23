/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author daolinh
 */
public class ConnectionHelper {
    
    private static Connection connection = null;
    
    public static Connection getConnection(){
        if(connection == null){
            try {
                // Tạo kết nối với tài khoản root, password rỗng.
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aptech_fpt", "root", "");
            } catch (SQLException ex) {
                System.err.println("Can not connect to database.");
                connection = null;
            }
        }
        return connection;
    }
}
