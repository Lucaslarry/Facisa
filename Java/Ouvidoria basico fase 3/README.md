# Sobre o projeto

A Fase 3 da Ouvidoria é uma atualização da segunda fase agora utilizando conexão com o banco de dados (SGBD) MySQL e usando as funções básicas de CRUD.

construido durante o primeiro módulo da universidade unifacisa.

### Requerimentos:

    Aplicação do Sistema Gerenciador de Banco de Dados (SGBD) MySQL na Integração com o Sistema de Ouvidoria construida em python.

    O sistema deve conter Obrigatoriamente:

    Menu
        - Cadastrar Ocorrências - Inserir ocorrência (salvar para futura consulta). 
        - Deve ser possível inserir tipos/categorias (Mensagem, Elogio, reclamação)
        - Listar Ocorrências - Lista todas as ocorrências cadastradas
        - Apagar Ocorrências - Apaga ocorrência especifica e apagar todas as ocorrências
        - Sair - sair do sistema
        - O sistema agora deve conter pelo menos 2 arquivos (classe e main)
        - O sistema deve conter obrigatoriamente as funções Inserir/Listar/Apagar
        - Todas as funções devem estar dentro do arquivo de classe e devem ser chamadas pelo arquivo main
        - Todas as operações devem ser realizadas retirando os dados do banco de dados.

    Entrega Opcional:

    Além dos requisitos detalhados acima o sistema deve conter a função de Editar (UPDATE):   


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

