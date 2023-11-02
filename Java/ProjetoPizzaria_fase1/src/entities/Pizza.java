package entities;

public class Pizza {
    private final int TAMANHO = 5;
    private Ingredientes[] ingredienteDaPizza = new Ingredientes[TAMANHO];
    private String nomeDoSabor;
    private String descricao;

    public Pizza(String novoSabor, Ingredientes[] listaEscolha) {
        this.nomeDoSabor = novoSabor;
        ingredienteNaPizza(listaEscolha);
        criarDescricao();
    }

    private void ingredienteNaPizza(Ingredientes[] lista) {
        int count = 0;
        if (lista.length == 0) {
            throw new PizzariaExceptions("A pizza necessita de ao menos de 1 ingrediente");
        }
        if (lista.length > 5) {
            throw new PizzariaExceptions("A pizza só pode ter ao maximo " + TAMANHO + " ingredientes");
        }
        for (Ingredientes ing : lista) {
            ingredienteDaPizza[count] = ing;
            count++;
        }

    }

    private void criarDescricao() {
        StringBuilder sb = new StringBuilder();
        for (Ingredientes ing : ingredienteDaPizza) {
            if (ing != null) {
                sb.append(ing.getIngrediente() + " ");
            }
        }
        descricao = nomeDoSabor + " vem com: " + sb;
    }

    public Ingredientes[] getIngredienteDaPizza() {
        return ingredienteDaPizza;
    }

    public String getNomeDoSabor() {
        return nomeDoSabor;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
