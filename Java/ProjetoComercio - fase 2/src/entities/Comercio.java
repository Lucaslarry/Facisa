package entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entities.categorias.Categoria;

public class Comercio {

    List<Produtos> produtosCadastrados = new ArrayList<>();

    public Comercio(Produtos prod) throws ProdutosException {
        cadastrarProduto(prod);
        carregarProdutosDeArquivo();
    }

    public Comercio() throws ProdutosException {
        carregarProdutosDeArquivo();

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
            if (verificarCodigo(prod.getCodigo())) {
                int novoCodigo = prod.getCodigo() + 1;
                prod.setCodigo(novoCodigo);
                cadastrarProduto(prod);
            } else if (!verificarCodigo(prod.getCodigo()) && prod.getEstoque() == 0) {
                produtosCadastrados.add(prod);
                System.out.println("Produto Cadastrado com sucesso! " + prod);
            } else if (!verificarCodigo(prod.getCodigo())
                    && verificarSaldo(prod.getCustoDeCompra() * prod.getEstoque())) {
                produtosCadastrados.add(prod);
                System.out.println("Produto Cadastrado com sucesso! " + prod);
                Double novoSaldo = prod.getCustoDeCompra() * prod.getEstoque();
                Relatorio.diminuirSaldo(novoSaldo, prod.getNome(), prod.getEstoque());
            } else {
                throw new ProdutosException("Produto não cadastrado");
            }
        } catch (ProdutosException e) {
            System.out.println(e.getMessage());
        } finally {
            salvarProdutosEmArquivo();
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
                    if (!verificarSaldo(prod.getCustoDeCompra() * addEstoque)) {
                        break;
                    }
                    prod.setEstoque(prod.getEstoque() + addEstoque);
                    System.out.println("Estoque atualizado com sucesso!");
                    if (prod.getEstoque() > 0) {
                        Double novoSaldo = prod.getCustoDeCompra() * prod.getEstoque();
                        Relatorio.diminuirSaldo(novoSaldo, prod.getNome(), addEstoque);
                    }
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
                        Relatorio.acrescentarSaldo((prod.getValorDeVenda() * removeEstoque), prod.getNome(),
                                removeEstoque);
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

    public void salvarProdutosEmArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("listaProdutos.txt"))) {
            for (Produtos prod : produtosCadastrados) {
                bw.write(prod.toCsvString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar a lista de produtos: " + e.getMessage());
        }
    }

    public void carregarProdutosDeArquivo() throws ProdutosException {
        try (BufferedReader br = new BufferedReader(new FileReader("listaProdutos.txt"))) {
            produtosCadastrados.clear();

            String linha;
            while ((linha = br.readLine()) != null) {
                Produtos produto = Produtos.fromCsvString(linha);
                if (produto != null) {
                    produtosCadastrados.add(produto);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de produtos não encontrado.");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de produtos: " + e.getMessage());
        }
    }
}