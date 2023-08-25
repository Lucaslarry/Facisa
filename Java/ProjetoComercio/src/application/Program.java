package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Comercio;
import entities.Produtos;
import entities.ProdutosException;

public class Program {
    public static void main(String[] args) throws Exception {
        Comercio loja = null;
        Produtos prod = null;
        boolean lojaFechada = false;
        Scanner sc = new Scanner(System.in);

        while (lojaFechada == false) {
            try {
                System.out.println("1. Listar Produtos");
                System.out.println("2. Cadastrar Produtos");
                System.out.println("3. Adicionar Estoque");
                System.out.println("4. Remover Produtos");
                System.out.println("5. Vender Produtos");
                System.out.println("6. Fechar Loja");
                System.out.print("Sua escolha: ");
                int opcao = sc.nextInt();
                sc.nextLine();

                if (loja == null && opcao != 2) {
                    throw new ProdutosException("Para abrir a loja, cadastre um produto.");
                }

                switch (opcao) {
                    case 1 -> loja.listarProdutos();

                    case 2 -> {
                        System.out.print("Digite o nome do produto: ");
                        String nome = sc.nextLine();
                        System.out.print("Digite o código do produto: ");
                        int codigo = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Deseja adicionar estoque [S/N]: ");
                        char estoqueInicial = sc.next().charAt(0);
                        estoqueInicial = Character.toUpperCase(estoqueInicial);

                        if (estoqueInicial == 'S') {
                            System.out.print("Novo Estoque: ");
                            int estoque = sc.nextInt();
                            sc.nextLine();
                            prod = new Produtos(nome, codigo, estoque);
                        } else {
                            prod = new Produtos(nome, codigo);
                        }

                        if (loja == null) {
                            loja = new Comercio(prod);
                        } else {
                            loja.cadastrarProduto(prod);
                        }

                    }

                    case 3 -> {
                        System.out.print("Digite o código do produto que deseja atualizar: ");
                        int codigo = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Digite o novo estoque: ");
                        int novoEstoque = sc.nextInt();
                        sc.nextLine();
                        loja.adicionarEstoque(codigo, novoEstoque);

                    }

                    case 4 -> {
                        System.out.print("Digite o código do produto que deseja deletar: ");
                        int codigo = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Realmente deseja deletar [S/N]: ");
                        char deletar = sc.next().charAt(0);
                        deletar = Character.toUpperCase(deletar);
                        if (deletar == 'S') {
                            loja.removerProduto(codigo);
                        } else {
                            System.out.println("Exclusão cancelada! ");
                        }
                    }
                    case 5 -> {
                        System.out.print("Digite o código do produto que deseja vender: ");
                        int codigo = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Digite a quantidade que deseja vender: ");
                        int venda = sc.nextInt();
                        sc.nextLine();
                        loja.venderProduto(codigo, venda);
                    }

                    case 6 -> {
                        System.out.println("Fechando loja");
                        lojaFechada = true;
                    }
                    default -> System.out.println("Opção inválida");

                }

            } catch (ProdutosException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido, tente novamente.");
                sc.nextLine();
            }
        }
        sc.close();
    }
}