package entities;

public class Produtos {
    private String nome;
    private int codigo;
    private int estoque;

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

    public int getEstoque() {
        return estoque;
    }

    protected void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return this.nome + " (cód.: " + this.codigo + " | estoque: " + this.estoque + ")";
    }
}
