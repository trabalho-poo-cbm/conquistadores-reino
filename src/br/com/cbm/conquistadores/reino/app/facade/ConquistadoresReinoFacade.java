package br.com.cbm.conquistadores.reino.app.facade;

import br.com.cbm.conquistadores.reino.app.ui.InterfaceDeUsuarioFacade;
import br.com.cbm.conquistadores.reino.domain.entities.ConquistadoresReinoState;

public class ConquistadoresReinoFacade {

	private final ConquistadoresReinoState estadoDoJogo;
	private final InterfaceDeUsuarioFacade interfaceDeUsuario;
	
	public ConquistadoresReinoFacade() {
		this.estadoDoJogo = new ConquistadoresReinoState();
		this.interfaceDeUsuario = new InterfaceDeUsuarioFacade();
	}
	
	public void jogar() {
		this.iniciarJogo();
//		while (estadoDoJogo.estaEmAndamento()) {
			interfaceDeUsuario.imprimirAcoes();
			// ler acao
			//processar acao
//		}
		// encerrar jogo
	}

	private void iniciarJogo() {
		this.estadoDoJogo.inciar();
		this.interfaceDeUsuario.imprimirTitulo();
	}
}