CREATE TABLE EMPLOYEE(
    id INT AUTO_INCREMENT  PRIMARY KEY,
	employee_name varchar(50) NOT NULL, 
	employee_position varchar(50),
	employee_salary int 
);


CREATE TABLE INVESTBANK(
    id INT AUTO_INCREMENT PRIMARY KEY,
	bank_name varchar(50) UNIQUE NOT NULL
);


CREATE TABLE FUNDMANGER(
    id INT AUTO_INCREMENT PRIMARY KEY,
	manager_name VARCHAR(50) NOT NULL, 
	balance INT,
	investbank_id INT,
	FOREIGN KEY(investbank_id) REFERENCES INVESTBANK(id)
);

CREATE TABLE PERSONINFO(
    id INT AUTO_INCREMENT PRIMARY KEY,
	idNumber varchar(50) UNIQUE NOT NULL,
	age INT NOT NULL,
	address varchar(50),
	fundmanger_id INT UNIQUE Not null, 
	FOREIGN KEY(fundmanger_id) REFERENCES FUNDMANGER(id)
);