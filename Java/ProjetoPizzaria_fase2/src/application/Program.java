package application;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

import entities.Pizzaria;
import entities.PizzariaExceptions;
import entities.Relatorio;

public class Program {
    public static void main(String[] args) throws Exception {
        boolean sair = false;
        Pizzaria pizzaria = new Pizzaria();
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        String[] listaPreIng = { "Frango", "Queijo", "Calabresa", "Cebola", "Ovo", "Requeijao", "Cream Cheese",
                "Peperoni", "Tomate", "Azeitona" };
        pizzaria.adicionarIngrediente(listaPreIng);

        while (!sair) {
            try {
                int opcaoPrincipal = UI.menu(sc);
                sc.nextLine();

                switch (opcaoPrincipal) {
                    default -> System.out.println("Opção Inválida");
                    case 1 -> {
                        pizzaria.criarPedidoAleatorio();
                    }

                    case 2 -> {
                        System.out.println(pizzaria.olharPedido());
                    }
                    case 3 -> {
                        boolean adicionado = false;
                        LinkedList<String> tempLista = new LinkedList<>();
                        while (adicionado == false) {
                            UI.menuPizza();
                            int escolhaPizza = sc.nextInt();
                            sc.nextLine();

                            if (escolhaPizza == 1) {
                                pizzaria.getlistaIngredientes().forEach(System.out::println);
                                System.out.print("Digite no nome do ingrediente: ");
                                String novoIng = sc.nextLine();
                                tempLista.add(UI.formatarTexto(novoIng));
                            }
                            if (escolhaPizza == 2) {
                                if (tempLista.isEmpty()) {
                                    System.out.println("Nenhum ingrediente foi adicionado");
                                } else {
                                    System.out.println(tempLista.getLast() + " removido com sucesso!");
                                    tempLista.removeLast();

                                }
                            }
                            if (escolhaPizza == 3) {
                                System.out.print("Nomeie este sabor: ");
                                String sabor = sc.nextLine();
                                pizzaria.criarPizza(UI.formatarTexto(sabor), tempLista);
                                adicionado = true;
                            }
                            if (escolhaPizza == 4) {
                                System.out.println("Voltando...");
                                adicionado = true;
                            }
                        }
                    }
                    case 4 -> {
                        pizzaria.servirPedido();
                    }
                    case 5 -> {
                        System.out.println(
                                "Ao total foram servidas " + Relatorio.getQuantidadeDePizzaSevida() + " pizzas");

                        System.out.println("Existem " + pizzaria.getQuantidadePedidos() + " pedidos na fila");
                        String semPedidos = Relatorio.ingredientesNaoPedidos(pizzaria.getlistaIngredientes());
                        if (semPedidos == null) {
                            System.out.println("Não há ingredientes que não foram pedidos");
                        } else {
                            System.out.println("Lista de ingredientes que não ainda não foram pedidos: " + semPedidos);
                        }

                        System.out.println("O ingrediente mais pedido foi "
                                + Relatorio.getIngredienteMaisPedido().getIngrediente()
                                + " com um total de " + Relatorio.getQuantidadeDoMaisPedido() + " pedidos");
                        System.out
                                .println("Quantidade de ingredientes corretos: " + Relatorio.getMediaIngCorreto());
                    }
                    case 6 -> {
                        System.out.println("Nossa pizzaria está fechando, obrigado!");
                        sair = true;
                    }

                }
            } catch (PizzariaExceptions e) {
                System.out.println(e.getMessage());
            } catch (NullPointerException | ArithmeticException e) {
                System.out.println("Nenhum pedido ainda foi feito");
            } catch (ExceptionInInitializerError e) {
                System.out.println("Ainda não foi adicionado nenhum ingrediente ou pizza");
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Valor inválido");
                sc.nextLine();
            }

        }
        sc.close();
    }
}
