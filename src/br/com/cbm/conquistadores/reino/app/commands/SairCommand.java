package br.com.cbm.conquistadores.reino.app.commands;

import br.com.cbm.conquistadores.reino.app.ConquistadoresReinoState;

public class SairCommand implements AcaoCommand {
	
	@Override
	public void execute() {
		ConquistadoresReinoState.getInstance().encerrar();
	}
}