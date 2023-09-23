package entities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Manifestacoes {
	private String tipo;
	private Pessoa nome;
	private String comentario;
	private Connection con;

	public Manifestacoes(Pessoa nome, String tipo, String comentario, Connection con) {
		this.nome = nome;
		this.tipo = tipo;
		this.comentario = comentario;
		this.con = con;
		fazerComentario(this.comentario);
	}

	public void fazerComentario(String comentario) {
		try {
			Statement stmt = this.con.createStatement();
			String sql = "INSERT INTO comentario (comentario, tipo, nome) VALUES ('" + comentario + "', '" + this.tipo
					+ "', '" + this.nome + "')";
			stmt.executeUpdate(sql);
			System.out.println("Comentário feito com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void verComentarios() {
		Statement stmt;
		System.out.println("Seus: " + this.tipo);
		try {
			stmt = this.con.createStatement();
			ResultSet resultado = stmt.executeQuery(
					"SELECT * FROM comentario WHERE tipo = '" + this.tipo + "' AND nome = '" + this.nome + "'");
			while (resultado.next()) {
				System.out.println("===================================================");
				System.out.printf("ID : %d, Nome: %s, Comentário: %s ", resultado.getInt("id"),
						resultado.getString("nome"), resultado.getString("comentario"));
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void apagarComentarios(int id) {
		try {
			Statement stmt = this.con.createStatement();
			String sql = "DELETE FROM comentario WHERE id = " + id + " AND tipo = '" + this.tipo + "' AND nome = '"
					+ this.nome + "'";
			stmt.execute(sql);
			System.out.println("Comentário apagado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void apagarTudo() {
		try {
			Statement stmt = this.con.createStatement();
			String sql = "DELETE FROM comentario WHERE tipo = '" + this.tipo + "' AND nome = '" + this.nome + "'";
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Todos " + tipo + " apagado com sucesso");
	}

	public void atualizarComentario(int id, String novoComentario) {
		try {
			Statement stmt = this.con.createStatement();
			String sql = "UPDATE comentario SET comentario = '" + novoComentario + "' WHERE id = " + id
					+ " AND tipo = '" + this.tipo + "' AND nome = '" + this.nome + "'";
			stmt.executeUpdate(sql);
			System.out.println("Comentário atualizado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Pessoa getNome() {
		return nome;
	}

	public void setNome(Pessoa nome) {
		this.nome = nome;
	}

}
