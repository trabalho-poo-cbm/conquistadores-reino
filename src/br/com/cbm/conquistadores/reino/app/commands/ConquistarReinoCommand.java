package br.com.cbm.conquistadores.reino.app.commands;

import br.com.cbm.conquistadores.reino.domain.entities.*;
import br.com.cbm.conquistadores.reino.domain.usecases.ConquistarReinoUseCase;
import br.com.cbm.conquistadores.reino.app.ui.InterfaceDeUsuarioFacade;

public class ConquistarReinoCommand implements AcaoCommand {
	
	private final Jogador jogador;
	private final Mapa mapa;
	private final InterfaceDeUsuarioFacade interfaceDeUsuario;
	
	public ConquistarReinoCommand(Jogador jogador, Mapa mapa, InterfaceDeUsuarioFacade interfaceDeUsuario) {
		this.jogador = jogador;
		this.mapa = mapa;
		this.interfaceDeUsuario = interfaceDeUsuario;
	}
	
	
	@Override
	public void execute() {
		
		ConquistarReinoUseCase useCase = new ConquistarReinoUseCase(jogador, mapa, interfaceDeUsuario);
		useCase.conquistarReino();
		// Implementação deve ser feita em uma classe de use case
		// Combate e feito calculando a diferenca de valores entre exercito do jogador e exercito e edificacoes do reino a ser conquistado
			// Em caso de vitoria, o reino e anexado ao Jogador, seus recursos são somados, as edificações e exército são somados apenas uma porcentagem
			// Em caso de derrota, o jogo e encerrado
			// Ao conquitar todos os reinos, o jogo é finalizado com vitória
				// É necessário fazer uma checagem se todos os reinos no mapa para verificar se todos os reinos estão conquistados, se sim encerrar jogo
		System.out.println("Conquistar Reino");
	}
}