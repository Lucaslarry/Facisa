package application;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import entities.Comercio;
import entities.Produtos;
import entities.ProdutosException;
import entities.Relatorio;
import entities.categorias.Categoria;
import entities.categorias.Comida;
import entities.categorias.Eletronico;

public class Program {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(new Locale("en", "US"));

        Comercio loja = null;
        Produtos prod = null;
        boolean lojaFechada = false;
        int codigo = 1;
        Categoria cat = null;
        Scanner sc = new Scanner(System.in);
        Relatorio.criarArquivoTemporario();
        File arquivoNovo = new File("listaProdutos.txt");
        while (lojaFechada == false) {
            try {
                System.out.println("SALDO ATUAL: R$" + UI.FormatarDecimal(Relatorio.getSaldo()));
                UI.menu();
                int opcao = sc.nextInt();
                sc.nextLine();
                if (loja == null && arquivoNovo.exists()) {
                    loja = new Comercio();

                }
                if (loja == null && opcao != 2) {
                    throw new ProdutosException("Para abrir a loja, cadastre um produto.");
                }

                switch (opcao) {
                    case 1 -> {
                        System.out.println("Deseja Listar:\n1. Todos os Produtos\n2. Por categoria");
                        System.out.print("");
                        int codigoaux = sc.nextInt();
                        sc.nextLine();
                        if (codigoaux == 1) {
                            loja.listarProdutos();
                        }
                        if (codigoaux == 2) {
                            UI.menuCategorias();
                            System.out.print("Sua escolha: ");
                            int opcaocat = sc.nextInt();
                            sc.nextLine();
                            if (opcaocat == 1) {
                                loja.listarProdutosCategoria(new Eletronico());
                            }
                            if (opcaocat == 2) {
                                loja.listarProdutosCategoria(new Comida());
                            }

                        }
                    }

                    case 2 -> {
                        System.out.print("Digite o nome do produto: ");
                        String nome = sc.nextLine();
                        System.out.println("Selecione a categoria: ");
                        UI.menuCategorias();
                        int opcaocat = sc.nextInt();
                        sc.nextLine();
                        if (opcaocat == 1) {
                            cat = new Eletronico();
                        }
                        if (opcaocat == 2) {
                            cat = new Comida();
                        }
                        System.out.println("Qual custo de compra do produto?");
                        Double custo = sc.nextDouble();
                        System.out.println("Qual valor de venda do produto?");
                        Double venda = sc.nextDouble();
                        System.out.print("Deseja adicionar estoque [S/N]: ");
                        char estoqueInicial = sc.next().charAt(0);
                        estoqueInicial = Character.toUpperCase(estoqueInicial);
                        if (estoqueInicial == 'S') {
                            System.out.print("Adicionar quantos ao estoque: ");
                            int estoque = sc.nextInt();
                            sc.nextLine();

                            prod = new Produtos(nome, codigo, estoque, cat, custo, venda);
                        } else {
                            prod = new Produtos(nome, codigo, cat, custo, venda);
                        }

                        if (loja == null) {
                            loja = new Comercio(prod);
                        } else {
                            loja.cadastrarProduto(prod);
                        }
                        codigo++;
                        loja.carregarProdutosDeArquivo();
                    }
                    case 3 -> {
                        System.out.print("Digite o código do produto que deseja atualizar: ");
                        int codigoaux = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Digite o novo estoque: ");
                        int novoEstoque = sc.nextInt();
                        sc.nextLine();
                        loja.adicionarEstoque(codigoaux, novoEstoque);

                    }

                    case 4 -> {
                        System.out.print("Digite o código do produto que deseja deletar: ");
                        int codigoaux = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Realmente deseja deletar [S/N]: ");
                        char deletar = sc.next().charAt(0);
                        deletar = Character.toUpperCase(deletar);
                        if (deletar == 'S') {
                            loja.removerProduto(codigoaux);
                        } else {
                            System.out.println("Exclusão cancelada! ");
                        }
                    }
                    case 5 -> {
                        System.out.print("Digite o código do produto que deseja vender: ");
                        int codigoaux = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Digite a quantidade que deseja vender: ");
                        int venda = sc.nextInt();
                        sc.nextLine();
                        loja.venderProduto(codigoaux, venda);
                    }

                    case 6 -> {
                        System.out.println("Fechando loja");
                        lojaFechada = true;
                    }
                    default -> System.out.println("Opção inválida");

                }

            } catch (ProdutosException e) {
                System.out.println("ERRO: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Valor inválido, tente novamente.");
                sc.nextLine();
            } catch (java.lang.IllegalStateException e) {
                System.out.println("ERRO: Valor inválido, tente novamente.");
                sc.nextLine();
            }

        }
        sc.close();
        loja.salvarProdutosEmArquivo();
    }
}
