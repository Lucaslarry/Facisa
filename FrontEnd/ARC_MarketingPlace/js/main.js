function checar_dados(event) {
   event.preventDefault();
   var login = document.getElementById("login").value;
   var senha = document.getElementById("senha").value;



   if (login == email && senha == senha_cadastro) {
      window.location.href = "/FrontEnd/ARC_MarketingPlace/pages/perfil.html"
   }
   else if (email == null || senha == null) {
      alert("Você ainda não se cadastrou")
   }
   else {
      alert("Usuario ou Senha incorretos");
   }
}


function cadastrar(event) {
   event.preventDefault();
   if (FORMULARIO_CADASTRO.checkValidity()) {
      email = document.getElementById('email').value;
      senha_cadastro = document.getElementById('senha_cadastro').value;
      nome_completo = document.getElementById('nome_completo').value;
      localStorage.setItem('email', email)
      localStorage.setItem('senha', senha_cadastro)
      localStorage.setItem('nome', nome_completo)
      alert("cadastro realizado com sucesso")
      window.location.href = "/FrontEnd/ARC_MarketingPlace/index.html";

   }
   else {
      alert("Por favor, preencha todos os dados");
   }

}

function voltar() {
   let resposta = confirm("Realmente deseja voltar?");

   if (resposta) { window.location.href = '/FrontEnd/ARC_MarketingPlace/index.html'; }
}


function mudar_form(event) {
   event.preventDefault();
   let email_esquecer_senha = document.getElementById("email_esqueci_senha").value

   if (email_esquecer_senha == email) {
      BOTAO_ESQUECEU_SENHA1.style.display = "none";
      BOTAO_ESQUECEU_SENHA2.style.display = "block";
      FORMULARIO_ESQUECER1.style.display = "none";
      FORMULARIO_ESQUECER2.style.display = "block";
      document.getElementById("texto_mudar_senha").innerHTML = "Digite sua nova senha:";

   }
   else {
      alert("Email Digitado não existe!")
   }
}

function resetar_senha(event) {
   event.preventDefault();
   senha_cadastro = document.getElementById("senha_esqueci_senha").value;
   localStorage.setItem('senha', senha_cadastro);
   alert("Senha mudada com sucesso!");
   window.location.href = "../index.html";
}

function pagar(event) {
   event.preventDefault();
   if (FORMULARIO_PAGAR.checkValidity()) {
      alert('Pagamento realizado com sucesso');
      window.location.href = "obrigado.html";
   }
   else {
      alert("Coloque os dados corretamente")
   }
}


let email = localStorage.getItem('email');
let senha_cadastro = localStorage.getItem('senha');
let nome_completo = localStorage.getItem('nome')

const BOTAO_LOGAR = document.getElementById("botao_login");
const BOTAO_CADASTRAR = document.getElementById("cadastrar");
const BOTAO_VOLTAR = document.getElementsByClassName("voltar");
const FORMULARIO_CADASTRO = document.getElementById("formulario_cadastro");
const BOTAO_ESQUECEU_SENHA1 = document.getElementById("esquecer_senha");
const BOTAO_ESQUECEU_SENHA2 = document.getElementById("esquecer_senha2");
const FORMULARIO_ESQUECER1 = document.getElementById("email_esqueci_senha");
const FORMULARIO_ESQUECER2 = document.getElementById("senha_esqueci_senha");
const BOTAO_PAGAR = document.getElementById("pagar")
const FORMULARIO_PAGAR = document.getElementById("formulario_pagar")



for (let i = 0; i < BOTAO_VOLTAR.length; i++) {

   BOTAO_VOLTAR[i].addEventListener("click", voltar);
}

const pathname = window.location.pathname;
console.log(pathname)

switch (pathname) {
   case '/FrontEnd/ARC_MarketingPlace/index.html':
      BOTAO_LOGAR.addEventListener("click", checar_dados);
   case '/FrontEnd/ARC_MarketingPlace/pages/criar_conta.html':
      BOTAO_CADASTRAR.addEventListener("click", cadastrar);
   case '/FrontEnd/ARC_MarketingPlace/pages/perfil.html':
      document.getElementById('bemvindo').innerHTML = "Bem Vindo, " + (nome_completo);
   case '/FrontEnd/ARC_MarketingPlace/pages/mudar_senha.html':
      BOTAO_ESQUECEU_SENHA1.addEventListener("click", mudar_form);
      BOTAO_ESQUECEU_SENHA2.addEventListener("click", resetar_senha);
   case '/FrontEnd/ARC_MarketingPlace/pages/pagamento.html':
      BOTAO_PAGAR.addEventListener("click", pagar);


}





