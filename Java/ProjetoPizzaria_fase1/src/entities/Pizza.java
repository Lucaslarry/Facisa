package entities;

public class Pizza {
    private final int TAMANHO = 5;
    private Ingredientes[] ingredienteDaPizza = new Ingredientes[TAMANHO];
    private String nomeDoSabor;

    public Pizza(String novoSabor, Ingredientes[] listaEscolha) {
        this.nomeDoSabor = novoSabor;
        ingredienteNaPizza(listaEscolha);
    }

    private void ingredienteNaPizza(Ingredientes[] lista) {
        int count = 0;
        if (lista.length == 0) {
            throw new PizzariaExceptions("A pizza necessita de ao menos de 1 ingrediente");
        } else if (lista.length > 5) {
            throw new PizzariaExceptions("A pizza só pode ter ao maximo " + TAMANHO + " ingredientes");
        } else {
            for (Ingredientes ing : lista) {
                ingredienteDaPizza[count] = ing;
                count++;
            }
        }

    }

    public Ingredientes[] getIngredienteDaPizza() {
        return ingredienteDaPizza;
    }

    public String getNomeDoSabor() {
        return nomeDoSabor;
    }

    @Override
    public String toString() {
        return nomeDoSabor;
    }
}
