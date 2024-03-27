package br.com.cbm.conquistadores.reino.app.commands;

import br.com.cbm.conquistadores.reino.domain.entities.ConquistadoresReinoState;

public class SairCommand implements AcaoCommand {
	
	private final ConquistadoresReinoState estadoDoJogo;
	
	public SairCommand(ConquistadoresReinoState estadoDoJogo) {
		this.estadoDoJogo = estadoDoJogo;
	}

	@Override
	public void execute() {
		this.estadoDoJogo.encerrar();
	}
}