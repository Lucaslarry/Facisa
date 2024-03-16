# Sobre o projeto

Esse é um projeto que simula um sistema de uma pizzaria, nele é possivel adicionar ingredientes, criar pizzas, fazer pedido, servir um pedido e um relatório simples de vendas.

construido durante o quinto módulo da universidade unifacisa.

### Requerimentos:
    Funcionalidades:
    
    funções:
    Menu:
    1. Criar uma pizza
    2. Criar um novo pedido
    3. Servir um pedido
    4. Adicionar ingredientes
    5. Estatísticas dos pedidos
    6. Sair do programa
    
    1. Criar pizza
    Ao escolher essa opção, os ingredientes devem ser mostrados em tela, e o usuário pode
    escolher que ingredientes colocar na pizza. A pizza deve receber, no mínimo, 1 ingrediente e
    no máximo 5 ingredientes. Deve ser possível desfazer a ação e remover o último ingrediente
    colocado. A ordem que os ingredientes são colocados não importa para o cliente.
   
    2. Criar pedido
    O sistema deve permitir que pedidos sejam enfileirados. Um pedido consiste em uma pizza
    e mesa do cliente.
    
    3. Servir pedido
    O pedido deve ser atendido e removido da estrutura de dados se, e apenas se, a pizza
    apropriada tenha sido criada antes.
    
    4. Adicionar ingredientes
    Essa opção permite que a pizzaria adicione novos ingredientes ao seu cardápio de
    ingredientes. Não devem existir ingredientes repetidos.
    
    5. Estatísticas
    O sistema deve imprimir quantos pizzas foram servidas, a quantidade média de ingredientes
    por pizza, qual o ingrediente mais pedido (e quantas vezes foi pedido), quais ingredientes
    não foram escolhidos nenhuma vez.
    
    6. Sair
    Opção de terminar o programa


# Como executar o projeto
Pré-requisitos: Java 17
```bash
# clonar repositório
$ git clone https://github.com/lucaslarry/Facisa/tree/main/Java/ProjetoPizzaria_fase1
```
Dentro da pasta src:
```bash
# compilar o projeto
$ javac application/Program.java
# executar o projeto
$ java application/Program.java
```

# Tecnologias utilizadas
- Java

