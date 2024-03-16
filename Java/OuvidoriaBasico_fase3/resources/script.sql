CREATE DATABASE ouvidoria;


CREATE TABLE comentario (
    id INT AUTO_INCREMENT,
    comentario varchar(300),
    tipo varchar(30),
    nome varchar(30),
    PRIMARY KEY(id)
);