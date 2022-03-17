create table items(
	id serial primary key,
	price numeric(7,2) not null,
	type varchar(20) not null unique
);

insert into items(type, price) values
	('coffee', 5.99),
	('mug', 1.99),
	('Elden Ring', 59.99);