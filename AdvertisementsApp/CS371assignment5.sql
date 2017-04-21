
/*
 * Author:  jarrm5
 * Created: Apr 19, 2017


*1.
*An INNER JOIN only returns related records from both tables.  The INNER JOIN operator combines all rows that match in two related tables.
    
*Example: returns the names of all employees who have checking accounts (where the Account Type ID = CHK).

*SELECT C.CustFirst_Name,C.CustLast_Name,A.Account_ID,A.Account_Type_ID
*    FROM Customers C
*    INNER JOIN Accounts A
*    ON C.Customer_ID=A.Customer_ID
*    WHERE A.Account_Type_ID='CHK';

* Outer joins return all rows from at least one of the tables mentioned in the FROM clause, 
* as long as those rows meet any WHERE or HAVING search conditions. 
* All rows are retrieved from the left table referenced with a LEFT OUTER JOIN, and all rows from the right table referenced in a RIGHT OUTER JOIN. All rows from both tables are returned in a FULL OUTER JOIN.

* Example: An SQL statement using a left join that returns the number of transactions for each account.

*SELECT A.Account_ID, COUNT(T.TrnsAmount) NUM_Transactions
*    FROM Accounts A
*    LEFT JOIN Transactions T
*    ON T.Account_ID=A.Account_ID
*    GROUP BY A.Account_ID;

* The INTERSECT operator returns the common values between two sets

* Example: Using an INNER JOIN to emulate the INTERSECT operator (not supported in MYSQL)
* Returns all employee names that are also customers
*SELECT E.EmpFirst_Name First_Name, E.EmpLast_Name Last_Name
*    FROM Employees E
*    INNER JOIN Customers C
*    ON E.EmpFirst_Name=C.CustFirst_Name AND E.EmpLast_Name=C.CustLast_Name;



*2.
*Use UNION when you want to group similar tables with similar attributes (e.g. customers and employees). The UNION operator removes any duplicates. The tables generally do not have a relationship in the database.
*Use JOIN when you want to group similar tables with similar attributes (e.g. customers and employees) also. The tables generally do not have a relationship in the database.

*Example: Return distinct employee and customer names

*SELECT EmpFirst_Name First_Name, EmpLast_Name Last_Name
*    FROM Employees
*    UNION 
*    SELECT CustFirst_Name First_Name,CustLast_Name Last_Name
*    FROM Customers
*    ORDER BY Last_Name,First_Name;
*

*3.

*UPDATE Accounts SET AcctStatus = 'ACTIVE' WHERE Employee_ID = '1';

*4.

*DELETE E FROM employees E
*    INNER JOIN Branches B ON E.branch_ID = B.Branch_ID
/*    WHERE B.BranchCity = 'Salem';

