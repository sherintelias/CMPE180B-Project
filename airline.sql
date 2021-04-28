drop database if exists airline;
create database airline;
use airline;

CREATE TABLE user (
  user_id        varchar(25) not null,
  email_id      varchar(25) not null,
  name       varchar(25) not null, 
  password varchar(255) not null,
  birth_date date,
  primary key (user_id),
  unique (email_id)
);
