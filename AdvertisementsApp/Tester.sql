--SELECT * FROM categories;
--SELECT * FROM statuses;
--SELECT * FROM users;


--SELECT A.Advertisement_ID,A.AdvTitle,A.AdvDetails,A.Price,S.Status_Name,A.AdvDateTime FROM Advertisements A 
--       INNER JOIN Statuses S ON A.Status_ID = S.Status_ID 
--       WHERE User_ID = 'rkale';


--INSERT INTO advertisements (AdvTitle,AdvDetails,AdvDateTime,Price,User_ID,Moderator_ID,Category_ID,Status_ID)
--                     VALUES('blah','blah','2005-07-07',0.00,'rkale',NULL,'CCA','PN');

--UPDATE advertisements SET AdvTitle = 'I''m giving away a go-kart' WHERE advertisement_id = '12';

SELECT * FROM Advertisements;
