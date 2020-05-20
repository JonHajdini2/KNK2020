DROP DATABASE IF EXISTS MenaxhimiDB;
CREATE DATABASE MenaxhimiDB;
USE MenaxhimiDB;



CREATE TABLE managers (
                          username     VARCHAR(20) NOT NULL,
                          uemail       text NOT NULL ,
                          upassword 	text NOT NULL

);



CREATE TABLE employees (
                           Employee_id INTEGER,
                           Employee_name VARCHAR(20),
                           Employee_surname VARCHAR(20),
                           Employee_birthday DATE,
                           status VARCHAR(30),
                           Employee_number VARCHAR(15),
                           Employee_email VARCHAR(30),
                           Employee_address VARCHAR(30),
                           Employee_hours INT,
                           PRIMARY KEY (Employee_id)
);



CREATE TABLE contracts (
                           Contract_date_begin DATE,
                           Contract_date_due DATE,
                           job_title VARCHAR(30),
                           department VARCHAR(30),
                           EmpID INTEGER,
                           empSalary VARCHAR(30),
                           FOREIGN KEY (EmpID)
                               REFERENCES employees (Employee_id)

);





CREATE TABLE payment (
                         Employee_netto_salary REAL,
                         Payment_bonus REAL,
                         tax_ammount REAL,
                         empId INTEGER,
                         FOREIGN KEY (empId)
                             REFERENCES employees (Employee_id)
);



