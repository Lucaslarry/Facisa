package entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entities.categorias.Categoria;

public class Comercio {

    List<Produtos> produtosCadastrados = new ArrayList<>();

    public Comercio(Produtos prod) {
        cadastrarProduto(prod);
    }

    public boolean verificarCodigo(int codigo) {
        for (Produtos prod : produtosCadastrados) {
            if (prod.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarSaldo(Double preco) {
        double novoSaldo = Relatorio.getSaldo() - preco;
        if (novoSaldo >= 0) {
            return true;
        } else {
            try {
                throw new ProdutosException("Não há saldo o suficiente para comprar este produto");
            } catch (ProdutosException e) {
                System.out.println(e.getMessage());
            }
            return false;
        }
    }

    public void cadastrarProduto(Produtos prod) {
        try {
            if (!verificarCodigo(prod.getCodigo()) && verificarSaldo(prod.getCustoDeCompra())) {
                produtosCadastrados.add(prod);
                System.out.println("Produto Cadastrado com sucesso! " + prod);
                Relatorio.diminuirSaldo(prod.getCustoDeCompra());
            } else {
                throw new ProdutosException("Produto não cadastrado");
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

    public void listarProdutosCategoria(Categoria cat) {
        for (Produtos prod : produtosCadastrados) {
            if (cat.getClass().equals(prod.getCategoria().getClass())) {
                ProdutoWrapper prodWrapper = new ProdutoWrapper(prod);
                System.out.println(prodWrapper);
            }
        }
    }

    public void adicionarEstoque(int codigo, int addEstoque) {

        try {
            for (Produtos prod : produtosCadastrados) {
                if (prod.getCodigo() == codigo) {
                    if (!verificarSaldo(prod.getCustoDeCompra())) {
                        break;
                    }
                    prod.setEstoque(prod.getEstoque() + addEstoque);
                    System.out.println("Estoque atualizado com sucesso!");
                    break;
                }
            }
            if (!verificarCodigo(codigo)) {
                throw new ProdutosException("Não existe produto cadastrado com esse código");
            }

        } catch (ProdutosException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removerProduto(int codigo) {
        try {
            Iterator<Produtos> iterator = produtosCadastrados.iterator();

            while (iterator.hasNext()) {
                Produtos prod = iterator.next();
                if (prod.getCodigo() == codigo) {
                    iterator.remove();
                    System.out.println("Produto removido com sucesso!");
                }
            }
            if (!verificarCodigo(codigo)) {
                throw new ProdutosException("Não existe produto cadastrado com esse código");
            }
        } catch (ProdutosException e) {
            System.out.println(e.getMessage());
        }
    }

    public void venderProduto(int codigo, int removeEstoque) {

        try {
            for (Produtos prod : produtosCadastrados) {
                if (prod.getCodigo() == codigo) {
                    if (prod.getEstoque() >= removeEstoque) {
                        prod.setEstoque(prod.getEstoque() - removeEstoque);
                        System.out.println("Produto vendido com sucesso!");
                        Relatorio.acrescentarSaldo(prod.getValorDeVenda());
                        break;
                    } else {
                        System.out.println("Não há estoque o suficiente.");
                    }
                }
            }
            if (!verificarCodigo(codigo)) {
                throw new ProdutosException("Não existe produto cadastrado com esse código");
            }
        } catch (ProdutosException e) {
            System.out.println(e.getMessage());
        }
    }
}