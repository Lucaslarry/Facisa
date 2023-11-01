package entities;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Pizzaria {
    private Set<Ingredientes> listaIngredientesExistentes = new LinkedHashSet<>();
    private Set<Pizza> listaPizzaExistentes = new LinkedHashSet<>();
    private Map<String, Integer> listadePedidos = new LinkedHashMap<>();

    public Pizzaria() {

    }

    public void adicionarIngrediente(Ingredientes ingrediente) {
        if (ingredienteExiste(ingrediente)) {
            throw new PizzariaExceptions("Ingrediente já existente");
        } else {
            listaIngredientesExistentes.add(ingrediente);
        }
    }

    public void criarPizza(String sabor, String[] lista) {
        Ingredientes[] listaIng = transformarParaIng(lista);
        if (listaIng != null) {
            listaPizzaExistentes.add(new Pizza(sabor, listaIng));
        } else {
            throw new PizzariaExceptions("Um ou mais ingredientes não existem.");
        }

    }

    private Ingredientes[] transformarParaIng(String[] lista) {
        Ingredientes[] ingredientes = new Ingredientes[lista.length];
        int count = 0;
        for (Ingredientes ing : listaIngredientesExistentes) {
            if (count > lista.length) {
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
        if (listaPizzaExistentes.stream().anyMatch(p -> p.getNomeDoSabor().equals(sabor))) {
            listadePedidos.put(sabor, mesa);
        } else {
            throw new PizzariaExceptions("Este sabor de pizza não está disponivel no cardápio");
        }
    }

    public void servirPedido() {
        String chaveRemovida = listadePedidos.keySet().iterator().next();
        listadePedidos.remove(chaveRemovida);
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
