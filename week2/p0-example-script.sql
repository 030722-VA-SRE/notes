create table items(
	id serial primary key,
	price numeric(7,2) not null,
	type varchar(20) not null unique
);

insert into items(type, price) values
	('coffee', 5.99),
	('mug', 1.99),
	('Elden Ring', 59.99);
	
insert into users (username, password, role) values ('tmetzke0', '5RhfjspS', 'ADMIN');
insert into users (username, password, role) values ('dleifer1', 'kdrq5QYwyP', 'BASIC_USER');
insert into users (username, password, role) values ('smattheissen2', 'qUR8Im8', 'BASIC_USER');