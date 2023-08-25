package entities;

import java.util.ArrayList;
import java.util.Iterator;
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
        try {
            if (verificarCodigo(prod.getCodigo())) {
                produtosCadastrados.add(prod);
                System.out.println("Produto Cadastrado com sucesso! " + prod);
            } else {
                throw new ProdutosException("Produto não cadastrado: Código duplicado");
            }
        } catch (ProdutosException e) {
            System.out.println(e.getMessage());
        }

    }

    public void listarProdutos() {
        for (Produtos prod : produtosCadastrados) {
            System.out.println(prod);
        }
    }

    public void adicionarEstoque(int codigo, int addEstoque) {
        boolean produtoEncontrado = false;
        try {
            for (Produtos prod : produtosCadastrados) {
                if (prod.getCodigo() == codigo) {
                    prod.setEstoque(prod.getEstoque() + addEstoque);
                    System.out.println("Estoque atualizado com sucesso!");
                    produtoEncontrado = true;
                    break;
                }
            }
            if (!produtoEncontrado) {
                throw new ProdutosException("Não existe produto cadastrado com esse código");
            }

        } catch (ProdutosException e) {
            e.getMessage();
        }
    }

    public void removerProduto(int codigo) {
        try {
            boolean produtoEncontrado = false;
            Iterator<Produtos> iterator = produtosCadastrados.iterator();

            while (iterator.hasNext()) {
                Produtos prod = iterator.next();
                if (prod.getCodigo() == codigo) {
                    iterator.remove();
                    produtoEncontrado = true;
                    System.out.println("Produto removido com sucesso!");
                }
            }

            if (!produtoEncontrado) {
                throw new ProdutosException("Não existe produto cadastrado com esse código");
            }
        } catch (ProdutosException e) {
            System.out.println(e.getMessage());
        }
    }

    public void venderProduto(int codigo, int removeEstoque) {
        boolean produtoEncontrado = false;

        try {

            for (Produtos prod : produtosCadastrados) {
                if (prod.getCodigo() == codigo) {
                    if (prod.getEstoque() >= removeEstoque) {
                        prod.setEstoque(prod.getEstoque() - removeEstoque);
                        System.out.println("Produto vendido com sucesso!");
                        produtoEncontrado = true;
                        break;
                    }
                }
            }
            if (!produtoEncontrado) {
                throw new ProdutosException("Não existe produto cadastrado com esse código");
            }
        } catch (ProdutosException e) {
            System.out.println(e.getMessage());
        }
    }
}
