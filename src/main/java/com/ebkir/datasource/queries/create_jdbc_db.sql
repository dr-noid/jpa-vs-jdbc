create database jdbcdatabase;
use jdbcdatabase;

create table User(
	id int auto_increment not null primary key,
    firstname varchar(30) not null,
    lastname varchar(30) not null,
    age int not null,
    dateOfBirth date not null
);