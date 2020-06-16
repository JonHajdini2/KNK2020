DROP DATABASE IF EXISTS MenaxhimiDB;
CREATE DATABASE MenaxhimiDB;
USE MenaxhimiDB;



CREATE TABLE managers (
                          username     VARCHAR(20) NOT NULL,
                          uemail       text NOT NULL ,
                          upassword 	text NOT NULL

)ENGINE=INNODB;



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
)ENGINE=INNODB;



CREATE TABLE contracts (
                           Contract_date_begin DATE,
                           Contract_date_due DATE,
                           job_title VARCHAR(30),
                           department VARCHAR(30),
                           EmpID INTEGER,
                           empSalary VARCHAR(30),
                           FOREIGN KEY (EmpID)
                               REFERENCES employees (Employee_id)
							   ON DELETE CASCADE

) ENGINE=INNODB;





CREATE TABLE payment (
                         Employee_netto_salary REAL,
                         Payment_bonus REAL,
                         tax_ammount REAL,
                         empId INTEGER,
                         FOREIGN KEY (empId)
                             REFERENCES employees (Employee_id)
                             ON DELETE CASCADE
) ENGINE=INNODB;


INSERT INTO employees(Employee_id, Employee_name, Employee_surname,	Employee_birthday,status,Employee_number, Employee_email, Employee_address, Employee_hours)  
VALUES  (1, "Lirim", "Beka", "2000/08/14", false, "048484848", "beka.lirim@gmail.com", "street", "8");      



INSERT INTO payment(Employee_netto_salary, payment_bonus, tax_ammount,empId)
VALUES (400, 200, 100, 1);

INSERT INTO contracts(Contract_date_begin, Contract_date_due, job_title, department,EmpId,empSalary)
VALUES ("2020/02/20", "2021/02/20", ".Net Programmer", "Computer Enginner", 1, 500);




