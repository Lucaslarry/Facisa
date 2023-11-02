package entities;

public class Ingredientes {
    private String ingrediente;
    private int id;
    private int quantidadeDeVezesPedido = 0;

    public Ingredientes(String novoIngrediente, int novoId) {
        this.ingrediente = novoIngrediente;
        this.id = novoId;
    }

    public int getId() {
        return id;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public int getQuantidadeDeVezesPedido() {
        return quantidadeDeVezesPedido;
    }

    public void setQuantidademaisum() {
        this.quantidadeDeVezesPedido += 1;
    }

    @Override
    public String toString() {
        return id + ": " + ingrediente;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ingrediente == null) ? 0 : ingrediente.hashCode());
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
        Ingredientes other = (Ingredientes) obj;
        if (ingrediente == null) {
            if (other.ingrediente != null)
                return false;
        } else if (!ingrediente.equals(other.ingrediente))
            return false;
        return true;
    }

}
