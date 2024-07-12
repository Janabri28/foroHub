CREATE TABLE IF NOT EXISTS `curso` (
	`id_curso` bigint AUTO_INCREMENT NOT NULL UNIQUE,
	`name` varchar(100) NOT NULL,
	`categoria` varchar(100) NOT NULL,
	PRIMARY KEY (`id_curso`)
);

CREATE TABLE IF NOT EXISTS `topico` (
	`id_topico` bigint AUTO_INCREMENT NOT NULL UNIQUE,
	`titulo` varchar(200) NOT NULL,
	`mensaje` varchar(500) NOT NULL,
	`fecha_creacion` varchar(100) NOT NULL,
	`status` boolean NOT NULL,
	`id_autor_fk` bigint NOT NULL,
	`id_curso_fk` bigint NOT NULL,
	PRIMARY KEY (`id_topico`)
);

CREATE TABLE IF NOT EXISTS `autor` (
	`id_autor` bigint AUTO_INCREMENT NOT NULL UNIQUE,
	`nombre` varchar(150) NOT NULL,
	`email` varchar(150) NOT NULL,
	`contrasena` varchar(300) NOT NULL,
	`id_perfiles_fk` bigint NOT NULL,
	PRIMARY KEY (`id_autor`)
);

CREATE TABLE IF NOT EXISTS `perfiles` (
	`id_perfiles` bigint AUTO_INCREMENT NOT NULL UNIQUE,
	`perfil` varchar(150) NOT NULL,
	PRIMARY KEY (`id_perfiles`)
);

CREATE TABLE IF NOT EXISTS `respuesta` (
	`id_respuesta` bigint AUTO_INCREMENT NOT NULL UNIQUE,
	`mensaje` varchar(500) NOT NULL,
	`fecha_respuesta` varchar(255) NOT NULL,
	`id_autor_fk` bigint NOT NULL,
	`solucion` varchar(500) NOT NULL,
	`id_topico_fk` bigint NOT NULL,
	PRIMARY KEY (`id_respuesta`)
);


ALTER TABLE `topico` ADD CONSTRAINT `topico_fk5` FOREIGN KEY (`id_autor_fk`) REFERENCES `autor`(`id_autor`);
ALTER TABLE `topico` ADD CONSTRAINT `topico_fk6` FOREIGN KEY (`id_curso_fk`) REFERENCES `curso`(`id_curso`);
ALTER TABLE `autor` ADD CONSTRAINT `autor_fk4` FOREIGN KEY (`id_perfiles_fk`) REFERENCES `perfiles`(`id_perfiles`);
ALTER TABLE `respuesta` ADD CONSTRAINT `respuesta_fk3` FOREIGN KEY (`id_autor_fk`) REFERENCES `autor`(`id_autor`);
ALTER TABLE `respuesta` ADD CONSTRAINT `respuesta_fk5` FOREIGN KEY (`id_topico_fk`) REFERENCES `topico`(`id_topico`);






