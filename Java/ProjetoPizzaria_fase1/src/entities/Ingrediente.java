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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ingrediente == null) ? 0 : ingrediente.hashCode());
        result = prime * result + quantidadeDeVezesPedido;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ingrediente other = (Ingrediente) obj;
        if (ingrediente == null) {
            if (other.ingrediente != null)
                return false;
        } else if (!ingrediente.equals(other.ingrediente))
            return false;
        if (quantidadeDeVezesPedido != other.quantidadeDeVezesPedido)
            return false;
        return true;
    }

}
