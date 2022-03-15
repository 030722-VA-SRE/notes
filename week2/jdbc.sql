create table if not exists tasks(
	/*
	 * int id
	 * String description
	 * boolean isCompleted
	 * User userAssigned
	 */
	id serial primary key,
	description varchar(30) not null,
	is_completed boolean default false,
	user_assigned_id integer references users(id)
);


create table if not exists users(
	/*
	 * int id
	 * String username
	 * String password
	 */
	id serial primary key,
	username varchar(20) unique not null,
	password varchar(20) not null
);

-- create user
insert into users(username, password) values('henry', 'henrypass');

-- retrieve all users 
select * from users;

-- retrieve one user by id/username 
select * from users where id = 1;
select * from users where username='kev';

-- update a user based on id 
update users set username = 'kev1', password = 'kevpass1'  where id = 1;

-- delete a user based on id
delete from users where id = 1;

-- create a tasks 
insert into tasks(description, is_completed, user_assigned_id) values ('task1',true,1);
insert into tasks(description, user_assigned_id) values ('task2',1);

-- retrieve all tasks 
select * from tasks;

-- retrieve a task by id 
select * from tasks where id = 1;

-- retrieve tasks based on completion
select * from tasks where is_completed = true;

-- retrieving tasks for a specific user
select * from tasks where user_assigned_id = 1;

-- retrieving tasks for a specific user and not completed
select * from tasks where user_assigned_id = 1 and is_completed = false;
