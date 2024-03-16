package entities;

public class Cliente {
    private String nome;

    public Cliente(String novoNome) {
        this.nome = novoNome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
