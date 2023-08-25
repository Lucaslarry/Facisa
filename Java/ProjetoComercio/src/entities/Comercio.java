package entities;

import java.util.ArrayList;
import java.util.List;

public class Comercio {
    List<Produtos> produtosCadastrados = new ArrayList<>();

    public Comercio(Produtos prod) {
        cadastrarProduto(prod);
    }

    public boolean verificarCodigo(int codigo) {
        for (Produtos prod : produtosCadastrados) {
            if (prod.getCodigo() == codigo) {
                return false;
            }
        }
        return true;
    }

    public void cadastrarProduto(Produtos prod) {
        if (verificarCodigo(prod.getCodigo())) {
            produtosCadastrados.add(prod);
            System.out.println("Produto Cadastrado com sucesso! " + prod);
        } else {
            try {
                throw new ProdutosException("Produto não cadastrado: Código duplicado");
            } catch (ProdutosException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
