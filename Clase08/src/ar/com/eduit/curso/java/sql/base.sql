/*
    Carlos Ríos carlos.rios@educacionit.com

    remotemysql.com
    base: XYi1Z7S7xL
    user: XYi1Z7S7xL
    pass: Bg1FebesWT
    requiere driver 5.140 o superior
*/
drop database if exists colegio;
create database colegio;
use colegio;
drop table if exists alumnos;
drop table if exists cursos;
create table cursos(
    id int auto_increment primary key,
    titulo varchar(25) not null,
    profesor varchar(25) not null,
    dia enum('lunes','martes','miércoles','jueves','viernes'),
    turno enum('mañana','tarde','noche')
);
create table alumnos(
    id int auto_increment primary key,
    nombre varchar(25) not null,
    apellido varchar(25) not null,
    edad int,
    idCurso int not null
);
alter table alumnos
    add constraint FK_Alumnos_idCurso
    foreign key(idCurso)
    references cursos(id);


select * from cursos;
