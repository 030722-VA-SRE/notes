drop table  if exists employees;

create table if not exists employees(
	e_id SERIAL primary key,
	e_name VARCHAR(50) not null,
	e_username VARCHAR(50) unique,
	e_password VARCHAR(50) not null,
	e_role VARCHAR(50) not null,
	m_id INTEGER references employees(e_id)
);

insert into employees (e_name, e_username, e_password, e_role) values ('Enrollment Admin', 'ea_username', 'ea_pass', 'ADMIN');
insert into employees (e_name, e_username, e_password, e_role, m_id) values ('Test User', 'ts_username', 'ts_pass', 'BASIC_EMPLOYEE', 1);

