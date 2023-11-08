package entities;

public class Pizza {
    private final int TAMANHO = 5;
    private Ingrediente[] ingredienteDaPizza;
    private String nomeDoSabor;
    private String descricao;

    public Pizza(String novoSabor, Ingrediente[] listaEscolha) {
        this.nomeDoSabor = novoSabor;
        this.ingredienteDaPizza = ingredienteNaPizza(listaEscolha);
        this.descricao = criarDescricao();
    }

    public Ingrediente[] getIngredienteDaPizza() {
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
    private Ingrediente[] ingredienteNaPizza(Ingrediente[] lista) {
        // Testa se não há ingredientes adicionados
        if (lista.length == 0) {
            throw new PizzariaExceptions("A pizza necessita de ao menos de 1 ingrediente");
        }
        // Testa se não há mais ingredientes que o possivel
        if (lista.length > TAMANHO) {
            throw new PizzariaExceptions("A pizza só pode ter ao maximo " + TAMANHO + " ingredientes");
        }
        return lista; // Retorna a lista

    }

    /*
     * Cria uma descrição da pizza que inclui o nome do sabor e a lista de
     * ingredientes.
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
        return nomeDoSabor + " que vem com: " + sb;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
