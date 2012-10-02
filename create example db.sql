create database newtest;
use newtest;

create table IdData(
	id int not null unique primary key,
	name varchar(255) not null default 'John Doe'
);

create table UserData(
	id int not null unique primary key,
	user varchar(255),
	pass varchar(255),
	email varchar(255),
	mobnum varchar(255),
	homenum varchar(255),
	address varchar(255) default 'Metro Manila'
);

create table GroupData(
	GroupID int not null unique primary key auto_increment,
	GroupName varchar(255)
);

create table GroupPerson(
	gpID int not null primary key auto_increment,
	UserID int not null,
	GroupID int not null,
	foreign key (UserID) references UserData(id),
	foreign key (GroupID) references GroupData(GroupID)
);

create table UserCal(
	eventID int not null primary key auto_increment,
	eventTime int not null,
	eventName varchar(255),
	UserID int not null,
	foreign key (UserID) references UserData(id)
);

insert into UserData(id,user,pass,email,mobnum,homenum,address)
values (102485, 'd2dcontre','d2dcontre','jon.matias@outlook.com',
'09219664091','022129010','greenwoods ave.');
insert into UserData(id,user,pass,email,mobnum,homenum,address)
values (100651, 'ricebash','ricebash','rb@e.com','09219664091',
'022129010','greenwoods ave.');
insert into UserData(id,user,pass,email,mobnum,homenum,address)
values (102269, 'rallo','rallo','rall@gmail.com','09219664091',
'022129010','greenwoods ave.');

insert into GroupData(GroupName) values ("The Pretenders");
insert into GroupData(GroupName) values ("Fast Five");
insert into GroupData(GroupName) values ("The Wildmen");

insert into GroupPerson(UserID,GroupID) values (102485,1); #pretenders
insert into GroupPerson(UserID,GroupID) values (100651,1); #pretenders
insert into GroupPerson(UserID,GroupID) values (102269,1); #pretenders
insert into GroupPerson(UserID,GroupID) values (100651,2);
insert into GroupPerson(UserID,GroupID) values (102269,2);
insert into GroupPerson(UserID,GroupID) values (102269,3);

insert into IdData(id,name)
values (102485,'Jonathan Matias');
insert into IdData(id,name)
values (100651,'Kristian Calalang');
insert into IdData(id,name)
values (102269,'Rall Llobrera');

insert into IdData(id,name)
values (100100,'Ban Ki Moon');
#delete from IdData where id = 100100;
#delete from UserData where id = 100100;
#delete from groupperson where userid = 100100;

/*insert into UserCal(eventTime,eventName,UserID)
values (7,'TH31',);*/

/*select GroupPerson.GroupID from GroupPerson 
join userdata on groupperson.userid = userdata.id where id = 102485;*/

/*select GroupData.GroupID,GroupData.GroupName from GroupData 
join groupperson on groupperson.groupid = groupdata.groupid 
join userdata on groupperson.userid = userdata.id where id = 100100;*/#102269;102485;

#select groupid from groupdata where groupname = 'Fast Five' order by groupid desc;
#insert into GroupData(GroupName) values ('Fast Five');
#delete from groupdata where groupid = 5;

/*select iddata.name from iddata 
join groupperson on groupperson.userid = iddata.id 
join groupdata on groupdata.groupid = groupperson.groupid
where groupdata.groupid = 1;

select iddata.name from iddata
join groupperson on groupperson.userid = iddata.id
join groupdata on groupdata.groupid = groupperson.groupid
where groupdata.groupid = 2;*/

/*
drop table GroupPerson;
drop table GroupData;
drop table userdata;*/
#drop table userCal;