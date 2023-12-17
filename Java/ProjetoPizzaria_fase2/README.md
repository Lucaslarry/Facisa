# Sobre o projeto

Esse é um projeto que simula um sistema de uma pizzaria, nele é possivel criar pedido aleatório, criar pizzas, servir um pedido e um relatório simples de vendas.

construido durante o quinto módulo da universidade unifacisa.

### Requerimentos:
    Crie um sistema de gerenciamento para a pizzaria. O programa deve ter as seguintes funções:
    
    Menu:
    1. Receber um pedido
    2. Olhar pedido atual
    3. Preparar uma pizza
    4. Servir pedido
    5. Estatísticas dos pedidos
    6. Sair do programa

    1. Receber pedido aleatório
    Ao executar essa função, um novo pedido aleatório é criado e colocado na fila de pedidos.
    Um pedido é composto por: identificação do pedido (id), o nome do cliente e uma pizza
    com 5 ingredientes. O id pode ser sequencial, enquanto que as outras informações devem
    ser aleatórias.
    
    2. Olhar pedido atual
    Já que a pizzaria preza pela ordem dos pedidos, você só pode olhar e servir o pedido atual.
    Não apresente nem sirva outros pedidos. Ao executar essa função, a identificação do
    pedido, o nome do cliente e sua pizza são apresentados.
    
    exemplo de saída:
    Pedido atual: Pedido 12 | Armando | Pizza com calabresa, calabresa, calabresa, cebola,
    cream cheese
    
    3. Preparar pizza
    Ao escolher essa opção, os ingredientes devem ser mostrados em tela, e o usuário pode
    escolher que ingredientes colocar na pizza. A pizza deve sempre receber 5 ingredientes,
    mesmo que algum seja repetido. Essa pizza será, então, colocada na sua coleção de pizzas
    (uma lista, por exemplo).
    
    exemplo de pizza correta: pizza com calabresa, queijo, molho de tomate, cebola e orégano
    outro exemplo: pizza com calabresa, cream cheese, calabresa, calabresa, cebola
    
    4. Servir pedido
    Você deve comparar as pizzas armazenadas com a pizza pedida no pedido atual. A pizza só
    deve ser servida se pelo menos 3 dos ingredientes pedidos estiverem na pizza. Você deve
    priorizar a entrega de pizzas perfeitas (5 acertos). Ao servir uma pizza, o pedido sai da fila
    de pedidos e a pizza é removida da coleção (lista, etc.).
    
    5. Estatísticas
    O sistema deve imprimir quantos pizzas foram servidas, o ingrediente mais pedido,
    ingredientes não utilizados, quantos pedidos ainda estão na fila, quantidade média de
    ingredientes corretos.
    
    6. Sair
    Opção de terminar o programa.


# Como executar o projeto
Pré-requisitos: Java 17
```bash
# clonar repositório
$ git clone https://github.com/lucaslarry/Facisa/tree/main/Java/ProjetoPizzaria_fase2
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

