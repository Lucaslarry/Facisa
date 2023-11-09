package entities;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import application.UI;

public class Pizzaria {
    private Set<Ingrediente> listaIngredientes = new HashSet<>();
    private Set<Pizza> listaPizzas = new HashSet<>();
    private LinkedList<Pedido> listaPedidos = new LinkedList<>();

    public Pizzaria() {

    }

    public Set<Ingrediente> getlistaIngredientes() {
        return listaIngredientes;
    }

    public Set<Pizza> getlistaPizzas() {
        return listaPizzas;
    }

    /*
     * Adiciona novos ingrediente ao conjunto de ingredientes.
     *
     * @param novoIngrediente: Lista de ingredientes a ser adicionados.
     */
    public void addIngPre(String[] lista) {
        for (String ing : lista) {
            adicionarIngrediente(new Ingrediente(UI.formatarTexto(ing)));
        }

    }

    /*
     * Adiciona um novo ingrediente ao conjunto de ingredientes.
     *
     * @param novoIngrediente: O ingrediente a ser adicionado.
     * 
     * @throws PizzariaExceptions: Se o ingrediente já existe, uma exceção é
     * lançada.
     */
    public void adicionarIngrediente(Ingrediente novoIngrediente) {
        // Testa se o ingrediente já existe dentro do conjunto
        if (ingredienteExiste(novoIngrediente)) {
            throw new PizzariaExceptions("Ingrediente já existente");
        }

        // Adiciona o novo ingrediente ao conjunto
        listaIngredientes.add(novoIngrediente);

        // Imprime uma mensagem de sucesso
        UI.printMensagemSucesso("Ingrediente adicionado");
    }

    /*
     * Solicita o nome de um ingrediente inserido pelo usuário.
     *
     * @param sc: O objeto Scanner usado para a entrada do usuário.
     * 
     * @return: O nome do ingrediente formatado.
     */
    private String escolherIng(Scanner sc) {
        getlistaIngredientes().forEach(System.out::println);
        System.out.print("Digite no nome do ingrediente: ");
        String novoIng = sc.nextLine();
        return UI.formatarTexto(novoIng);
    }

    /*
     * Remove o último ingrediente adicionado à lista e exibe uma mensagem
     * correspondente.
     *
     * @param lista: A lista encadeada de ingredientes.
     */
    private void excluirUltimo(LinkedList<String> lista) {
        if (lista.isEmpty()) {
            System.out.println("Nenhum ingrediente foi adicionado");
        } else {
            System.out.println(lista.getLast() + " removido com sucesso!");
            lista.removeLast();
        }
    }

    /*
     * Solicita ao usuário que nomeie um novo sabor e retorna o nome do sabor.
     *
     * @param sc: O Scanner utilizado para entrada do usuário.
     * 
     * @return: O nome do sabor fornecido pelo usuário.
     */
    private String nomearSabor(Scanner sc) {
        System.out.print("Nomeie este sabor: ");
        String sabor = sc.nextLine();
        return sabor;
    }

    /*
     * Guia o usuário na preparação de uma pizza,
     * permitindo adicionar ingredientes,
     * excluir o último ingrediente
     * nomear o sabor
     * e criar a pizza.
     * Retorna o nome do sabor da pizza criada
     * ou null se o usuário optar por voltar.
     *
     * @param sc: O Scanner utilizado para entrada do usuário.
     * 
     * @param lista: A lista de ingredientes da pizza em construção.
     * 
     * @return: O nome do sabor da pizza criada ou null se o usuário optar por
     * voltar.
     */
    public String prepararPizza(Scanner sc, LinkedList<String> lista) {
        boolean adicionar = false;
        while (!adicionar) {
            int escolhaPizza = UI.menuPizza(sc);
            sc.nextLine();

            if (escolhaPizza == 1) {
                lista.add(escolherIng(sc));
            }
            if (escolhaPizza == 2) {
                excluirUltimo(lista);
            }
            if (escolhaPizza == 3) {
                String sabor = nomearSabor(sc);
                criarPizza(UI.formatarTexto(sabor), lista);
                return sabor;
            }
            if (escolhaPizza == 4) {
                System.out.println("Voltando...");
                adicionar = true;
            }
        }
        return null;

    }

    /*
     * Cria uma nova pizza com o sabor especificado e a lista de ingredientes
     * fornecida.
     * 
     * @param novoSabor: O sabor da nova pizza a ser criada.
     * 
     * @param stringIngredientes: Uma lista encadeada de nomes de ingredientes a
     * serem adicionados à pizza.
     * 
     * @throws PizzariaExceptions: Se um ou mais ingredientes não existirem, uma
     * exceção é lançada.
     */
    private void criarPizza(String novoSabor, LinkedList<String> stringIngredientes) {
        // Converte a lista de nomes de ingredientes em um array de Ingredientes
        Ingrediente[] listaIng = transformarIngrediente(stringIngredientes);

        // Verifica se os ingredientes já foram previamente adicionados
        if (listaIng == null) {
            throw new PizzariaExceptions("Um ou mais ingredientes não existem.");
        }

        // Cria uma nova pizza com o sabor e a lista de ingredientes especificados
        listaPizzas.add(new Pizza(novoSabor, listaIng));

        // Imprime uma mensagem de sucesso
        UI.printMensagemSucesso("Pizza criada");

        // Atualiza as estatísticas
        Relatorio.setQuantidadeIng(stringIngredientes.size());
        Relatorio.setQuantidadePizza();

    }

    /*
     * Converte uma lista de nomes de ingredientes em um array de objetos
     * Ingrediente correspondentes.
     *
     * @param lista: A lista de nomes de ingredientes a serem convertidos.
     *
     * @return Um array de objetos Ingrediente correspondentes aos nomes na lista.
     * Retorna null se um nome na lista não corresponder a nenhum
     * Ingrediente.
     */
    private Ingrediente[] transformarIngrediente(List<String> lista) {
        Ingrediente[] ingredientes = new Ingrediente[lista.size()];
        int count = 0;

        // Percorre a lista de nomes de ingredientes
        for (Ingrediente ing : listaIngredientes) {
            if (count == lista.size()) {
                return ingredientes;
            }

            // Verifica se o ingrediente atual é igual ao ingrediente na posição da lista
            if (ing.getIngrediente().equals(lista.get(count))) {
                ingredientes[count] = ing;
                count++;
            }
        }

        // Verifica se nenhum nome de ingrediente correspondeu
        if (count == 0) {
            return null;
        }

        return ingredientes;
    }

    /*
     * Cria um novo pedido com o sabor de pizza especificado para a mesa informada.
     *
     * @param sabor: O sabor da pizza a ser incluída no pedido.
     * 
     * @param mesa: O número da mesa para a qual o pedido está sendo criado.
     * 
     * @throws PizzariaExceptions: Se o sabor de pizza não estiver disponível no
     * cardápio, uma exceção é lançada.
     */
    public void criarPedido(String sabor, int mesa) {
        // Verifica se o sabor de pizza está disponível no cardápio
        if (!listaPizzas.stream().anyMatch(p -> p.getNomeDoSabor().equals(sabor))) {
            throw new PizzariaExceptions("Este sabor de pizza não está disponivel no cardápio");
        }

        // Cria um novo pedido com o sabor de pizza e a mesa informados
        listaPedidos.add(new Pedido(saborParaPizza(sabor), new Mesa(mesa)));

        // Imprime uma mensagem de sucesso
        UI.printMensagemSucesso("Pedido criado");
    }

    /*
     * Encontra e retorna uma instância de Pizza com base no sabor especificado.
     *
     * @param sabor: O sabor da pizza a ser encontrado.
     * 
     * @return Uma instância de Pizza correspondente ao sabor ou null se não
     * encontrada.
     */
    private Pizza saborParaPizza(String sabor) {
        for (Pizza pizzas : listaPizzas) {
            if (pizzas.getNomeDoSabor().equals(sabor)) {
                return pizzas;
            }
        }
        return null;
    }

    /*
     * Serve o primeiro pedido na lista de pedidos, atualizando as estatísticas e
     * removendo o pedido.
     *
     * @throws PizzariaExceptions: Se a lista de pedidos estiver vazia, uma exceção
     * é
     * lançada.
     */
    public void servirPedido() {
        // Verifica se a lista de pedidos está vazia
        if (listaPedidos.isEmpty()) {
            throw new PizzariaExceptions("Não existem pedidos");
        }

        // Obtém a primeira pizza no pedido
        Pizza primeiraPizza = listaPedidos.getFirst().getPizza();

        // Registra os ingredientes pedidos para fins estatísticos
        Relatorio.ingredientePedido(primeiraPizza.getIngredienteDaPizza());

        // Imprime uma mensagem de sucesso
        UI.printMensagemSucesso("Servido: " + listaPedidos.getFirst());

        // Remove o primeiro pedido da lista
        listaPedidos.remove();

        // Atualiza as estatísticas
        Relatorio.setQuantidadeDePizzaSevida();

    }

    private boolean ingredienteExiste(Ingrediente ingrediente) {
        // Verifica se o ingrediente já existe na lista
        return listaIngredientes.contains(ingrediente);
    }
}
