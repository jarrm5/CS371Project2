/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Date;

public class Advertisement {
    private int AdvertisementID;
    private String AdvTitle;
    private String AdvDetails;
    private Date AdvDateTime;
    private double Price;
    private int UserID;
    private int ModeratorID;
    private int CategoryID;
    private int StatusID;
    private String StatusName;
    
    public Advertisement () {}
    
    public Advertisement(String AdvTitle,String AdvDetails,double Price,Date AdvDateTime){
        this.AdvTitle = AdvTitle;
        this.AdvDetails = AdvDetails;
        this.Price = Price;
        this.AdvDateTime = AdvDateTime;
    }
    
    public Advertisement(int AdvertisementID,String AdvTitle,String AdvDetails,double Price,String StatusName,Date AdvDateTime){
        this.AdvertisementID = AdvertisementID;
        this.AdvTitle = AdvTitle;
        this.AdvDetails = AdvDetails;
        this.Price = Price;
        this.StatusName = StatusName;
        this.AdvDateTime = AdvDateTime;
    }
    
    public Advertisement(int AdvertisementID, String AdvTitle,String AdvDetails,Date AdvDateTime,double Price,int UserID,int ModeratorID,int CategoryID,int StatusID){
        this.AdvertisementID = AdvertisementID;
        this.AdvTitle = AdvTitle;
        this.AdvDetails = AdvDetails;
        this.AdvDateTime = AdvDateTime;
        this.Price = Price;
        this.UserID = UserID;
        this.ModeratorID = ModeratorID;
        this.CategoryID = CategoryID;
        this.StatusID = StatusID;
    }
    public int getAdvertisementID(){
        return AdvertisementID;
    }
    public void setAdvertisementID(int AdvertisementID){
        this.AdvertisementID = AdvertisementID;
    }
    public String getAdvTitle(){
        return AdvTitle;
    }
    public void setAdvTitle(String AdvTitle){
        this.AdvTitle = AdvTitle;
    }
    public String getAdvDetails(){
        return AdvDetails;
    }
    public void setAdvDetails(String AdvDetails){
        this.AdvDetails = AdvDetails;
    }
    public Date getAdvDateTime(){
        return AdvDateTime;
    }
    public void setAdvDateTime(Date AdvDateTime){
        this.AdvDateTime = AdvDateTime;
    }
    public double getPrice(){
        return Price;
    }
    public void setPrice(int Price){
        this.Price = Price;
    }
    public int getUserID(){
        return UserID;
    }
    public void setUserID(int UserID){
        this.UserID = UserID;
    }
    public int getModeratorID(){
        return ModeratorID;
    }
    public void setModeratorID(int ModeratorID){
        this.ModeratorID = ModeratorID;
    }
    public int getCategoryID(){
        return CategoryID;
    }
    public void setCategoryID(int CategoryID){
        this.CategoryID = CategoryID;
    }
    public int getStatusID(){
        return StatusID;
    }
    public void setStatusID(int StatusID){
        this.StatusID = StatusID;
    }
    public String getStatusName(){
        return StatusName;
    }
    public void setStatusName(String StatusName){
        this.StatusName = StatusName;
    }
    Object[] toAdArray(){
        return new Object[]{AdvTitle,AdvDetails,Price,AdvDateTime};
    }
    Object[] toMyAdArray(){
        return new Object[]{AdvertisementID,AdvTitle,AdvDetails,Price,StatusName,AdvDateTime};
    }   
}
