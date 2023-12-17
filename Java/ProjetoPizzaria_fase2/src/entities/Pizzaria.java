package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import application.UI;

public class Pizzaria {
    private List<Ingrediente> listaIngredientes = new ArrayList<>();
    private List<Pizza> listaPizzas = new ArrayList<>();
    private LinkedList<Pedido> listaPedidos = new LinkedList<>();
    List<String> listaNomes = Arrays.asList("Lucas", "Bernardo", "Henrique", "Freitas", "Diego", "Micael");
    private int id = 1;

    public Pizzaria() {

    }

    public List<Ingrediente> getlistaIngredientes() {
        return listaIngredientes;
    }

    public List<Pizza> getlistaPizzas() {
        return listaPizzas;
    }

    public int getQuantidadePedidos() {
        return listaPedidos.size();
    }

    /**
     * Adiciona novos ingredientes à lista de ingredientes da pizzaria.
     *
     * @param lista Uma lista de nomes de ingredientes a serem adicionados.
     */
    public void adicionarIngrediente(String[] lista) {
        // Itera sobre a lista de nomes de ingredientes
        for (String ing : lista) {
            // Cria um novo objeto Ingrediente com o nome formatado usando a classe UI
            listaIngredientes.add(new Ingrediente(UI.formatarTexto(ing)));
        }
    }

    /**
     * Cria uma nova pizza com o sabor especificado e a lista de ingredientes
     * fornecida.
     *
     * @param novoSabor          O sabor da nova pizza a ser criada.
     * @param stringIngredientes Uma lista de nomes de ingredientes a serem
     *                           adicionados à pizza.
     * @throws PizzariaExceptions Se um ou mais ingredientes não existirem, uma
     *                            exceção é lançada.
     */
    public void criarPizza(String novoSabor, List<String> stringIngredientes) {
        // Converte a lista de nomes de ingredientes em um array de Ingredientes
        List<Ingrediente> listaIng = transformarIngrediente(stringIngredientes);

        // Verifica se os ingredientes já foram previamente adicionados
        if (listaIng == null) {
            throw new PizzariaExceptions("Um ou mais ingredientes não existem.");
        }

        // Cria uma nova pizza com o sabor e a lista de ingredientes especificados
        listaPizzas.add(new Pizza(novoSabor, listaIng));

        // Imprime uma mensagem de sucesso
        UI.printMensagemSucesso("Pizza criada");

        // Atualiza as estatísticas
        Relatorio.setQuantidadePizza();
    }

    /**
     * Converte uma lista de nomes de ingredientes em um array de objetos
     * Ingrediente correspondentes.
     *
     * @param lista A lista de nomes de ingredientes a serem convertidos.
     * @return Um array de objetos Ingrediente correspondentes aos nomes na lista.
     *         Retorna null se um nome na lista não corresponder a nenhum
     *         Ingrediente.
     */
    private List<Ingrediente> transformarIngrediente(List<String> lista) {
        // Cria um array de Ingrediente com o mesmo tamanho da lista de nomes de
        // ingredientes
        Ingrediente[] ingredientes = new Ingrediente[lista.size()];
        int count = 0;
        // Itera até que sejam preenchidos todos os elementos do array
        while (count != 5) {
            // Itera sobre a lista de ingredientes disponíveis na pizzaria
            for (Ingrediente ing : listaIngredientes) {
                // Verifica se todos os elementos do array foram preenchidos
                if (count == lista.size()) {
                    // Retorna a lista convertida para evitar processamento desnecessário
                    return Arrays.asList(ingredientes);
                }
                // Verifica se o ingrediente atual da lista é igual ao nome de ingrediente na
                // posição da lista
                if (ing.getIngrediente().equals(lista.get(count))) {
                    // Adiciona o ingrediente ao array e incrementa o contador
                    ingredientes[count] = ing;
                    count++;
                }
            }
        }
        // Verifica se nenhum nome de ingrediente correspondeu
        if (count == 0) {
            return null;
        }

        // Retorna a lista convertida
        return Arrays.asList(ingredientes);
    }

    /**
     * Compara as pizzas disponíveis com base na quantidade de ingredientes em comum
     * com a lista de ingredientes fornecida.
     *
     * @param listaIngrediente A lista de ingredientes a ser comparada.
     * @return A melhor pizza com base na quantidade de ingredientes em comum.
     * @throws PizzariaExceptions Se a quantidade de ingredientes em comum for menor
     *                            que 3, lança uma exceção.
     */
    private Pizza compararIng(List<Ingrediente> listaIngrediente) {
        Pizza melhorPizza = null; // Inicializa a variável para armazenar a melhor pizza encontrada
        int ingredientesIguais = 0; // Inicializa a contagem de ingredientes em comum

        // Itera sobre todas as pizzas disponíveis
        for (Pizza pizza : listaPizzas) {
            // Obtém a lista de ingredientes da pizza atual
            List<Ingrediente> ingDaPizza = pizza.getIngredienteDaPizza();

            // Conta a quantidade de ingredientes em comum entre a pizza atual e a lista de
            // ingredientes fornecida
            int ingredientesIguaisTemp = contarIngredientesComuns(ingDaPizza, listaIngrediente);

            // Verifica se a pizza atual tem mais ingredientes em comum do que a melhor
            // pizza encontrada até agora
            if (ingredientesIguaisTemp > ingredientesIguais) {
                // Atualiza a contagem e armazena a referência para a pizza atual como a melhor
                // pizza
                ingredientesIguais = ingredientesIguaisTemp;
                melhorPizza = pizza;
            }
        }

        // Verifica se a quantidade de ingredientes em comum é menor que 3, lançando uma
        // exceção se verdadeiro
        if (ingredientesIguais < 3) {
            throw new PizzariaExceptions("Não há pizzas compatíveis");
        }

        // Atualiza o relatório com a quantidade de ingredientes corretos
        Relatorio.maisUmIngredienteCorreto(ingredientesIguais);

        // Retorna a melhor pizza encontrada
        return melhorPizza;
    }

    /**
     * Conta a quantidade de ingredientes em comum entre a lista de ingredientes de
     * uma pizza e uma lista de ingredientes fornecida.
     *
     * @param ingDaPizza       A lista de ingredientes da pizza.
     * @param listaIngrediente A lista de ingredientes a ser comparada.
     * @return A quantidade de ingredientes em comum.
     */
    private int contarIngredientesComuns(List<Ingrediente> ingDaPizza, List<Ingrediente> listaIngrediente) {
        // Mapa para armazenar a contagem de ocorrências de cada ingrediente na lista de
        // ingredientes da pizza
        Map<Ingrediente, Integer> listaCompararIng = new HashMap<>();

        int ingRepetidos = 0; // Inicializa a variável para armazenar a quantidade de ingredientes em comum
        boolean ingCompativel; // Variável para verificar a compatibilidade de um ingrediente

        // Itera sobre a lista de ingredientes da pizza
        for (Ingrediente ing : ingDaPizza) {
            // Verifica se o ingrediente já está presente no mapa
            if (listaCompararIng.containsKey(ing)) {
                // Se presente, incrementa a contagem de ocorrências
                listaCompararIng.replace(ing, listaCompararIng.get(ing) + 1);
            } else {
                // Se não presente, adiciona o ingrediente ao mapa com uma ocorrência
                listaCompararIng.put(ing, 1);
            }
        }

        // Itera sobre a lista de ingredientes fornecida
        for (Ingrediente ing : listaIngrediente) {
            // Verifica se o ingrediente está presente no mapa
            ingCompativel = listaCompararIng.containsKey(ing);

            // Se o ingrediente for compatível, incrementa a contagem de ingredientes em
            // comum
            if (ingCompativel) {
                ingRepetidos += 1;
            }
        }

        return ingRepetidos; // Retorna a quantidade total de ingredientes em comum
    }

    /**
     * Compara as pizzas disponíveis na lista de pizzas com a pizza do primeiro
     * pedido na lista de pedidos.
     * Retorna a pizza que tem a maior quantidade de ingredientes em comum com a
     * pizza do pedido.
     *
     * @return A pizza com a maior quantidade de ingredientes em comum.
     * @throws PizzariaExceptions Se não existirem sabores de pizza disponíveis.
     */
    private Pizza compararPizza() {
        // Verifica se a lista de pizzas está vazia
        if (listaPizzas.isEmpty()) {
            throw new PizzariaExceptions("Não existem sabores de pizza");
        }

        // Obtém a lista de ingredientes da pizza do primeiro pedido na lista de pedidos
        List<Ingrediente> listaIngrediente = listaPedidos.getFirst().getPizza().getIngredienteDaPizza();

        // Chama o método compararIng para encontrar a pizza com a maior quantidade de
        // ingredientes em comum
        Pizza melhorPizza = compararIng(listaIngrediente);

        return melhorPizza; // Retorna a pizza com a maior quantidade de ingredientes em comum
    }

    /**
     * Serve o primeiro pedido da lista de pedidos, comparando a pizza do pedido com
     * as pizzas disponíveis
     * e escolhendo a que tem a maior quantidade de ingredientes em comum.
     * Imprime uma mensagem de sucesso indicando que o pedido foi entregue.
     *
     * @throws PizzariaExceptions Se não foram feitos pedidos.
     */
    public void servirPedido() {
        // Verifica se a lista de pedidos está vazia
        if (listaPedidos.isEmpty()) {
            throw new PizzariaExceptions("Não foram feitos pedidos");
        }

        // Chama o método compararPizza para encontrar a pizza apropriada para o pedido
        Pizza pizza = compararPizza();

        // Imprime uma mensagem indicando que o pedido foi entregue com sucesso
        UI.printMensagemSucesso(
                "Pedido " + listaPedidos.getFirst().getId() +
                        " " + pizza +
                        " | Entregue para: " + listaPedidos.getFirst().getCliente());

        // Registra os ingredientes da pizza entregue no relatório
        Relatorio.ingredientePedido(listaPedidos.getFirst().getPizza().getIngredienteDaPizza());

        // Remove a pizza entregue da lista de pizzas e o pedido da lista de pedidos
        listaPizzas.remove(pizza);
        listaPedidos.removeFirst();

        // Atualiza as estatísticas para a quantidade de pizzas servidas
        Relatorio.setQuantidadeDePizzaSevida();
    }

    /**
     * Cria um novo pedido com uma pizza aleatória e um cliente aleatório.
     */
    public void criarPedidoAleatorio() {
        // Cria uma pizza aleatória usando o método criarPizzaAleatoria
        Pizza pizza = criarPizzaAleatoria();

        // Gera um índice aleatório para escolher um nome da lista de nomes
        Cliente cliente = new Cliente(listaNomes.get(gerarNumero(listaNomes.size() - 1)));

        // Adiciona um novo pedido à lista de pedidos, utilizando o id atual, a pizza
        // aleatória e o cliente aleatório
        listaPedidos.add(new Pedido(id, pizza, cliente));

        // Imprime uma mensagem indicando que o pedido foi criado com sucesso, incluindo
        // informações sobre o pedido
        UI.printMensagemSucesso(
                "Pedido: " + id + " | criado para: " + cliente + " | sabor: " + pizza);

        // Incrementa o id para o próximo pedido
        id++;
    }

    /**
     * Cria uma nova pizza aleatória com um sabor específico e uma lista aleatória
     * de ingredientes.
     * Utiliza o fid atual para o sabor da pizza.
     * Gera uma lista temporária contendo todos os ingredientes disponíveis.
     * Seleciona aleatoriamente cinco ingredientes dessa lista e cria a pizza com
     * esses ingredientes.
     *
     * @return Uma nova instância de Pizza com sabor aleatório e ingredientes
     *         aleatórios.
     */
    private Pizza criarPizzaAleatoria() {
        // Gera o sabor da pizza utilizando o nome "Aleatorio" seguido pelo id atual
        String sabor = "Aleatorio " + id;

        // Cria uma lista temporária contendo todos os ingredientes disponíveis
        List<Ingrediente> temp = new ArrayList<>();
        temp.addAll(listaIngredientes);

        // Cria uma lista temporária para armazenar os nomes dos ingredientes
        // selecionados
        List<String> temp2 = new ArrayList<>();

        // Seleciona aleatoriamente cinco ingredientes da lista de ingredientes
        // disponíveis
        for (int i = 1; i <= 5; i++) {
            // Gera um número aleatório para escolher um índice da lista de ingredientes
            // temporária
            int numero = gerarNumero(temp.size());

            // Adiciona o nome do ingrediente selecionado à lista temporária de nomes de
            // ingredientes
            temp2.add(temp.get(numero).getIngrediente());
        }

        // Cria uma nova instância de Pizza com o sabor aleatório e a lista de
        // ingredientes aleatórios
        Pizza pizza = new Pizza(sabor, transformarIngrediente(temp2));

        // Retorna a pizza criada
        return pizza;
    }

    /**
     * Retorna o primeiro pedido da lista de pedidos.
     *
     * @return O primeiro pedido da lista de pedidos.
     * @throws PizzariaExceptions Se a lista de pedidos estiver vazia.
     */
    public Pedido olharPedido() {
        // Verifica se existe pelo menos um pedido na lista
        if (listaPedidos.size() == 0) {
            // Lança uma exceção se a lista de pedidos estiver vazia
            throw new PizzariaExceptions("Não existem pedidos");
        }

        // Retorna o primeiro pedido da lista de pedidos
        return listaPedidos.getFirst();
    }

    /**
     * Gera um número aleatório de 0 até o tamanho especificado.
     *
     * @param tamanho O tamanho máximo para gerar o número aleatório.
     * @return Um número aleatório de 0 até o tamanho especificado.
     */
    private int gerarNumero(int tamanho) {
        // Cria um objeto Random para gerar números aleatórios
        Random random = new Random();

        // Gera um número aleatório de 0 até o tamanho especificado
        int numeroAleatorio = random.nextInt(tamanho);

        // Retorna o número aleatório gerado
        return numeroAleatorio;
    }

}
