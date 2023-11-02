package entities;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import application.UI;

public class Pizzaria {
    private Set<Ingredientes> listaIngredientesExistentes = new LinkedHashSet<>();
    private Set<Pizza> listaPizzaExistentes = new LinkedHashSet<>();
    private Map<Pizza, Integer> listadePedidos = new LinkedHashMap<>();

    public Pizzaria() {

    }

    public void adicionarIngrediente(Ingredientes ingrediente) {
        if (ingredienteExiste(ingrediente)) {
            throw new PizzariaExceptions("Ingrediente já existente");
        }
        listaIngredientesExistentes.add(ingrediente);
        UI.printMensagemSucesso("Ingrediente adicionado");
    }

    public void criarPizza(String sabor, String[] lista) {
        Ingredientes[] listaIng = transformarIngrediente(lista);
        if (listaIng == null) {
            throw new PizzariaExceptions("Um ou mais ingredientes não existem.");
        }
        listaPizzaExistentes.add(new Pizza(sabor, listaIng));
        UI.printMensagemSucesso("Pizza criada");
        Relatorio.setQuantidadeIng(lista.length);
        Relatorio.setQuantidadePizza();

    }

    private Ingredientes[] transformarIngrediente(String[] lista) {
        Ingredientes[] ingredientes = new Ingredientes[lista.length];
        int count = 0;
        for (Ingredientes ing : listaIngredientesExistentes) {
            if (count >= lista.length) {
                return ingredientes;
            }
            if (ing.getId() == Integer.parseInt(lista[count])) {
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
        listadePedidos.put(saborParaPizza(sabor), mesa);
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
            throw new PizzariaExceptions("Não existe pedidos");
        }
        Entry<Pizza, Integer> primeiroPar = listadePedidos.entrySet().iterator().next();
        Relatorio.ingredientePedido(primeiroPar.getKey().getIngredienteDaPizza());
        UI.printMensagemSucesso("Pedido servido: " + primeiroPar.getKey() + "para mesa: " + primeiroPar.getValue());
        listadePedidos.remove(primeiroPar.getKey());
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
