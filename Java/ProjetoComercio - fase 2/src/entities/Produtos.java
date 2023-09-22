package entities;

import entities.categorias.Categoria;

public class Produtos {
    private String nome;
    private int codigo;
    private int estoque;
    private Categoria categoria;
    private Double custoDeCompra;
    private Double valorDeVenda;

    public Produtos(String nome, int codigo, int estoque, Categoria categoria, Double custoDeCompra,
            Double valorDeVenda) throws ProdutosException {
        if (custoDeCompra > valorDeVenda) {
            throw new ProdutosException("O Valor de compra não pode ser maior que o de venda!");
        }
        this.nome = nome;
        this.codigo = codigo;
        this.estoque = estoque;
        this.categoria = categoria;
        this.custoDeCompra = custoDeCompra;
        this.valorDeVenda = valorDeVenda;
    }

    public Produtos(String nome, int codigo, Categoria categoria, Double custoDeCompra, Double valorDeVenda)
            throws ProdutosException {
        if (custoDeCompra > valorDeVenda) {
            throw new ProdutosException("O Valor de compra não pode ser maior que o de venda!");
        }
        this.nome = nome;
        this.codigo = codigo;
        this.categoria = categoria;
        this.custoDeCompra = custoDeCompra;
        this.valorDeVenda = valorDeVenda;
        this.estoque = 0;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public Double getCustoDeCompra() {
        return custoDeCompra;
    }

    public Double getValorDeVenda() {
        return valorDeVenda;
    }

    @Override
    public String toString() {
        return this.nome + " (cód.: " + this.codigo + " | estoque: " + this.estoque +
                " | categoria: " + this.categoria + " | custo de compra: " + this.custoDeCompra
                + " | Valor de Venda: " + this.valorDeVenda + ")";
    }
}
