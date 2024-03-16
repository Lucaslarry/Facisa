package entities;

import java.sql.Connection;

public class Criticas extends Manifestacoes {

	public Criticas(Pessoa nome, String tipo, String comentario, Connection con) {
		super(nome, tipo, comentario, con);

	}

}
