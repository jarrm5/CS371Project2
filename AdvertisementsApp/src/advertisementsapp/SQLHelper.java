/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advertisementsapp;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class SQLHelper {
    
    private Connection conn;
    
    public SQLHelper(String driver, String hostName, String databaseName, String username, String password){
        try{
            Class.forName(driver);  // MySQL database connection
            String connectionString = "jdbc:mysql://" + hostName + ":3306/" + databaseName + "?user=" + username + "&password=" + password;
            conn = (Connection) DriverManager.getConnection(connectionString);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "There is a problem with the database connection.");
        }
    }
    public Connection getConn(){
        return conn;
    }
    public ResultSet getUserName(String username, String type) throws Exception{
         
        ResultSet rs;
        
        try{
            String query = "SELECT * FROM " + type + "s WHERE User_id = '" + username + "';";
            PreparedStatement pst = (PreparedStatement)getConn().prepareStatement(query);

            rs = pst.executeQuery();
        }
        catch (Exception e){
            throw e;
        }
        
        return rs;
    }
}
