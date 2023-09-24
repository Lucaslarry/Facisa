package entities;

import application.UI;
import entities.categorias.Categoria;
import entities.categorias.Comida;
import entities.categorias.Eletronico;

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
        if (estoque < 0) {
            throw new ProdutosException("O estoque não pode ser menor que 0!");
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
        if (estoque < 0) {
            throw new ProdutosException("O estoque não pode ser menor que 0!");
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

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public String toCsvString() {
        return this.nome + "," + this.codigo + "," + this.estoque + "," + this.categoria + ","
                + UI.FormatarDecimal(this.custoDeCompra)
                + ","
                + UI.FormatarDecimal(this.valorDeVenda);
    }

    private static Categoria acharCat(String campo) {
        if (campo.equals("Eletronico")) {
            return new Eletronico();
        }
        if (campo.equals("Comida")) {
            return new Comida();
        }

        return null;
    }

    public static Produtos fromCsvString(String csvString) throws ProdutosException {

        String[] campos = csvString.split(",");
        String stringCat = campos[3];

        String nome = campos[0];
        int codigo = Integer.parseInt(campos[1]);
        int estoque = Integer.parseInt(campos[2]);
        Categoria categoria = acharCat(stringCat);
        Double custoDeCompra = Double.parseDouble(campos[4]);
        Double valorDeVenda = Double.parseDouble(campos[5]);

        return new Produtos(nome, codigo, estoque, categoria, custoDeCompra, valorDeVenda);
    }

    @Override
    public String toString() {
        return this.nome + " (cód.: " + this.codigo + " | estoque: " + this.estoque +
                " | categoria: " + this.categoria + " | custo de compra: " + UI.FormatarDecimal(this.custoDeCompra)
                + " | Valor de Venda: " + UI.FormatarDecimal(this.valorDeVenda) + ")";
    }

}
