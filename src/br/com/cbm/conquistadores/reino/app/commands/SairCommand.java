package br.com.cbm.conquistadores.reino.app.commands;

import br.com.cbm.conquistadores.reino.app.ConquistadoresReinoState;

public class SairCommand implements AcaoCommand {
	
	private ConquistadoresReinoState estadoDoJogo;

	public SairCommand(ConquistadoresReinoState estadoDoJogo) {
		this.estadoDoJogo = estadoDoJogo;
	}

	@Override
	public void execute() {
		estadoDoJogo.encerrar();
	}
}