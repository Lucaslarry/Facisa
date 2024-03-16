package application;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

import entities.Ingrediente;

import entities.Pizzaria;
import entities.PizzariaExceptions;
import entities.Relatorio;

public class Program {
    public static void main(String[] args) throws Exception {
        boolean sair = false;
        Pizzaria pizzaria = new Pizzaria();
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        String[] listaPreIng = { "Frango", "Queijo", "Calabresa" };
        if (listaPreIng.length > 0) {
            pizzaria.addIngPre(listaPreIng);
        }

        while (!sair) {
            try {
                int opcaoPrincipal = UI.menu(sc);
                sc.nextLine();

                if (opcaoPrincipal != 4 && opcaoPrincipal != 6 && pizzaria.getlistaIngredientes().isEmpty()) {
                    throw new PizzariaExceptions("Não é possivel fazer isso antes de criar um ingrediente.");
                }

                switch (opcaoPrincipal) {
                    default -> System.out.println("Opção Inválida");
                    case 1 -> {
                        LinkedList<String> tempLista = new LinkedList<>();
                        pizzaria.prepararPizza(sc, tempLista);

                    }

                    case 2 -> {
                        boolean escolher = false;
                        while (!escolher) {
                            LinkedList<String> tempLista = new LinkedList<>();
                            int escolhaPedido = UI.menuPedido(sc);
                            sc.nextLine();
                            String escolhaSabor = null;

                            if (escolhaPedido == 1) {
                                System.out.println("Cardápio: ");
                                pizzaria.getlistaPizzas().stream().map(p -> p.getNomeDoSabor())
                                        .forEach(System.out::println);
                                System.out.print("Digite o nome sabor de pizza: ");
                                escolhaSabor = sc.nextLine();
                            }
                            if (escolhaPedido == 2) {
                                escolhaSabor = pizzaria.prepararPizza(sc, tempLista);
                            }
                            if (escolhaPedido == 3) {
                                System.out.println("Voltando...");
                                escolher = true;
                            }
                            System.out.print("Digite o numero da mesa: ");
                            int numeroMesa = sc.nextInt();
                            sc.nextLine();
                            pizzaria.criarPedido(UI.formatarTexto(escolhaSabor), numeroMesa);
                            escolher = true;

                        }

                    }
                    case 3 -> {
                        pizzaria.servirPedido();
                    }
                    case 4 -> {
                        System.out.print("Digite o ingrediente a ser adicionado: ");
                        String novoIngrediente = sc.nextLine();
                        pizzaria.adicionarIngrediente(new Ingrediente(UI.formatarTexto(novoIngrediente)));
                    }
                    case 5 -> {
                        System.out.println(
                                "Ao total foram servidas " + Relatorio.getQuantidadeDePizzaSevida() + " pizzas");

                        System.out.println(
                                "As pizzas tem em média " + Relatorio.getQuantidadeMediaDeIngredientes()
                                        + " ingredientes por pizza");

                        System.out.println("O ingrediente mais pedido foi "
                                + Relatorio.getIngredienteMaisPedido().getIngrediente()
                                + " com um total de " + Relatorio.getQuantidadeDoMaisPedido() + " pedidos");

                        String semPedidos = Relatorio.ingredientesNaoPedidos(pizzaria.getlistaIngredientes());
                        if (semPedidos == null) {
                            System.out.println("Não há ingredientes que não foram pedidos");
                        } else {
                            System.out.println("Lista de ingredientes que não ainda não foram pedidos: " + semPedidos);
                        }

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
