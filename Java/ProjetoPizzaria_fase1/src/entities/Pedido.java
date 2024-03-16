package entities;

public class Pedido {

    private Pizza pizza;
    private Mesa mesa;

    public Pedido(Pizza saborPizza, Mesa numeroMesa) {
        this.pizza = saborPizza;
        this.mesa = numeroMesa;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public Pizza getPizza() {
        return pizza;
    }

    @Override
    public String toString() {
        return pizza + " para mesa: " + mesa;
    }

}
