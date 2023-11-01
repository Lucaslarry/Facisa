package entities;

import java.util.LinkedHashSet;
import java.util.Set;

public class Ingredientes {
    Set<String> listaIngredientes = new LinkedHashSet<>();
    String ingrediente;

    public Ingredientes(String novoIngrediente) {
        this.ingrediente = novoIngrediente;
    }

    public void adicionarIngrediente(String ingrediente) {
        if (ingredienteExiste(ingrediente)) {
            throw new PizzariaExceptions("Ingrediente já existente");
        } else {
            listaIngredientes.add(ingrediente);
        }
    }

    private boolean ingredienteExiste(String ingrediente) {
        return listaIngredientes.contains(ingrediente);
    }

    public Set<String> getListaIngredientes() {
        return listaIngredientes;
    }
}
