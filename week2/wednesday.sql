-- many-to-one/one-to-many

create table players(
	id serial primary key,
	name varchar(20),
	team_id integer references teams(id)
);

create table teams(
	id serial primary key,
	name varchar(20),
);

--many-to-many

create table people(
	id serial primary key,
	name varchar(20)
);

create table friends(
	friend1 integer references people(id),
	friend2 integer references people(id),
	primary key(friend1, friend2)
);

insert into people(name) values ('Kevin');
insert into people(name) values 
		('Jazlyn'),
		('Miguel');
insert into people (name) values ('Bat, vampire');
insert into people (name) values ('crested tinamou');
insert into people (name) values (' pilot');
insert into people (name) values ('Hoary marmot');
insert into people (name) values ('Zebra');
insert into people (name) values ('bandicoot');
insert into people (name) values ('crown of thorns');
insert into people (name) values ('Raccoon');
insert into people (name) values ('Phascogale');
insert into people (name) values ('barking');

--insert into friends(friend1, friend2) values (2, 11);
--insert into friends(friend1, friend2) values (2, 13);
--insert into friends(friend1, friend2) values (3, 11);
--insert into friends(friend1, friend2) values (11, 2);


insert into friends(friend1, friend2) values (14, 26);
insert into friends(friend1, friend2) values (16, 26);


update people set name = 'Henry' where id = 5;
--update people set name = 'Henry'; without a where clause all of the records get updated

delete from people where id = 1;
--delete from people;

truncate friends;

select * from people;
select name from people where id = 21;
select id, name from people where id = 21;
select * from people where id = 21;

select * from people where name = 'Kevin';

select * from people 
	where id > 20 and length(name) > 10
	order by name asc;
	

