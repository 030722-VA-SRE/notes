# SQL

### Relations

* Explain what SQL is. What are some SQL databases?

* How is data structured in a SQL database?

* What is an ERD? How is it useful?

* What are the different multiplicity relationships? How would you create these relations?

* What kind of relationship would exist between Students and Classes? Students and Textbooks?

* Explain the concept of referential integrity

* What is a cascade delete?
    
* List the integrity constraints
    
* Define the word "schema"
    
* What is a candidate key? What about a surrogate key?


### Sublanguages & Queries
    
* What are the 5 sublanguages of SQL? List some commands for each
    
* What is the difference between DELETE, DROP, and TRUNCATE commands?
    
* What are some SQL clauses you can use with SELECT statements?
   

* What is the difference between joins and set operators?

* What are the types of joins? Explain the differences.
 

* Explain the difference between UNION, UNION ALL, and INTERSECT

### Transactions

* What are the properties a transaction must follow?
 

* Explain the different isolation levels. What read phenomena do each prevent?

### Practicals

Given the following table 'employees'...

| id | firstName | lastName | salary | dept |
| --- | -------- | -------- | ------ | ---- |
| 1  | Michael   | Scott    | 65     | Sales|
| 2  | Dwight    | Schrute  | 75     | Sales|
| 3  | Toby      | Flenderson| 80    | HR  |
| 4  | Jim       | Halpert  | 90     | Sales|
| 5  | Oscar     | Martinez | 90     | Accounting |
| 6  | Angela    | Martin   | 75     | Accounting |
| 7  | Kevin     | Malone   | 70     | Accounting |
| 8  | Holly     | Flax     | 60     | HR |
| 9  | Creed     | Branton  | 70     | Quality Assurance |

* Write a query to find all data in the table

* Write a query to find employees with a salary over 75

* Write a query to find employees whose first name contains an 'e' or whose last name begins with 'S'\

* Write a query to find the first name of all employees who do not work in accounting

* Write a query to find the average salary of all employees whose last names begin with 'M'

* Write a query to find the highest paid salesperson

* Write a query to combine the resultsets of any two previous queries

* Remove all members of accounting from the database


* Given removing the dept column from the employees table and creating a table 'department' and linking the two via a foreign key relationship

| dept_id | name |
| ------- | ---  |
| 1       | Sales |
| 2       | HR   |
| 3       | Accounting |
| 4       | Customer Service |

* Write a query to find the salary of the lowest paid salesperson (HINT: use a join)

* Write a query to find the average salary of each department

* Write a query to find all possible combinations of employees and departments. How many records do you expect?

* Change the name of department 4 to 'Quality Assurance'

* Remove both tables

# JDBC
1.	What is JDBC?
2.	What are the core interfaces / classes in JDBC?
3.	What is a stored procedure and how would you call it in Java?
4.	What is the difference between Statement and PreparedStatement?
5.	Steps to executing an SQL query using JDBC?

# AWS

### Cloud / AWS Overview
* How would you describe AWS? What is "the cloud" or "cloud computing" and why is it so popular now?

* Define Infrastructure, Platform, and Software as a Service
 
* What's the difference between a Region and an Availability Zone (AZ)?
 
* How are you charged for using AWS services? Does it vary by service?
 
* Different ways to interact with AWS services?


### EC2

* What are the configuration options for EC2?
 
* What are the different EC2 instance sizes/types?
 
* Once you create an EC2, how to connect to it?
 
* What are Security Groups? When defining a rule for a security group, what 3 things do you need to specify?
  
* What's the difference between scalability, elasticity, and resiliency?
 
* Ways of paying for EC2?


### RDS

* What's an RDS?

* Which vendors are supported?


# UNIX/LINUX

* What are the differences between a Thread and Process and a Service?

* Write a basic bash script 
    * ie: installing java/maven/git to an ec2
    * if you're feeling ambitious, a script that would delete a file if it exists


