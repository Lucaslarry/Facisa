package entities;

import java.util.Set;

public class Relatorio {
    private static Double quantidadeIng = 0.0;
    private static Double quantidadePizza = 0.0;
    private static int quantidadeDePizzaSevida = 0;
    private static Ingredientes ingredienteMaisPedido = null;

    public static Ingredientes getIngredienteMaisPedido() {
        return ingredienteMaisPedido;
    }

    public static void setQuantidadePizza() {
        quantidadePizza += 1;
    }

    public static void setQuantidadeDePizzaSevida() {
        quantidadeDePizzaSevida += 1;
    }

    public static int getQuantidadeDePizzaSevida() {
        return quantidadeDePizzaSevida;
    }

    public static void setQuantidadeIng(int novaQuantidadeIng) {
        quantidadeIng += novaQuantidadeIng;
    }

    public static int getQuantidadeDoMaisPedido() {
        return ingredienteMaisPedido.getQuantidadeDeVezesPedido();
    }

    public static String getQuantidadeMediaDeIngredientes() {
        if ((quantidadeIng / quantidadePizza) >= 1) {
            return String.format("%.2f", (quantidadeIng / quantidadePizza));
        } else {
            return "0";
        }
    }

    private static void testeIngrediente(Ingredientes ing) {
        if (ingredienteMaisPedido == null) {
            ingredienteMaisPedido = ing;
        }
        if (ingredienteMaisPedido.getQuantidadeDeVezesPedido() < ing.getQuantidadeDeVezesPedido()) {
            ingredienteMaisPedido = ing;
        }
    }

    public static void ingredientePedido(Ingredientes[] lista) {
        for (Ingredientes ing : lista) {
            if (ing != null) {
                ing.setQuantidademaisum();
                testeIngrediente(ing);
            }
        }

    }

    public static String ingredientesNaoPedidos(Set<Ingredientes> lista) {
        StringBuilder sb = new StringBuilder();
        for (Ingredientes ing : lista) {
            if (ing != null && ing.getQuantidadeDeVezesPedido() == 0) {
                sb.append(ing.getIngrediente());
                sb.append(", ");
            }
        }
        if (sb.length() == 0) {
            return null;
        }
        sb.setLength(sb.length() - 2);
        return sb.toString().trim();
    }

}
