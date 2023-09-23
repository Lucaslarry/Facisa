package entities;

public class ProdutoWrapper {
    private Produtos produto;

    public ProdutoWrapper(Produtos produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return produto.getNome() + " (cód.: " + produto.getCodigo() + " | estoque: " + produto.getEstoque() +
                " | atributos do produto: " + produto.getCategoria().getAtributo() + " | custo de compra: " +
                produto.getCustoDeCompra() + " | Valor de Venda: " + produto.getValorDeVenda() + ")";
    }
}