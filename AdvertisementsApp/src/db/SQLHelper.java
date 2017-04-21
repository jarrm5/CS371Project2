/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class SQLHelper {
    
    private Connection connection;
    
    
    public SQLHelper(){}
    
    public void connect(String userName, String password, String serverName, String portNumber, String dbName) throws SQLException, InstantiationException, IllegalAccessException {
        System.out.println("Loading driver...");

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }

        java.sql.Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", userName);
        connectionProps.put("password", password);

        conn = DriverManager.getConnection(
                "jdbc:mysql://"
                + serverName
                + ":" + portNumber + "/" + dbName,
                connectionProps);

        System.out.println("Connected to database");
        this.connection=conn;
    }
    //Get the user name from the database
    public ResultSet getUserName(String username, String type) throws Exception{
         
        ResultSet rs;
        
        try{
            String query = "SELECT * FROM " + type + "s WHERE User_id = '" + username + "';";
            PreparedStatement pst = connection.prepareStatement(query);

            rs = pst.executeQuery();
        }
        catch (Exception e){
            throw e;
        }
        return rs;
    }
    //Get all active advertisements for the user from the DB
    public Object[][] getAdvertisements() {
        PreparedStatement stmt = null;
        Object[][] result=new Object[][]{};
        
        String query = "SELECT AdvTitle,AdvDetails,Price,AdvDateTime FROM Advertisements WHERE status_id = 'AC';";

        try {
            stmt=connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            int count = getResultSetSize(rs);
            result=getAdvertisementData(count,rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return result;
        }
        return result;
    }
    //Convert the result set into advertisement objects
    private Object[][] getAdvertisementData(int count,ResultSet rs) throws SQLException {
        Object[][] result=new Object[count][4];
        int index=0;
        do {
            String title = rs.getString("AdvTitle");
            String details = rs.getString("AdvDetails");
            double price =  rs.getDouble("Price");
            Date date = rs.getDate("AdvDateTime");

            Advertisement ad=new Advertisement(title,details,price,date);
            result[index++]=ad.toArray();
        }
        while(rs.next());
        return result;
    } 
    private int getResultSetSize(ResultSet rs) {
        int count = 0;
        try {
            while (rs.next()) {
                count++;
            }
            rs.first();
        } catch (SQLException e) {

        }
        return count;
    }
}
