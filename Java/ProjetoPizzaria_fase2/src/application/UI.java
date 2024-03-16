package application;

import java.util.Scanner;

public class UI {

    public static int menu(Scanner sc) {
        System.out.println(" 1. Receber um pedido");
        System.out.println(" 2. Olhar pedido atual");
        System.out.println(" 3. Preparar uma pizza");
        System.out.println(" 4. Servir pedido");
        System.out.println(" 5. Estátistica dos pedidos");
        System.out.println(" 6. Sair do programa");
        System.out.print("Sua escolha: ");
        return sc.nextInt();
    }

    public static void printMensagemSucesso(String msg) {
        System.out.println(msg + " com sucesso!");
    }

    public static void menuPizza() {
        System.out.println(" 1. Adicionar ingredientes para pizza");
        System.out.println(" 2. Remover ultimo ingrediente adicionado");
        System.out.println(" 3. Criar pizza");
        System.out.println(" 4. Voltar");
        System.out.print("Sua escolha: ");
    }

    public static int menuPedido(Scanner sc) {
        System.out.println(" 1. Escolher sabor existente");
        System.out.println(" 2. Criar novo sabor");
        System.out.println(" 3. Voltar");
        System.out.print("Sua escolha: ");
        return sc.nextInt();
    }

    public static String formatarTexto(String texto) {
        String[] palavras = texto.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String palavra : palavras) {
            if (!palavra.isEmpty()) {
                char primeiraLetra = Character.toUpperCase(palavra.charAt(0));
                String restoDaPalavra = palavra.substring(1);
                sb.append(primeiraLetra).append(restoDaPalavra).append(" ");
            }
        }

        return sb.toString().trim();
    }

}
