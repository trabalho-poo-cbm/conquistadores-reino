package br.com.cbm.conquistadores.reino.app.commands;

import br.com.cbm.conquistadores.reino.app.ui.InterfaceDeUsuarioFacade;
import br.com.cbm.conquistadores.reino.domain.entities.Jogador;
import br.com.cbm.conquistadores.reino.domain.usecases.ExibirInformacoesJogadorUseCase;

public class ExibirInformacoesJogadorCommand implements AcaoCommand {
	
	private final Jogador jogador;
	private final InterfaceDeUsuarioFacade interfaceDeUsuario;
	
	public ExibirInformacoesJogadorCommand(Jogador jogador, InterfaceDeUsuarioFacade interfaceDeUsuario) {
		this.jogador = jogador;
		this.interfaceDeUsuario = interfaceDeUsuario;
	}
	
	@Override
	public void execute() {
		ExibirInformacoesJogadorUseCase useCase = new ExibirInformacoesJogadorUseCase(jogador, interfaceDeUsuario);
		useCase.exibirInformacoesJogador();
	}
}