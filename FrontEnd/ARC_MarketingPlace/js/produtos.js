var carrinho = {};

function adicionarAoCarrinho(nomeProduto, precoProduto, imagemProduto) {
    if (carrinho[nomeProduto]) {
        carrinho[nomeProduto].quantidade++;
    } else {
        carrinho[nomeProduto] = {
            preco: precoProduto,
            quantidade: 1,
            imagem: imagemProduto
        };
    }
    BOTAO_COMPRAR.style.display = "block"
    atualizarTabelaCarrinho();
}

function removerDoCarrinho(nomeProduto) {
    delete carrinho[nomeProduto];
    atualizarTabelaCarrinho();
}

function atualizarTabelaCarrinho() {
    var tabelaCarrinho = document.getElementById("tabela_carrinho");

    tabelaCarrinho.innerHTML = "";

    for (var nomeProduto in carrinho) {
        var produto = carrinho[nomeProduto];
        var precoTotal = produto.preco * produto.quantidade;

        var linha = document.createElement("tr");


        var colunaImagem = document.createElement("td");
        var imagem = document.createElement("img");

        imagem.src = produto.imagem;
        colunaImagem.appendChild(imagem);
        linha.appendChild(colunaImagem);

        var colunaNome = document.createElement("td");
        colunaNome.innerHTML = nomeProduto;
        linha.appendChild(colunaNome);


        var colunaPreco = document.createElement("td");
        colunaPreco.innerHTML = "R$ " + precoTotal.toFixed(2);
        linha.appendChild(colunaPreco);

        var colunaRemover = document.createElement("td");
        var botaoRemover = document.createElement("button");
        botaoRemover.innerHTML = "Remover";
        botaoRemover.addEventListener("click", function () {
            removerDoCarrinho(nomeProduto);
        });
        colunaRemover.appendChild(botaoRemover);
        linha.appendChild(colunaRemover);

        tabelaCarrinho.appendChild(linha);
    }
}


function comprar() {
    window.location.href = "pagamento.html"
}

function voltar() {
    valor = confirm("Realmente deseja voltar?")

    if (valor) {
        window.location.href = 'perfil.html'
    }
}


const BOTAO_RYZEN5 = document.getElementById("ryzen5");
const BOTAO_I5 = document.getElementById("i5");
const BOTAO_RTX = document.getElementById("RTX");
const BOTAO_RX = document.getElementById("RX");
const BOTAO_COMPRAR = document.getElementById("comprar");
const BOTAO_VOLTAR = document.getElementById("voltar_produto");




BOTAO_VOLTAR.addEventListener("click", voltar);
BOTAO_RYZEN5.addEventListener("click", function () {
    adicionarAoCarrinho("Ryzen 5 - 5600", 1500.90, "https://media.pichau.com.br/media/catalog/product/cache/2f958555330323e505eba7ce930bdf27/1/0/100-100000927box_1.jpg");
});
BOTAO_I5.addEventListener("click", function () {
    adicionarAoCarrinho("i5-1400f", 1900.25, "https://images.kabum.com.br/produtos/fotos/112991/processador-intel-core-i5-10400f-cache-12mb-2-9ghz-lga-1200-bx8070110400f_1589199927_g.jpg");
});
BOTAO_RTX.addEventListener("click", function () {
    adicionarAoCarrinho("RTX 4090", 500.99, "https://http2.mlstatic.com/D_NQ_NP_917585-MLA52004310307_102022-O.jpg");
});
BOTAO_RX.addEventListener("click", function () {
    adicionarAoCarrinho("RX 6600XT", 900.25, "https://http2.mlstatic.com/D_NQ_NP_638727-MLA50235336411_062022-O.jpg");
});
BOTAO_COMPRAR.addEventListener("click", comprar)