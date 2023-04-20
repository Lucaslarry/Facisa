# Sobre o projeto

O Arc MarketingPlace é um projeto de um site construido com objetivo de testar o conhecimento de html, css e JavaScript

construido durante o segundo módulo da universidade unifacisa.
 
<img src="./Facisa/imagens/arc1.png">

# Como executar o projeto

Pré-requisitos: Python 3.9 e MySQL

```bash
# clonar repositório
$ git clone https://github.com/Lucaslarry/Facisa/tree/main/Python/Ouvidoria%20v3.0
```
Dentro do MySQL Workbench crie uma nova conexão com o user root e o password lucas, depois, crie as tabelas com os seguintes comandos:
```sql
CREATE DATABASE ouvidoria;

USE ouvidoria;

CREATE TABLE comentario (
    id INT AUTO_INCREMENT,
    comentario varchar(300),
    tipo varchar(30),
    PRIMARY KEY(id)
);
```
Depois é só rodar o arquivo main.py com:
```bash
# executar o projeto
$ python main.py
```
# Tecnologias utilizadas
- Python
- MySQL

