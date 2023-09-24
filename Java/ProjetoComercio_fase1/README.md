# Sobre o projeto

O projeto de comércio é uma simulação de como seria uma loja de varejo com Venda, cardapio(Listar) e estoque(Cadastrar e Adicionar)

construido durante o quarto módulo da universidade unifacisa.

### Requerimentos:
    Funcionalidades
    Crie um sistema de gerenciamento para uma loja virtual. O programa deve ter as seguintes
    funções.
    
    Menu:
    1. Listar todos os produtos
    2. Cadastrar um novo produto
    3. Adicionar estoque de um produto
    4. Remover um produto do comércio
    5. Vender algum produto existente
    6. Sair do programa
    
    1. Listar
    O sistema deve verificar se a lista de produtos está vazia. Caso esteja, deve ser apresentada
    a mensagem “Nenhuma reclamação cadastrada no sistema”. Por outro lado, caso existam
    produtos, devem ser apresentados de forma similar à apresentada abaixo:
    1. Monitor 24” (cód.: 72183728 | estoque: 8)
    2. Teclado RGB (cód.: 4313513 | estoque: 30)
    3. Mouse (cód.: 212895 | estoque: 500)
    
    2. Cadastrar
    O sistema deve solicitar o nome do novo produto, o seu código (que deve ser único), e
    adicionar ao sistema com estoque 0. Ao cadastrar o produto, o programa deve perguntar se
    o usuário deseja adicionar estoque ao produto. Ao fim, confirmar por meio da mensagem
    “<NOME DO PRODUTO> cadastrado com sucesso. Código: <CÓDIGO DO PRODUTO>,
    Estoque: <ESTOQUE DO PRODUTO> ”.
    
    3. Adicionar
    O programa deve permitir que o usuário possa adicionar estoque a produtos existentes. Ao
    escolher essa opção, o usuário deve digitar o código do produto, e, em seguida, quanto será
    adicionado ao estoque.
   
    4. Remover
    Ao escolher essa opção, o programa deve solicitar o código do produto. Após digitar um
    código existente, caso ainda haja estoque do produto, o programa deve confirmar se o
    usuário realmente deseja excluir. Com a confirmação, o produto deve ser removido do
    sistema, assim como todo seu estoque
   
    5. Vender
    O programa deve permitir que o usuário possa vender unidades de algum produto existente.
    Ao escolher essa opção, o usuário deve digitar o código do produto, e, em seguida, quantas
    unidades serão vendidas. As unidades vendidas não podem ultrapassar o estoque
    disponível.
    
    6. Sair
    O sistema deve permitir que o usuário saia do programa

```bash
# clonar repositório
$ git clone https://github.com/lucaslarry/Facisa/tree/main/Java/ProjetoComercio_fase1
# executar o projeto
```
Dentro da pasta src:
```bash
$ javac application/Program.java
$ java application/Program.java
```

# Tecnologias utilizadas
- Java

