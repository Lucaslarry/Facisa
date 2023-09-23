package application;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nome;
		String comentario;
		String[] elogios = new String[5];
		int quantidadeElogios = 0;
		String[] criticas = new String[5];
		int quantidadeCriticas = 0;
		String[] sugestoes = new String[5];
		int quantidadeSugestoes = 0;
		int opcaoPrincipal = 0;
		int tipoComentario;
		int opcaoVer = 0;
		int opcaoApagar = 0;
		int idApagar = 0;

		System.out.print("Para iniciar a ouvidoria por favor digite seu nome: ");
		nome = sc.nextLine();
		System.out.printf("Seja bem vindo, %s", nome);
		System.out.println();

		while (opcaoPrincipal != 4) {
			System.out.println("===================================================");
			System.out.println("Nossas Opções:");
			System.out.println(" 1. Fazer Comentário\n 2. Ver Comentário\n 3. Apagar Comentário\n 4. Sair");
			System.out.print("O que deseja fazer? ");
			opcaoPrincipal = sc.nextInt();
			sc.nextLine();
			System.out.println("===================================================");

			switch (opcaoPrincipal) {

			case 1: {
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
				}
				System.out.println("===================================================");
				System.out.print("Digite seu comentário: ");
				comentario = sc.nextLine();
				switch (tipoComentario) {
				case 1: {
					if (quantidadeElogios == 5) {
						System.out.println("Limite de elogios atingido (5)");
						break;
					}
					for (int i = 0; i < elogios.length; i++) {
						if (elogios[i] == null) {
							elogios[i] = comentario;
							quantidadeElogios += 1;
							break;
						}
					}
					System.out.println("Elogio adicionado com sucesso!");
					break;
				}

				case 2: {
					if (quantidadeCriticas == 5) {
						System.out.println("Limite de criticas atingido (5)");
						break;
					}
					for (int i = 0; i < criticas.length; i++) {
						if (criticas[i] == null) {
							criticas[i] = comentario;
							quantidadeCriticas += 1;
							System.out.println("Critica adicionada com sucesso!");
							break;
						}
					}
					break;
				}

				case 3: {
					if (quantidadeSugestoes == 5) {
						System.out.println("Limite de sugestões atingido (5)");
						break;
					}
					for (int i = 0; i < sugestoes.length; i++) {
						if (sugestoes[i] == null) {
							sugestoes[i] = comentario;
							quantidadeSugestoes += 1;
							System.out.println("Sugestão adicionada com sucesso!");
							break;
						}
					}
					break;
				}
				default:
					System.out.println("Opção invalida");
					break;
				}
				break;

			}
			

			case 2:
				System.out.println("===================================================");
				System.out.println("Nossas Opções:");
				System.out.println(" 1. Ver Elogios\n 2. Ver Criticas\n 3. Ver Sugestões\n 4. Ver tudo\n 5. Voltar");
				System.out.print("O que deseja fazer? ");
				opcaoVer = sc.nextInt();
				sc.nextLine();

				switch (opcaoVer) {
				case 1:
					System.out.println("===================================================");
					System.out.println("Seus Elogios: ");
					for (int i = 0; i < elogios.length; i++) {
						if (elogios[i] == null) {
							break;
						}
						System.out.printf("%d. %s", i + 1, elogios[i]);
						System.out.println("");
					}
					break;
				case 2:
					System.out.println("===================================================");
					System.out.println("Suas Criticas: ");
					for (int i = 0; i < criticas.length; i++) {
						if (criticas[i] == null) {
							break;
						}
						System.out.printf("%d. %s", i + 1, criticas[i]);
						System.out.println("");
					}
					break;
				case 3:
					System.out.println("===================================================");
					System.out.println("Suas Sugestões: ");
					for (int i = 0; i < sugestoes.length; i++) {
						if (sugestoes[i] == null) {
							break;
						}
						System.out.printf("%d. %s", i + 1, sugestoes[i]);
						System.out.println("");
					}
					break;
				case 4:
					System.out.println("===================================================");
					System.out.println("Seus Elogios: ");
					for (int i = 0; i < elogios.length; i++) {
						if (elogios[i] == null) {
							break;
						}
						System.out.printf("%d. %s", i + 1, elogios[i]);
						System.out.println("");
					}
					System.out.println("===================================================");
					System.out.println("Suas Criticas: ");
					for (int i = 0; i < criticas.length; i++) {
						if (criticas[i] == null) {
							break;
						}
						System.out.printf("%d. %s", i + 1, criticas[i]);
						System.out.println("");
					}
					System.out.println("===================================================");
					System.out.println("Suas Sugestões: ");
					for (int i = 0; i < sugestoes.length; i++) {
						if (sugestoes[i] == null) {
							break;
						}
						System.out.printf("%d. %s", i + 1, sugestoes[i]);
						System.out.println("");
					}
					break;
				case 5:
					System.out.println("Voltando...");
					break;
				default:
					System.out.println("Opção invalida");
					break;
				}
				break;
			case 3:
			    System.out.println("===================================================");
			    System.out.println("Nossas Opções:");
			    System.out.println(" 1. Apagar Elogios\n 2. Apagar Criticas\n 3. Apagar Sugestões\n 4. Apagar tudo\n 5. Voltar");
			    System.out.print("O que deseja fazer? ");
			    opcaoApagar = sc.nextInt();
			    sc.nextLine();

			    switch (opcaoApagar) {
			        case 1:
			            System.out.println("===================================================");
			            System.out.println("Seus Elogios: ");
			            for (int i = 0; i < quantidadeElogios; i++) {
			                System.out.printf("%d. %s\n", i + 1, elogios[i]);
			            }
			            System.out.println("Digite o id do elogio que deseja apagar: ");
			            idApagar = sc.nextInt();
			            sc.nextLine();
			            if (idApagar <= 0 || idApagar > quantidadeElogios) {
			                System.out.println("ID inválido!");
			            } else {
			                for (int i = idApagar - 1; i < quantidadeElogios - 1; i++) {
			                    elogios[i] = elogios[i + 1];
			                }
			                elogios[quantidadeElogios - 1] = null;
			                System.out.println("Elogio apagado com sucesso!");
			                quantidadeElogios -= 1;
			            }
			            break;

			        case 2:
			            System.out.println("===================================================");
			            System.out.println("Suas Criticas: ");
			            for (int i = 0; i < quantidadeCriticas; i++) {
			                System.out.printf("%d. %s\n", i + 1, criticas[i]);
			            }
			            System.out.println("Digite o id da critica que deseja apagar: ");
			            idApagar = sc.nextInt();
			            sc.nextLine();
			            if (idApagar <= 0 || idApagar > quantidadeCriticas) {
			                System.out.println("ID inválido!");
			            } else {
			                for (int i = idApagar - 1; i < quantidadeCriticas - 1; i++) {
			                	criticas[i] = criticas[i + 1];
			                }
			                criticas[quantidadeCriticas - 1] = null;
			                System.out.println("Critica apagada com sucesso!");
			                quantidadeCriticas -= 1;
			            }
			            break;
			        case 3:
			            System.out.println("===================================================");
			            System.out.println("Suas Sugestões: ");
			            for (int i = 0; i < quantidadeSugestoes; i++) {
			                System.out.printf("%d. %s\n", i + 1, sugestoes[i]);
			            }
			            System.out.println("Digite o id da sugestao que deseja apagar: ");
			            idApagar = sc.nextInt();
			            sc.nextLine();
			            if (idApagar <= 0 || idApagar > quantidadeSugestoes) {
			                System.out.println("ID inválido!");
			            } else {
			                for (int i = idApagar - 1; i < quantidadeSugestoes - 1; i++) {
			                	sugestoes[i] = sugestoes[i + 1];
			                }
			                sugestoes[quantidadeSugestoes - 1] = null;
			                System.out.println("Sugestão apagada com sucesso!");
			                quantidadeSugestoes -= 1;
			            }
			            break;

			        case 4:
			            Arrays.fill(elogios, null);
			            Arrays.fill(criticas, null);
			            Arrays.fill(sugestoes, null);
			            quantidadeElogios = 0;
			            quantidadeCriticas = 0;
			            quantidadeSugestoes = 0;
			            System.out.println("Todos os comentários apagados com sucesso!");
			            break;
			        default:
						System.out.println("Opção invalida");
						break;
			    }
			    break;
			case 4:
				System.out.println("Obrigado pelo FeedBack!");
	
			}
	
		}
		sc.close();
	}
}
