package entities;

import java.util.Arrays;

public class Manifestacoes {
	private int NUMERO_DE_COMENTARIOS = 5;
	private String[] comentarios = new String[NUMERO_DE_COMENTARIOS];
	private int quantidadeDeComentarios = 0;
	private String tipo;
	private Pessoa nome;
	private String comentario;

	public Manifestacoes(Pessoa nome, String tipo, String comentario) {
		this.nome = nome;
		this.tipo = tipo;
		this.comentario = comentario;
		fazerComentario(this.comentario);
	}

	public void fazerComentario(String comentario) {
		if (quantidadeDeComentarios == NUMERO_DE_COMENTARIOS) {
			System.out.println("Numero de " + tipo + " maximos atingidos!!");
		} else {
			for (int i = 0; i < NUMERO_DE_COMENTARIOS; i++) {
				if (this.comentarios[i] == null) {
					this.comentarios[i] = comentario;
					quantidadeDeComentarios += 1;
					System.out.println(this.tipo + " adicionado com sucesso!!");
					break;

				}
			}
		}
	}

	public void verComentarios() {
		System.out.println("===================================================");
		System.out.println(this.tipo + " de " + nome);
		for (int i = 0; i < NUMERO_DE_COMENTARIOS; i++) {
			if (this.comentarios[i] != null) {
				System.out.println((i + 1) + ". " + this.comentarios[i]);
			}
		}

	}

	public void apagarComentarios(int id) {
		if (id <= 0 || id > quantidadeDeComentarios) {
			System.out.println("ID inválido!");
		} else {
			comentarios[id - 1] = null;
			System.out.println(tipo + " apagada com sucesso!");
		}
		
		quantidadeDeComentarios -= 1;
	}
	public void apagarTudo() {
		Arrays.fill(comentarios, null);
		System.out.println("Todos "+tipo +"apagado com sucesso");
	}
}
