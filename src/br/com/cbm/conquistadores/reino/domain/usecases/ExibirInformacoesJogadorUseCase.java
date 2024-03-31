package br.com.cbm.conquistadores.reino.domain.usecases;

import br.com.cbm.conquistadores.reino.app.ui.InterfaceDeUsuarioFacade;
import br.com.cbm.conquistadores.reino.domain.entities.Jogador;

public class ExibirInformacoesJogadorUseCase {

	private final Jogador jogador;
	private final InterfaceDeUsuarioFacade interfaceDeUsuario;
	
	public ExibirInformacoesJogadorUseCase(Jogador jogador, InterfaceDeUsuarioFacade interfaceDeUsuario) {
		this.jogador = jogador;
		this.interfaceDeUsuario = interfaceDeUsuario;
	}

	public void exibirInformacoesJogador() {
		interfaceDeUsuario.exibibirInformacaoJogador(jogador);
	}
}