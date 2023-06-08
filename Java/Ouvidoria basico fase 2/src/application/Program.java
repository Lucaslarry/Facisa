package application;

import java.util.Scanner;

import entities.*;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String comentario;
		int opcaoPrincipal = 0;
		int tipoComentario = 0;
		int opcaoVer = 0;
		int  opcaoApagar =0;
		int idApagar;
		Pessoa nome;
		Elogios elogios = null;
		Criticas criticas = null;
		Sugestoes sugestoes = null;
		System.out.print("Para iniciar a ouvidoria digite seu nome: ");
		nome = new Pessoa(sc.nextLine());

		while (opcaoPrincipal != 4) {
			System.out.println("===================================================");
			System.out.println("Nossas Opções:");
			System.out.println(" 1. Fazer Comentário\n 2. Ver Comentário\n 3. Apagar Comentário\n 4. Sair");
			System.out.print("O que deseja fazer? ");
			opcaoPrincipal = sc.nextInt();
			sc.nextLine();
			switch (opcaoPrincipal) {

			case 1: {
				System.out.println("===================================================");
				System.out.println("Nossas Opções");
				System.out.println(" 1. Elogios\n 2. Criticas\n 3. Sugestões\n 4. Voltar");
				System.out.print("Que tipo de coméntario deseja fazer? ");
				tipoComentario = sc.nextInt();
				sc.nextLine();
				if (tipoComentario == 4) {
					System.out.println("Voltando...");
					break;
				}
				if (tipoComentario != 1 && tipoComentario != 2 && tipoComentario != 3) {
					System.out.println("Opção invalida");
					break;
				}
				System.out.println("===================================================");
				System.out.print("Digite seu comentário: ");
				comentario = sc.nextLine();
				switch (tipoComentario) {
				case 1: {
					if (elogios == null) {
						elogios = new Elogios(nome, "Elogios", comentario);
					} else {
						elogios.fazerComentario(comentario);
					}

					break;
				}
				case 2: {
					if (criticas == null) {
						criticas = new Criticas(nome, "Criticas", comentario);
					} else {
						criticas.fazerComentario(comentario);
					}

					break;
				}

				case 3: {
					if (sugestoes == null) {
						sugestoes = new Sugestoes(nome, "Sugestões", comentario);
					} else {
						sugestoes.fazerComentario(comentario);
					}

					break;
				}
				default:{
					System.out.println("Opção invalida!");
					break;
				}
				}
				break;
			}
			case 2: {
				System.out.println("===================================================");
				System.out.println("Nossas Opções:");
				System.out.println(" 1. Ver Elogios\n 2. Ver Criticas\n 3. Ver Sugestões\n 4. Ver tudo\n 5. Voltar");
				System.out.print("O que deseja fazer? ");
				opcaoVer = sc.nextInt();
				sc.nextLine();
				switch (opcaoVer) {
				case 1: {
					elogios.verComentarios();
					break;
				}
				case 2: {
					criticas.verComentarios();
					break;
				}
				case 3: {
					sugestoes.verComentarios();
					break;
				}
				case 4: {
					elogios.verComentarios();
					criticas.verComentarios();
					sugestoes.verComentarios();
					break;
				}
				case 5: {
					System.out.println("Voltando...");
					break;
				}
				default:{
					System.out.println("Opção Invalida!");
				}
				}

			}
				break;
			case 3:{
			    System.out.println("===================================================");
			    System.out.println("Nossas Opções:");
			    System.out.println(" 1. Apagar Elogios\n 2. Apagar Criticas\n 3. Apagar Sugestões\n 4. Apagar tudo\n 5. Voltar");
			    System.out.print("O que deseja fazer? ");
			    opcaoApagar = sc.nextInt();
			    sc.nextLine();
			    switch (opcaoApagar) {
			    case 1:{
			    	elogios.verComentarios();
			    	System.out.print("Digite o id do elogio a ser excluido: ");
			    	idApagar = sc.nextInt();
			    	sc.nextLine();
			    	elogios.apagarComentarios(idApagar);
			    	
			    }
			    break;
			    case 2:{
			    	criticas.verComentarios();
			    	System.out.print("Digite o id do critica a ser excluida: ");
			    	idApagar = sc.nextInt();
			    	sc.nextLine();
			    	criticas.apagarComentarios(idApagar);
			    }
			    break;
			    case 3:{
			    	sugestoes.verComentarios();
			    	System.out.print("Digite o id da sugestão a ser excluida: ");
			    	idApagar = sc.nextInt();
			    	sc.nextLine();
			    	sugestoes.apagarComentarios(idApagar);
			    }
			    break;
			    case 4:{
			    	elogios.apagarTudo();
			    	criticas.apagarTudo();
			    	sugestoes.apagarTudo();
			    }
			    break;
			    case 5:{
			    	System.out.println("Voltando...");
			    
			    }
			    break;
			    default:{
			    	System.out.println("Opção invalida!");
			    }
			    break;
			    }
			    break;
			}
			case 4:{
				System.out.println("Obrigado pelo feedback!");
				
			}
			break;
			default:{
				System.out.println("Opção invalida!");
			}
			break;
			}

		}
		sc.close();
	}
}
