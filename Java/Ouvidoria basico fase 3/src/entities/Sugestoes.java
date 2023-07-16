package entities;

import java.sql.Connection;

public class Sugestoes extends Manifestacoes {

	public Sugestoes(Pessoa nome, String tipo, String comentario, Connection con) {
		super(nome, tipo, comentario, con);

	}

}
