package application;

public class UI {

    public static void menu() {
        System.out.println(" 1. Listar Produtos");
        System.out.println(" 2. Cadastrar Produtos");
        System.out.println(" 3. Adicionar Estoque");
        System.out.println(" 4. Remover Produtos");
        System.out.println(" 5. Vender Produtos");
        System.out.println(" 6. Fechar Loja");
        System.out.print("Sua escolha: ");
    }

    public static void menuCategorias() {
        System.out.println(" 1. Eletronico");
        System.out.println(" 2. Comida");
        System.out.print("Sua escolha: ");
    }

    public static String FormatarDecimal(Double valor) {
        String saldo = String.format("%.2f", valor);
        return saldo;
    }

}
