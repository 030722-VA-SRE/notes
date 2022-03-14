-- This is a single comment
/*
	This
	is
	a
	multiline
	comment
	
	naming convention is snake_case, due to the lack of case sensitivity
*/

--create database mydb;

--create schema task_app;
--drop schema task_app;
/*
 * User model
 * int id -- SERIAL
 * String username -- VARCHAR
 * String password -- VARCHAR
 */
drop table if exists users;
create table if not exists users(
	id serial primary key,
	username varchar(30) unique,
	password varchar(30) not null
);
/*
	Task Model
	int id  -- SERIAL
	String name -- TEXT
	LocalDate dueDate -- DATE
	boolean isCompleted -- BOOLEAN
	User userAssigned; INTEGER user_id
*/

drop table if exists tasks;
create table if not exists tasks(
	id serial primary key,
	name text,
	due_date date default current_date,
	is_completed boolean,
	user_id integer references users(id)
);
