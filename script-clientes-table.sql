CREATE DATABASE IF NOT EXISTS clientes_db;
USE clientes_db;
CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    telefono VARCHAR(20),
    email VARCHAR(150) UNIQUE
);

CREATE TABLE motos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(100) NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    placa VARCHAR(20) UNIQUE NOT NULL,
    cliente_id INT,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);
