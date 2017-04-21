/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javax.swing.JFrame;
import db.*;

/**
 *
 * @author jarrm5
 */
public class Main {
    public static void main(String[] args){
        
        //String driver = "com.mysql.jdbc.Driver";
        String server = "kc-sce-appdb01";
        String dbName = "jarrm5_1";
        String dbUsername = "jarrm5_1";
        String dbPassword = "zuK2AMhttSIdGx2vrD3a";
        String portNumber = "3306";
        
        //Create the connection
        SQLHelper helper = new SQLHelper();
        
        try{
            
            helper.connect(dbUsername,dbPassword,server,portNumber,dbName);
            JFrame Login=new Login(helper);
            Login.setVisible(true);
        }
        catch(Exception e){
            
        }
    }
}
