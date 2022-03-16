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
insert into tasks(description, user_assigned_id) values ('task3',2);
insert into tasks(description, user_assigned_id) values ('task4',3);
insert into tasks(description, user_assigned_id) values ('task5',3);
insert into tasks(description, user_assigned_id) values ('task6',2);

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

-- joins
select * from tasks
join users
on tasks.user_assigned_id = users.id ;

-- referring to tasks as t and users table as u
select t.id, t.description , t.is_completed , u.username  from tasks t
join users u 
on t.user_assigned_id = u.id;

-- union
select * from tasks where user_assigned_id = 1
union 
select * from tasks where user_assigned_id = 2;

-- union all
select * from tasks where user_assigned_id = 1
union all
select * from tasks where is_completed = true;

-- union filters for duplicates(ie: records that match either criteria)
select * from tasks where user_assigned_id = 1
union
select * from tasks where is_completed = true;

-- intersect returns records that match both criteria
select * from tasks where user_assigned_id = 1
intersect 
select * from tasks where is_completed = true;

-- except returns records that match the first criteria but not the second
select * from tasks where user_assigned_id = 1
except
select * from tasks where is_completed = true;