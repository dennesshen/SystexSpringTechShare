
INSERT INTO INVESTBANK(bank_name) VALUES ('花旗');
INSERT INTO INVESTBANK(bank_name) VALUES ('摩根');   
INSERT INTO INVESTBANK(bank_name) VALUES ('瑞士信託');   

INSERT INTO FUNDMANAGER(manager_name, balance, investbank_id) VALUES ('Christine', 1000000, 1);   
INSERT INTO FUNDMANAGER(manager_name, balance, investbank_id) VALUES ('Bob', 2100000, 1);   
INSERT INTO FUNDMANAGER(manager_name, balance, investbank_id) VALUES ('John', 1400000, 2);   
INSERT INTO FUNDMANAGER(manager_name, balance, investbank_id) VALUES ('Eason', 3300000, 1);   
INSERT INTO FUNDMANAGER(manager_name, balance, investbank_id) VALUES ('May', 1100000, 3);   


INSERT INTO PERSONINFO(idNumber, age, address, fundmanager_id) VALUES ('T22345678', 30, '台北市大同區長安東路3號', 1);   
INSERT INTO PERSONINFO(idNumber, age, address, fundmanager_id) VALUES ('T12345678', 48, '台北市大同區長安東路4號', 2);   


