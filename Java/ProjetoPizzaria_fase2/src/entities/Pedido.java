package entities;

public class Pedido {
    private int id;
    private Pizza pizza;
    private Cliente cliente;

    public Pedido(int novoId, Pizza saborPizza, Cliente nomeCliente) {
        this.id = novoId;
        this.pizza = saborPizza;
        this.cliente = nomeCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Pedido atual: Pedido " + this.id + " | " + this.cliente + " | " + this.pizza;
    }

}
