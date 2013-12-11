/* Run as an Admin in mysql. ( root? ) */

create database UserReg;
use UserReg;
create Table Users 
(
userId int(16) not null auto_increment primary key, 
username varchar(16), password varchar(12), 
firstName varchar(20), lastName varchar(25), 
email varchar(50),
address varchar(10), 
street varchar(30), 
city varchar(20), 
state varchar(2), 
zipcode varchar(9), 
role boolean default false,
sessionId int(16)
);

create table Session (sessionId int(16), userId int(16), stamp timestamp);

create user 'webuser'@'localhost' identified by 'abc123/?';

grant all privileges on UserReg.* to 'webuser'@'localhost';


/* CONNECTION STRING FOR JDBC */
/*

"jdbc:mysql://localhost/userreg?user=webuser&password=abc123/?"

*/