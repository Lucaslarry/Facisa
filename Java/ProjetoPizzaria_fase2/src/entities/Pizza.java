package entities;

import java.util.List;

public class Pizza {
    private final int TAMANHO = 5;
    private List<Ingrediente> ingredienteDaPizza;
    private String nomeDoSabor;
    private String descricao;

    public Pizza(String novoSabor, List<Ingrediente> listaIng) {
        this.nomeDoSabor = novoSabor;
        this.ingredienteDaPizza = ingredienteNaPizza(listaIng);
        this.descricao = criarDescricao();
    }

    public List<Ingrediente> getIngredienteDaPizza() {
        return ingredienteDaPizza;
    }

    public String getNomeDoSabor() {
        return nomeDoSabor;
    }

    public String getDescricao() {
        return descricao;
    }

    /*
     * Valida a lista de ingredientes para garantir que esteja dentro dos limites
     * permitidos.
     * 
     * @param lista: A lista de ingredientes a ser validada.
     * 
     * @throws PizzariaExceptions: Se a lista de ingredientes estiver vazia ou
     * exceder o limite máximo.
     */
    private List<Ingrediente> ingredienteNaPizza(List<Ingrediente> listaIng) {
        // Testa se há ingrediente o suficiente
        if (listaIng.size() != TAMANHO) {
            throw new PizzariaExceptions("A pizza tem que ter " + TAMANHO + " ingredientes");
        }
        return listaIng; // Retorna a lista

    }

    /*
     * Cria uma descrição da pizza que inclui a lista de ingredientes.
     * 
     * @return Uma descrição da pizza que inclui o nome do sabor e os ingredientes.
     */
    private String criarDescricao() {
        StringBuilder sb = new StringBuilder();

        for (Ingrediente ing : ingredienteDaPizza) {
            if (ing != null) {
                sb.append(ing.getIngrediente() + ", ");
            }
        }
        sb.setLength(sb.length() - 2);
        return "Pizza " + this.nomeDoSabor + " que vem com: " + sb;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
