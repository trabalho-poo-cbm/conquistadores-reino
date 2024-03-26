package br.com.cbm.conquistadores.reino.app.facade;

import br.com.cbm.conquistadores.reino.domain.entities.ConquistadoresReinoState;

public class ConquistadoresReinoFacade {

	private final ConquistadoresReinoState estadoDoJogo;
	
	public ConquistadoresReinoFacade() {
		this.estadoDoJogo = new ConquistadoresReinoState();
	}
	
	public void jogar() {
		this.iniciarJogo();
		while (estadoDoJogo.estaEmAndamento()) {
			// apresentar menu
			// ler acao
			//processar acao
		}
		// encerrar jogo
	}

	private void iniciarJogo() {
		this.estadoDoJogo.inciar();
		// Imprimir logo
	}
}