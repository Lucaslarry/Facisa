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
        return String.format("%.2f", (quantidadeIng / quantidadePizza));
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
        StringBuilder stringBuilder = new StringBuilder();
        for (Ingredientes ing : lista) {
            if (ing != null && ing.getQuantidadeDeVezesPedido() == 0) {
                stringBuilder.append(ing.getIngrediente());
                stringBuilder.append(", ");
            }
        }
        if (stringBuilder.length() == 0) {
            return null;
        }
        stringBuilder.setLength(stringBuilder.length() - 2);
        return stringBuilder.toString().trim();
    }

}
