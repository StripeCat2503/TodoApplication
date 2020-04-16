create database TodoDB
use TodoDB

create table tblTodos(
	id bigint identity primary key,
	description nvarchar(500),
	status int,
	target_date date,
	title nvarchar(50),
	username varchar(30),
	foreign key(username) references tblUser(username) 
)

create table tblUser(
	username varchar(30) primary key,
	password varchar(30),
	firstName nvarchar(30),
	lastName nvarchar(30)
)