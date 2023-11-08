package entities;

import java.util.Set;

public class Relatorio {
    private static Double quantidadeIng = 0.0;
    private static Double quantidadePizza = 0.0;
    private static int quantidadeDePizzaSevida = 0;
    private static Ingrediente ingredienteMaisPedido = null;

    public static Ingrediente getIngredienteMaisPedido() {
        return ingredienteMaisPedido;
    }

    public static int getQuantidadeDePizzaSevida() {
        return quantidadeDePizzaSevida;
    }

    public static int getQuantidadeDoMaisPedido() {
        return ingredienteMaisPedido.getQuantidadeDeVezesPedido();
    }

    /*
     * Calcula e retorna a quantidade média de ingredientes por pizza, formatada
     * como uma string.
     *
     * @return A quantidade média de ingredientes por pizza, formatada com 2 casas
     * decimais, ou "0" se não houver pizzas.
     */
    public static String getQuantidadeMediaDeIngredientes() {
        // Verifica se há pelo menos uma pizza
        if ((quantidadePizza) >= 1) {
            // Calcula a quantidade média de ingredientes por pizza e a formata
            return String.format("%.2f", (quantidadeIng / quantidadePizza));
        }
        // Retorna "0" se não houver pizzas
        return "0";
    }

    public static void setQuantidadePizza() {
        quantidadePizza += 1;
    }

    public static void setQuantidadeDePizzaSevida() {
        quantidadeDePizzaSevida += 1;
    }

    public static void setQuantidadeIng(int novaQuantidadeIng) {
        quantidadeIng += novaQuantidadeIng;
    }

    /*
     * Testa e atualiza o ingrediente mais pedido com base na quantidade de vezes
     * que foi pedido.
     *
     * @param ing: O ingrediente a ser testado.
     */
    private static void definirMaisPedido(Ingrediente ing) {
        // Verifica se o ingrediente mais pedido ainda não foi definido
        if (ingredienteMaisPedido == null) {
            ingredienteMaisPedido = ing;
        }
        // Compara a quantidade de vezes que o ingrediente atual foi pedido com o
        // ingrediente mais pedido
        if (ingredienteMaisPedido.getQuantidadeDeVezesPedido() < ing.getQuantidadeDeVezesPedido()) {
            // Atualiza o ingrediente mais pedido se o ingrediente atual for mais popular
            ingredienteMaisPedido = ing;
        }
        // Verifica se o ingrediente 'ing' está empatado com o ingrediente mais pedido.
        if (ingredienteMaisPedido.getQuantidadeDeVezesPedido() == ing.getQuantidadeDeVezesPedido()) {
            // Atualiza o ingrediente mais pedido criando um novo ingrediente
            ingredienteMaisPedido = new Ingrediente(maisPedidoEmpate(ing));
            // Atualiza a quantidade de vezes pedido para ser igual ao do ingrediente
            ingredienteMaisPedido.setQuantidadeDeVezesPedido(ing.getQuantidadeDeVezesPedido());
        }
    }

    /*
     * Retorna uma representação textual dos ingredientes empatados ou do
     * ingrediente mais pedido, se forem iguais.
     *
     * @param ing: O ingrediente a ser adicionado a String
     * 
     * @return Uma representação textual dos ingredientes empatados ou do
     * ingrediente mais pedido, se não houver empate.
     */
    private static String maisPedidoEmpate(Ingrediente ing) {
        if (!ing.getIngrediente().equals(ingredienteMaisPedido.getIngrediente())) {
            StringBuilder sb = new StringBuilder();
            sb.append(ingredienteMaisPedido.getIngrediente());
            sb.append(", ");
            sb.append(ing.getIngrediente());
            return sb.toString();
        }
        return ingredienteMaisPedido.getIngrediente();

    }

    /*
     * Atualiza a quantidade de vezes que cada ingrediente foi pedido e define o
     * ingrediente mais pedido.
     *
     * @param lista: A lista de ingredientes em um pedido.
     */
    public static void ingredientePedido(Ingrediente[] lista) {
        // Percorre a lista de ingredientes em um pedido
        for (Ingrediente ing : lista) {
            if (ing != null) {
                // Incrementa a quantidade de vezes que o ingrediente foi pedido
                ing.setQuantidademaisum();

                // Atualiza o ingrediente mais pedido
                definirMaisPedido(ing);
            }
        }

    }

    /*
     * Retorna uma lista de ingredientes que nunca foram pedidos, formatada como uma
     * única string.
     *
     * @param lista: Um conjunto de ingredientes a ser verificado.
     * 
     * @return Uma string contendo os ingredientes não pedidos, ou null se todos os
     * ingredientes foram pedidos.
     */
    public static String ingredientesNaoPedidos(Set<Ingrediente> lista) {
        StringBuilder sb = new StringBuilder();

        // Percorre o conjunto de ingredientes
        for (Ingrediente ing : lista) {
            if (ing != null && ing.getQuantidadeDeVezesPedido() == 0) {
                // Adiciona ingredientes não pedidos à string
                sb.append(ing.getIngrediente());
                sb.append(", ");
            }
        }

        // Verifica se há ingredientes não pedidos
        if (sb.length() == 0) {
            return null;
        }

        // Remove a vírgula e o espaço em excesso no final da string
        sb.setLength(sb.length() - 2);

        return sb.toString().trim(); // Retorna a lista de ingredientes não pedidos formatada
    }

}
