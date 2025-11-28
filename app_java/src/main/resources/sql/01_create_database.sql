-- Crear base de datos PERSONAL
CREATE DATABASE IF NOT EXISTS personal;
USE personal;

-- Tabla usuario
CREATE TABLE IF NOT EXISTS usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Tabla rol
CREATE TABLE IF NOT EXISTS rol (
    id_rol INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    id_usuario INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

-- Tabla puesto
CREATE TABLE IF NOT EXISTS puesto (
    id_puesto INT AUTO_INCREMENT PRIMARY KEY,
    nombre_puesto VARCHAR(100) NOT NULL
);

-- Tabla postulante
CREATE TABLE IF NOT EXISTS postulante (
    id_postulante INT AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    direccion VARCHAR(200),
    correo VARCHAR(100),
    id_puesto INT NOT NULL,
    FOREIGN KEY (id_puesto) REFERENCES puesto(id_puesto)
);
