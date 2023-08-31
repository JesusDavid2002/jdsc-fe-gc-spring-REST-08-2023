DROP table IF EXISTS trabajadores;

create table trabajadores (
	id int auto_increment,
	nombre varchar(250),
	trabajo ENUM('PROGRAMADOR', 'LIMPIADOR', 'CAMARERO', 'COCINERO'),
	salario double
);

insert into trabajadores (nombre, trabajo, salario) values ('Jesús', 'PROGRAMADOR', 2000);
insert into trabajadores (nombre, trabajo, salario) values ('María', 'COCINERO', 3000);
insert into trabajadores (nombre, trabajo, salario) values ('Juan', 'CAMARERO', 1200);
insert into trabajadores (nombre, trabajo, salario) values ('Carlos', 'LIMPIADOR', 900);
insert into trabajadores (nombre, trabajo, salario) values ('Lucia', 'CAMARERO', 1200);