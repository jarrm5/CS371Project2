/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advertisementsapp;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author jarrm5
 */
public class MySqlConnect {
    Connection conn = null;
    
    public static Connection ConnectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://kc-sce-appdb01/jarrm5_1","jarrm5_1","zuK2AMhttSIdGx2vrD3a");
            JOptionPane.showMessageDialog(null,"Connected to database");
            return conn;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
    }
}
