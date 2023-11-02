package application;

public class UI {

    public static void menu() {
        System.out.println(" 1. Criar uma pizza");
        System.out.println(" 2. Criar um novo pedido");
        System.out.println(" 3. Servir um pedido");
        System.out.println(" 4. Adicionar ingrendiente");
        System.out.println(" 5. Estátistica dos pedidos");
        System.out.println(" 6. Sair do programa");
        System.out.print("Sua escolha: ");
    }

    public static void printMensagemSucesso(String msg) {
        System.out.println(msg + " com sucesso!");
    }

    public static String formatarTexto(String texto) {
        String[] palavras = texto.split(" ");
        StringBuilder resultado = new StringBuilder();

        for (String palavra : palavras) {
            if (!palavra.isEmpty()) {
                char primeiraLetra = Character.toUpperCase(palavra.charAt(0));
                String restoDaPalavra = palavra.substring(1);
                resultado.append(primeiraLetra).append(restoDaPalavra).append(" ");
            }
        }

        return resultado.toString().trim();
    }

}
