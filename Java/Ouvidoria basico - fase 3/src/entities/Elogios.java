package entities;

import java.sql.Connection;

public class Elogios extends Manifestacoes {

	public Elogios(Pessoa nome, String tipo, String comentario, Connection con) {
		super(nome, tipo, comentario, con);

	}

}
