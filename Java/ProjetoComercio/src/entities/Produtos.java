package entities;

public class Produtos {
    String nome;
    int codigo;
    int estoque;

    public Produtos(String nome, int codigo) {
        this.nome = nome;
        this.codigo = codigo;
        this.estoque = 0;
    }

    public Produtos(String nome, int codigo, int estoque) {
        this.nome = nome;
        this.codigo = codigo;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return this.nome + " (cód.: " + this.codigo + " | estoque: " + this.estoque + ")";
    }
}