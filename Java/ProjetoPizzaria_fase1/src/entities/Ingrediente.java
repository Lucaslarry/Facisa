package entities;

public class Ingrediente {
    private String ingrediente;
    private int quantidadeDeVezesPedido = 0;

    public Ingrediente(String novoIngrediente) {
        this.ingrediente = novoIngrediente;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public int getQuantidadeDeVezesPedido() {
        return quantidadeDeVezesPedido;
    }

    public void setQuantidadeDeVezesPedido(int quantidadeDeVezesPedido) {
        this.quantidadeDeVezesPedido = quantidadeDeVezesPedido;
    }

    public void setQuantidademaisum() {
        this.quantidadeDeVezesPedido += 1;
    }

    @Override
    public String toString() {
        return ingrediente;
    }

}
