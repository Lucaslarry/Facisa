package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import entities.Criticas;
import entities.Elogios;
import entities.Pessoa;
import entities.Sugestoes;

public class Program {

	public static void main(String[] args) {
		Connection con = database.DataBase.getConnection();
		int opcaoApagarTudo;
		Scanner sc = new Scanner(System.in);
		String comentario;
		int opcaoAtualizar;
		int opcaoPrincipal = 0;
		int tipoComentario;
		int opcaoVer;
		int opcaoApagar;
		int idApagar;
		int idAtualizar;
		Pessoa nome;
		Elogios elogios = null;
		Criticas criticas = null;
		Sugestoes sugestoes = null;
		System.out.print("Para iniciar a ouvidoria digite seu nome: ");
		nome = new Pessoa(sc.nextLine());

		while (opcaoPrincipal != 5) {
			System.out.println("===================================================");
			System.out.println("Nossas Opções:");
			System.out.println(
					" 1. Fazer Comentário\n 2. Ver Comentário\n 3. Apagar Comentário\n 4. Atualizar Comentário\n 5. Sair");
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
						elogios = new Elogios(nome, "Elogios", comentario, con);
					} else {
						elogios.fazerComentario(comentario);
					}

					break;
				}
				case 2: {
					if (criticas == null) {
						criticas = new Criticas(nome, "Criticas", comentario, con);
					} else {
						criticas.fazerComentario(comentario);
					}

					break;
				}

				case 3: {
					if (sugestoes == null) {
						sugestoes = new Sugestoes(nome, "Sugestões", comentario, con);
					} else {
						sugestoes.fazerComentario(comentario);
					}

					break;
				}
				default: {
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
				default: {
					System.out.println("Opção Invalida!");
				}
				}

			}
				break;
			case 3: {
				System.out.println("===================================================");
				System.out.println("Nossas Opções:");
				System.out.println(
						" 1. Apagar Elogios\n 2. Apagar Criticas\n 3. Apagar Sugestões\n 4. Apagar tudo\n 5. Voltar");
				System.out.print("O que deseja fazer? ");
				opcaoApagar = sc.nextInt();
				sc.nextLine();
				switch (opcaoApagar) {
				case 1: {
					elogios.verComentarios();
					System.out.print("Digite o id do elogio a ser excluido: ");
					idApagar = sc.nextInt();
					sc.nextLine();
					elogios.apagarComentarios(idApagar);

				}
					break;
				case 2: {
					criticas.verComentarios();
					System.out.print("Digite o id do critica a ser excluida: ");
					idApagar = sc.nextInt();
					sc.nextLine();
					criticas.apagarComentarios(idApagar);
				}
					break;
				case 3: {
					sugestoes.verComentarios();
					System.out.print("Digite o id da sugestão a ser excluida: ");
					idApagar = sc.nextInt();
					sc.nextLine();
					sugestoes.apagarComentarios(idApagar);
				}
					break;
				case 4: {
					System.out.println("===================================================");
					System.out.println(
							" 1. Apagar todos Elogios\n 2. Apagar todas Criticas\n 3. Apagar todas Sugestões\n 4. Apagar tudo\n 5. Voltar");
					System.out.print("O que deseja fazer? ");
					opcaoApagarTudo = sc.nextInt();
					sc.nextLine();
					switch (opcaoApagarTudo) {
					case 1: {
						elogios.apagarTudo();
					}
						break;
					case 2: {
						criticas.apagarTudo();
					}
						break;
					case 3: {
						sugestoes.apagarTudo();

					}
						break;
					case 4: {
						elogios.apagarTudo();
						criticas.apagarTudo();
						sugestoes.apagarTudo();
					}
						break;
					case 5: {
						System.out.println("Voltando...");
					}
						break;
					default: {
						System.out.println("Opção invalida!");
					}
					}

				}
					break;
				case 5: {
					System.out.println("Voltando...");

				}
					break;
				default: {
					System.out.println("Opção invalida!");
				}
					break;
				}
				break;
			}
			case 4: {
				System.out.println("===================================================");
				System.out.println("Nossas Opções:");
				System.out
						.println(" 1. Atualizar Elogios\n 2. Atualizar Criticas\n 3. Atualizar Sugestões\n 4. Voltar");
				System.out.print("O que deseja fazer? ");
				opcaoAtualizar = sc.nextInt();
				sc.nextLine();
				switch (opcaoAtualizar) {
				case 1: {
					elogios.verComentarios();
					System.out.print("Digite o id do elogio a ser atualizado: ");
					idAtualizar = sc.nextInt();
					sc.nextLine();
					System.out.print("Digite o novo comentário:");
					comentario = sc.nextLine();
					elogios.atualizarComentario(idAtualizar, comentario);

				}
					break;
				case 2: {

					criticas.verComentarios();
					System.out.print("Digite o id do critica a ser atualizada: ");
					idAtualizar = sc.nextInt();
					sc.nextLine();
					System.out.print("Digite o novo comentário:");
					comentario = sc.nextLine();
					criticas.atualizarComentario(idAtualizar, comentario);
				}
					break;
				case 3: {
					sugestoes.verComentarios();
					System.out.print("Digite o id da sugestão a ser atualizada: ");
					idAtualizar = sc.nextInt();
					sc.nextLine();
					System.out.print("Digite o novo comentário:");
					comentario = sc.nextLine();
					sugestoes.atualizarComentario(idAtualizar, comentario);
				}
					break;
				case 4: {
					System.out.println("Voltando...");
				}
					break;
				default: {
					System.out.println("Opção invalida!");
				}
					break;
				}
				break;
			}
			case 5: {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Obrigado pelo feedback!");

			}
				break;
			default: {
				System.out.println("Opção invalida!");
			}
				break;
			}

		}
		sc.close();
	}
}
