drop database if exists MATCHING;
create database MATCHING;

drop table if exists member_info;
create table member_info
(
	seq bigint auto_increment primary key,
	nickname varchar(10) not null,
	sex char not null,
	age tinyint not null,
	country char(2) not null,
	update_time datetime not null,
	insert_time datetime null,
	constraint MEMBER_INFO_nickname_uindex
		unique (nickname)
);

