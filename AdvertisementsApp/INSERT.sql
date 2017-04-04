/**
 * Author:  jarrm5
 * Created: Apr 3, 2017
 */
--INSERT INTO Categories(Category_ID,Cat_Name) VALUES('CAT','Cars and Trucks'),('HOU','Housing'),('ELC','Electronics'),('CCA','Child Care');

--INSERT INTO Statuses(Status_ID,Status_Name) VALUES('PN','Pending'),('AC','Active'),('DI','Disapproved');

--INSERT INTO Users(User_ID,UsrFirst_Name,UsrLast_Name) VALUES('Jsmith','John','Smith'),('ajackson','Ann','Jackson'),('rkale','Rania','Kale'),('Sali','Samir','Ali');

--INSERT INTO Moderators(User_ID) VALUES('Jsmith'),('ajackson');

--INSERT INTO Advertisements(AdvTitle,AdvDetails,AdvDateTime,Price,Category_ID,User_ID,Moderator_ID,Status_ID)
--                    VALUES('2010 Sedan Subaru','2010 Sedan car in great shape for sale','2017-02-10',6000.00,'CAT','rkale','jsmith','AC'),
--                          ('Nice Office Desk','Nice office desk for sale','2017-02-15',50.25,'HOU','rkale','jsmith','AC'),
--                          ('Smart LG TV for $200 ONLY!','Smart LG TV 52 inches! Really cheap!','2017-03-15',200.00,'ELC','sali','jsmith','AC' ),
--                          ('HD Tablet for $25 only','Amazon Fire Tablet HD','2017-03-20',25.00,'ELC','rkale',null,'PN'),
--                          ('Laptop for $100', 'Amazing HD laptop for $100','2017-03-20',100.00,'ELC','rkale',null,'PN');
