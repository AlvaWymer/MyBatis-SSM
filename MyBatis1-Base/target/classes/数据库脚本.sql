DROP DATABASE IF EXISTS mldnbatis ;
CREATE DATABASE mldnbatis CHARACTER SET UTF8 ;
USE mldnbatis ;
CREATE TABLE member(
	mid			VARCHAR(50) ,
	name		VARCHAR(50) ,
	age			INT ,
	birthday	DATETIME ,
	salary		DOUBLE ,
	note		TEXT ,
	CONSTRAINT pk_mid PRIMARY KEY(mid)
) engine="innodb";
