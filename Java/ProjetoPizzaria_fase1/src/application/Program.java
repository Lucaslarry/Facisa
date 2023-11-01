package application;

import java.util.Scanner;

import entities.Ingredientes;

import entities.Pizzaria;
import entities.PizzariaExceptions;

public class Program {
    public static void main(String[] args) throws Exception {
        boolean sair = false;
        int idIng = 1;
        Pizzaria pizzaria = new Pizzaria();

        Scanner sc = new Scanner(System.in);
        while (sair == false) {
            try {
                UI.menu();
                int opcaoPrincipal = sc.nextInt();
                sc.nextLine();

                if (opcaoPrincipal == 1 && pizzaria.getListaIngredientesExistentes().isEmpty()) {
                    throw new PizzariaExceptions("Não é possivel criar uma pizza sem ingredientes.");
                }

                switch (opcaoPrincipal) {
                    default -> System.out.println("Opção Inválida");
                    case 1 -> {
                        pizzaria.getListaIngredientesExistentes().forEach(System.out::println);
                        System.out.println("Exemplo: 1 2 3 4 5");
                        System.out.print("Escolha seus ingredientes: ");
                        String[] tempLista = sc.nextLine().split(" ");
                        System.out.print("Nomeie este sabor: ");
                        String sabor = sc.nextLine();
                        pizzaria.criarPizza(sabor, tempLista);

                    }
                    case 2 -> {
                        System.out.println("Cardápio: ");
                        pizzaria.getListaPizzaExistentes().forEach(System.out::println);
                        System.out.println("Digite o nome sabor de pizza: ");
                        String escolhaSabor = sc.nextLine();
                        System.out.println("Digite o numero da mesa: ");
                        int numeroMesa = sc.nextInt();
                        sc.nextLine();
                        pizzaria.criarPedido(escolhaSabor, numeroMesa);

                    }
                    case 3 -> {
                        pizzaria.servirPedido();
                    }
                    case 4 -> {
                        System.out.print("Digite o ingrediente a ser adicionado: ");
                        String novoIngrediente = sc.nextLine();
                        pizzaria.adicionarIngrediente(new Ingredientes(novoIngrediente, idIng));
                        idIng++;
                    }

                }
            } catch (PizzariaExceptions e) {
                System.out.println(e.getMessage());
            }

        }
        sc.close();
    }
}
