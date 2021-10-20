create database jpadatabase;
use jpadatabase;

create table User(
	id int not null primary key,
    firstname varchar(30) not null,
    lastname varchar(30) not null,
    age int not null,
    dateOfBirth date not null
);
