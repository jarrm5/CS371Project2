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
    private String UserID;
    private String ModeratorID;
    private String CategoryID;
    private String StatusID;
    private String StatusName;
    
    public Advertisement () {}
    
    public Advertisement(String AdvTitle,String AdvDetails,double Price,Date AdvDateTime){
        this.AdvTitle = AdvTitle;
        this.AdvDetails = AdvDetails;
        this.Price = Price;
        this.AdvDateTime = AdvDateTime;
    }
    
    public Advertisement(int AdvertisementID,String AdvTitle,String AdvDetails,double Price,Date AdvDateTime,String UserID){
        this.AdvertisementID = AdvertisementID;
        this.AdvTitle = AdvTitle;
        this.AdvDetails = AdvDetails;
        this.Price = Price;
        this.AdvDateTime = AdvDateTime;
        this.UserID = UserID;
    }
    
    public Advertisement(int AdvertisementID,String AdvTitle,String AdvDetails,double Price,String StatusName,Date AdvDateTime,String UserID){
        this.AdvertisementID = AdvertisementID;
        this.AdvTitle = AdvTitle;
        this.AdvDetails = AdvDetails;
        this.Price = Price;
        this.AdvDateTime = AdvDateTime;
        this.StatusName = StatusName;
        this.UserID = UserID;
    }
    
    public Advertisement(int AdvertisementID,String AdvTitle,String AdvDetails,double Price,String StatusName,Date AdvDateTime){
        this.AdvertisementID = AdvertisementID;
        this.AdvTitle = AdvTitle;
        this.AdvDetails = AdvDetails;
        this.Price = Price;
        this.StatusName = StatusName;
        this.AdvDateTime = AdvDateTime;
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
    public String getUserID(){
        return UserID;
    }
    public void setUserID(String UserID){
        this.UserID = UserID;
    }
    public String getModeratorID(){
        return ModeratorID;
    }
    public void setModeratorID(String ModeratorID){
        this.ModeratorID = ModeratorID;
    }
    public String getCategoryID(){
        return CategoryID;
    }
    public void setCategoryID(String CategoryID){
        this.CategoryID = CategoryID;
    }
    public String getStatusID(){
        return StatusID;
    }
    public void setStatusID(String StatusID){
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
    Object[] toUnclaimAdArray(){
        return new Object[]{AdvertisementID,AdvTitle,AdvDetails,Price,AdvDateTime,UserID};
    }
    Object[] toModArray(){
        return new Object[]{AdvertisementID,AdvTitle,AdvDetails,Price,StatusName,AdvDateTime,UserID};
    }
}
