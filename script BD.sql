create database forohub;
use forohub;
insert into forohub.perfiles(id_perfiles,perfil) values(1,"ALUMNO");
insert into forohub.perfiles(id_perfiles,perfil) values(2,"ADMINISTRADOR");
insert into forohub.perfiles(id_perfiles,perfil) values(3,"INSTRUCTOR");
insert into forohub.autor(id_autor,nombre,email,contrasena,id_perfiles_fk) values(1,"Francisco Rojas","francisco.rojas@escuelaAlura.com","12345",1);
insert into forohub.curso(id_curso,name,categoria) values(1,"HTTP en la Web","Sistemas de Computo");
insert into forohub.autor(id_autor,nombre,email,contrasena,id_perfiles_fk) values(4000,"Janet Martinez","janet.martinez@escuelaAlura.com","$2y$10$jbdjU1nLXeIFK7JeF.9LhOvba.8O8OiF8exhjWjkKSEE9fG8cfq2q",2);
