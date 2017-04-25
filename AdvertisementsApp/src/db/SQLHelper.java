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
import java.util.LinkedList;
import java.util.Properties;

public class SQLHelper {
    
    private Connection connection;
    
    public class Record{
        public String ID;
        public String Name;
        
        public Record(String ID,String Name){
            this.ID=ID;
            this.Name=Name;
        }
        
        public String toString(){
            return Name;
        }
    }
    
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
    //Get the category names for the dropdown list filter
    public LinkedList<Record> getCategoryNames(){
     LinkedList<Record> records=new LinkedList();
        PreparedStatement stmt = null;
        
        String query = "SELECT * FROM categories";

        try {
            stmt=connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            String category_id = rs.getString("Category_ID");
            String category_name = rs.getString("Cat_Name");
            Record record=new Record(category_id,category_name);
            records.add(record);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return records;
        }
        return records;
 }
    //Get all active advertisements for the user from the DB
    //Sometimes, we will need extra filters with an AND statement (i.e. filtering by categories
    public Object[][] getAdvertisements(String AND) {
        PreparedStatement stmt = null;
        Object[][] result=new Object[][]{};
        
        String query = "SELECT AdvTitle,AdvDetails,Price,AdvDateTime FROM Advertisements WHERE status_id = 'AC'";
        
        //If an AND statement was provided, append it to the query
        if(!AND.equals("")){
            query += AND;
        }

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
            result[index++]=ad.toAdArray();
        }
        while(rs.next());
        return result;
    }
    public Object[][] getMyAdvertisements(String userID) {
        PreparedStatement stmt = null;
        Object[][] result=new Object[][]{};
        
        String query = "SELECT A.Advertisement_ID,A.AdvTitle,A.AdvDetails,A.Price,S.Status_Name,A.AdvDateTime FROM Advertisements A INNER JOIN Statuses S ON A.Status_ID = S.Status_ID WHERE User_ID = ?;";

        try {
            stmt=connection.prepareStatement(query);
            stmt.setString(1,userID);
            ResultSet rs = stmt.executeQuery();
            int count = getResultSetSize(rs);
            result=getMyAdvertisementData(count,rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return result;
        }
        return result;
    }
    //Convert the result set into the user's advertisement objects
    private Object[][] getMyAdvertisementData(int count,ResultSet rs) throws SQLException {
        Object[][] result=new Object[count][4];
        int index=0;
        do {
            int adID = rs.getInt("Advertisement_ID");
            String title = rs.getString("AdvTitle");
            String details = rs.getString("AdvDetails");
            double price =  rs.getDouble("Price");
            String status = rs.getString("Status_Name");
            Date date = rs.getDate("AdvDateTime");

            Advertisement ad=new Advertisement(adID,title,details,price,status,date);
            result[index++]=ad.toMyAdArray();
        }
        while(rs.next());
        return result;
    }
    public Object[][] getModeratorAdvertisements(String moderatorID) {
        PreparedStatement stmt = null;
        Object[][] result=new Object[][]{};
        
        String query = "SELECT A.Advertisement_ID,A.AdvTitle,A.AdvDetails,A.Price,S.Status_Name,A.AdvDateTime,A.User_ID FROM Advertisements A INNER JOIN Statuses S ON A.Status_ID = S.Status_ID WHERE moderator_ID = ?;";

        try {
            stmt=connection.prepareStatement(query);
            stmt.setString(1,moderatorID);
            ResultSet rs = stmt.executeQuery();
            int count = getResultSetSize(rs);
            result=getModeratorAdvertisementData(count,rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return result;
        }
        return result;
    }
    //Convert the result set into the user's advertisement objects
    private Object[][] getModeratorAdvertisementData(int count,ResultSet rs) throws SQLException {
        Object[][] result=new Object[count][7];
        int index=0;
        do {
            int adID = rs.getInt("Advertisement_ID");
            String title = rs.getString("AdvTitle");
            String details = rs.getString("AdvDetails");
            double price =  rs.getDouble("Price");
            String status = rs.getString("Status_Name");
            Date date = rs.getDate("AdvDateTime");
            String user_id = rs.getString("User_ID");

            Advertisement ad=new Advertisement(adID,title,details,price,status,date,user_id);
            result[index++]=ad.toModArray();
        }
        while(rs.next());
        return result;
    }
    //deleting an ad from the userAd screen.
    public boolean deleteAdvertisement(String ad_id) {
        PreparedStatement stmt = null;
        
        String query = "DELETE FROM Advertisements WHERE Advertisement_ID=?;";

        try {
            stmt=connection.prepareStatement(query);
            stmt.setString(1,ad_id);     
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean updateAdvertisement(String ad_id,String title,String details,double price) {
        PreparedStatement stmt = null;
        
        String query = "UPDATE Advertisements SET AdvTitle=?,AdvDetails=?,Price=? WHERE Advertisement_ID=?;";

        try {
            stmt=connection.prepareStatement(query);
            stmt.setString(1,title);
            stmt.setString(2,details);  
            stmt.setDouble(3,price);  
            stmt.setString(4,ad_id);     
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    //Add advertisement through the InsertAd screen
    public boolean addAdvertisement(String title,String details,double price,String user_id,String category_id) {
        PreparedStatement stmt = null;
        
        //Insert using all the arguments supplied
        //Always assign advDate to today's date
        //Never assign a moderator_id on the insert
        //Always give a status_id of pending ('PN')
        String query = "INSERT INTO advertisements (AdvTitle,AdvDetails,AdvDateTime,Price,User_ID,Moderator_ID,Category_ID,Status_ID)\n" +
"                                            VALUES(?,?,NOW(),?,?,NULL,?,'PN');";

        try {
            stmt=connection.prepareStatement(query);
            stmt.setString(1,title); //binding the parameter with the given string
            stmt.setString(2,details);
            stmt.setDouble(3,price);
            stmt.setString(4,user_id);
            stmt.setString(5,category_id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    //Get all active advertisements for the user from the DB
    //Sometimes, we will need extra filters with an AND statement (i.e. filtering by categories
    public Object[][] getUnclaimedAdvertisements(String AND) {
        PreparedStatement stmt = null;
        Object[][] result=new Object[][]{};
        
        String query = "SELECT Advertisement_ID,AdvTitle,AdvDetails,Price,AdvDateTime,User_ID FROM Advertisements WHERE status_id = 'PN'";
        
        //If an AND statement was provided, append it to the query
        if(!AND.equals("")){
            query += AND;
        }

        try {
            stmt=connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            int count = getResultSetSize(rs);
            result=getUnclaimedAdvertisementData(count,rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return result;
        }
        return result;
    }
    //Convert the result set into advertisement objects
    private Object[][] getUnclaimedAdvertisementData(int count,ResultSet rs) throws SQLException {
        Object[][] result=new Object[count][6];
        int index=0;
        do {
            int ad_id = rs.getInt("Advertisement_ID");
            String title = rs.getString("AdvTitle");
            String details = rs.getString("AdvDetails");
            double price =  rs.getDouble("Price");
            Date date = rs.getDate("AdvDateTime");
            String user_id = rs.getString("User_ID");

            Advertisement ad=new Advertisement(ad_id,title,details,price,date,user_id);
            result[index++]=ad.toUnclaimAdArray();
        }
        while(rs.next());
        return result;
    }
    //claiming an ad from the ModeratorAds screen.
    public boolean claimAdvertisement(String ad_id, String moderator_id) {
        PreparedStatement stmt = null;
        
        String query = "UPDATE Advertisements SET moderator_ID=? WHERE Advertisement_ID=?;";

        try {
            stmt=connection.prepareStatement(query);
            stmt.setString(1,moderator_id);
            stmt.setString(2,ad_id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean approveAdvertisement(String ad_id) {
        PreparedStatement stmt = null;
        
        String query = "UPDATE Advertisements SET status_ID='AC' WHERE Advertisement_ID=?;";

        try {
            stmt=connection.prepareStatement(query);
            stmt.setString(1,ad_id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
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
