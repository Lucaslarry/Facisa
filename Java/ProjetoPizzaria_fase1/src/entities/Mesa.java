package entities;

public class Mesa {
    private int numero;

    public Mesa(int numeroMesa) {
        this.numero = numeroMesa;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "" + numero;
    }
}
