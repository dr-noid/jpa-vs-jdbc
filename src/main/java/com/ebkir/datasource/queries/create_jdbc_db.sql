use jdbcdatabase;

drop table User;
create table User(
	id int auto_increment not null primary key,
    firstname varchar(30) not null,
    lastname varchar(30) not null,
    age int not null,
    dateOfBirth date not null
);

select * from user;

-- insert into User(firstname, lastname, age, dateOfBirth)
-- values("updatedfirstname", "updatedlastname", 44, curdate());

-- update User
-- set User.firstname = "updatedfirstname", User.lastname = "updatedlastname",
-- 	User.age = 44, User.dateOfBirth = curdate()
-- where User.id = 1;
