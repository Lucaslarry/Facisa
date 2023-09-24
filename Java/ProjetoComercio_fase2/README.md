# Sobre o projeto

Essa é uma atualização do projeto com a adição de categorias de produtos e relátorios de vendas

construido durante o quarto módulo da universidade unifacisa.

### Requerimentos:
    Funcionalidades:
    Crie um sistema de gerenciamento para uma loja virtual. O programa deve contar com um
    atributo que representa o dinheiro disponível e ter as seguintes funções.
    
    Menu:
    1. Listar todos os produtos
    2. Cadastrar um novo produto
    3. Adicionar estoque de um produto
    4. Remover um produto do comércio
    5. Vender algum produto existente
    6. Relatório de compra e vendas
    7. Sair do programa
    
    1. Listar
    O sistema deve verificar se a lista de produtos está vazia. Caso esteja, deve ser apresentada
    a mensagem “Nenhum produto cadastrado no sistema”. Por outro lado, caso existam
    produtos, o usuário poderá escolher entre listar todos os produtos, como da maneira abaixo:
    1. Processador (cód.: 235235 | estoque: 10 | categoria | custo de compra | valor de venda)
    2. Teclado RGB (cód.: 21313 | estoque: 21 | categoria | custo de compra | valor de venda)
    3. Cadeira (cód.: 212895 | estoque: 500 | categoria | custo de compra | valor de venda)

    Ou, listar apenas os produtos de uma determinada categoria:
    1. Mousepad (cód.: 213 | estoque: 8 | atributos da categoria | custo de compra | valor de
    venda)
    2. Teclado RGB (cód.: 2313 | estoque: 21 | atributos da categoria | custo de compra | valor de
    venda)
    3. Mouse (cód.: 111 | estoque: 13 | atributos da categoria | custo de compra | valor de venda)
    
    2. Cadastrar
    O sistema deve solicitar o nome do novo produto, sua categoria, o custo de compra, valor da
    venda e adicionar ao sistema com estoque 0. Ao cadastrar o produto, o programa deve
    perguntar se o usuário deseja adicionar estoque ao produto. Ao fim, confirmar por meio da
    mensagem “<NOME DO PRODUTO> cadastrado com sucesso. Código: <CÓDIGO DO
    PRODUTO>, Estoque: <ESTOQUE DO PRODUTO> ”.
    Atenção: o código NÃO PRECISA mais ser solicitado, e pode ser feito de forma sequencial
    (primeiro produto tem código 1, segundo tem código 2, etc.). O que importa é que os
    códigos sejam ÚNICOS. Se preferir manter da forma antiga, pode.
    Exemplo de categoria: numa loja de aquário, poderíamos ter algumas categorias: Animal,
    Decoração, Alimentação. Cada categoria deve ter seus próprios atributos, fora os
    provenientes da classe Produto
    
    3. Adicionar
    O programa deve permitir que o usuário possa adicionar estoque a produtos existentes. Ao
    escolher essa opção, o usuário deve digitar o código do produto, e, em seguida, quanto será
    adicionado ao estoque. Ao adicionar estoque, o saldo do comércio deve ser diminuído de
    acordo com a quantidade de produtos adicionados e o seu custo de compra. Só deve ser
    possível comprar produtos se houver saldo o suficiente.
    
    4. Remover
    Ao escolher essa opção, o programa deve solicitar o código do produto. Após digitar um
    código existente, caso ainda haja estoque do produto, o programa deve confirmar se o
    usuário realmente deseja excluir. Com a confirmação, o produto deve ser removido do
    sistema, assim como todo seu estoque
    
    5. Vender
    O programa deve permitir que o usuário possa vender unidades de algum produto existente.
    Ao escolher essa opção, o usuário deve digitar o código do produto, e, em seguida, quantas
    unidades serão vendidas. As unidades vendidas não podem ultrapassar o estoque
    disponível. O valor gerado pelas vendas deve ser adicionado ao saldo do comércio.
    
    6. Relatório
    Com essa opção, o sistema deve gerar um breve relatório do que foi comprado, o que foi
    vendido e o saldo arrecadado. bônus: o sistema deve gerar um relatório para a sessão atual
    e outro para o histórico completo.

    7. Sair
    O sistema deve permitir que o usuário saia do programa. O programa também deve salvar
    os produtos, estoque e saldo do comércio.

```bash
# clonar repositório
$ git clone https://github.com/lucaslarry/Facisa/tree/main/Java/ProjetoComercio_fase2
# executar o projeto
```
Dentro da pasta src:
```bash
$ javac application/Program.java
$ java application/Program.java
```

# Tecnologias utilizadas
- Java

