package entities;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import application.UI;

public class Pizzaria {
    private Set<Ingredientes> listaIngredientesExistentes = new LinkedHashSet<>();
    private Set<Pizza> listaPizzaExistentes = new HashSet<>();
    private LinkedList<Pedido> listadePedidos = new LinkedList<>();

    public Pizzaria() {

    }

    public void adicionarIngrediente(Ingredientes ingrediente) {
        if (ingredienteExiste(ingrediente)) {
            throw new PizzariaExceptions("Ingrediente já existente");
        }
        listaIngredientesExistentes.add(ingrediente);
        UI.printMensagemSucesso("Ingrediente adicionado");
    }

    public void criarPizza(String sabor, List<String> lista) {
        Ingredientes[] listaIng = transformarIngrediente(lista);
        if (listaIng == null) {
            throw new PizzariaExceptions("Um ou mais ingredientes não existem.");
        }
        listaPizzaExistentes.add(new Pizza(sabor, listaIng));
        UI.printMensagemSucesso("Pizza criada");
        Relatorio.setQuantidadeIng(lista.size());
        Relatorio.setQuantidadePizza();

    }

    private Ingredientes[] transformarIngrediente(List<String> lista) {
        Ingredientes[] ingredientes = new Ingredientes[lista.size()];
        int count = 0;
        for (Ingredientes ing : listaIngredientesExistentes) {
            if (count >= lista.size()) {
                return ingredientes;
            }
            if (ing.getId() == Integer.parseInt(lista.get(count))) {
                ingredientes[count] = ing;
                count++;
            }
        }
        if (count == 0) {
            return null;
        }

        return ingredientes;
    }

    public void criarPedido(String sabor, int mesa) {
        if (!listaPizzaExistentes.stream().anyMatch(p -> p.getNomeDoSabor().equals(sabor))) {
            throw new PizzariaExceptions("Este sabor de pizza não está disponivel no cardápio");
        }
        listadePedidos.add(new Pedido(saborParaPizza(sabor), new Mesa(mesa)));
        UI.printMensagemSucesso("Pedido criado");
    }

    private Pizza saborParaPizza(String sabor) {
        for (Pizza pizzas : listaPizzaExistentes) {
            if (pizzas.getNomeDoSabor().equals(sabor)) {
                return pizzas;
            }
        }
        return null;
    }

    public void servirPedido() {
        if (listadePedidos.isEmpty()) {
            throw new PizzariaExceptions("Não existem pedidos");
        }
        Pizza primeiraPizza = listadePedidos.getFirst().getPizza();
        Relatorio.ingredientePedido(primeiraPizza.getIngredienteDaPizza());
        UI.printMensagemSucesso("Servido: " + listadePedidos.getFirst());
        listadePedidos.remove();
        Relatorio.setQuantidadeDePizzaSevida();

    }

    private boolean ingredienteExiste(Ingredientes ingrediente) {
        return listaIngredientesExistentes.contains(ingrediente);
    }

    public Set<Ingredientes> getListaIngredientesExistentes() {
        return listaIngredientesExistentes;
    }

    public Set<Pizza> getListaPizzaExistentes() {
        return listaPizzaExistentes;
    }
}
