package br.com.cbm.conquistadores.reino.app.commands;

import br.com.cbm.conquistadores.reino.domain.entities.*;
import br.com.cbm.conquistadores.reino.domain.usecases.ConquistarReinoUseCase;
import br.com.cbm.conquistadores.reino.app.ConquistadoresReinoState;
import br.com.cbm.conquistadores.reino.app.ui.InterfaceDeUsuarioFacade;

public class ConquistarReinoCommand implements AcaoCommand {
	
	private final Jogador jogador;
	private final Mapa mapa;
	private final InterfaceDeUsuarioFacade interfaceDeUsuario;
	private final ConquistadoresReinoState estadoDoJogo;
	
	public ConquistarReinoCommand(Jogador jogador, Mapa mapa, InterfaceDeUsuarioFacade interfaceDeUsuario,
			ConquistadoresReinoState estadoDoJogo) {
		this.jogador = jogador;
		this.mapa = mapa;
		this.interfaceDeUsuario = interfaceDeUsuario;
		this.estadoDoJogo = estadoDoJogo;
	}
	
	
	@Override
	public void execute() {
		ConquistarReinoUseCase useCase = new ConquistarReinoUseCase(jogador, mapa, interfaceDeUsuario);
		useCase.conquistarReino();
		if (mapa.isConquistado()) {
			estadoDoJogo.vencer();
		}
	}
}