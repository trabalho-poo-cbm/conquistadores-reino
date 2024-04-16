package br.com.cbm.conquistadores.reino.domain.usecases;

import br.com.cbm.conquistadores.reino.app.ConquistadoresReinoState;
import br.com.cbm.conquistadores.reino.app.ui.InterfaceDeUsuarioFacade;
import br.com.cbm.conquistadores.reino.domain.entities.Jogador;
import br.com.cbm.conquistadores.reino.domain.entities.Mapa;
import br.com.cbm.conquistadores.reino.domain.entities.Reino;
public class ConquistarReinoUseCase {

	private final Jogador jogador;
	private final Mapa mapa;
	private final InterfaceDeUsuarioFacade interfaceDeUsuario;
	private ConquistadoresReinoState estadoDoJogo;
	
	public ConquistarReinoUseCase(Jogador jogador, Mapa mapa, InterfaceDeUsuarioFacade interfaceDeUsuario, ConquistadoresReinoState estadoDoJogo) {
		this.jogador = jogador;
		this.mapa = mapa;
		this.interfaceDeUsuario = interfaceDeUsuario;
		this.estadoDoJogo = estadoDoJogo;
	}
	
	public void conquistarReino() {
		interfaceDeUsuario.exibirInformacaoMapa(mapa);
		Reino reinoAlvo = mapa.obterReino(interfaceDeUsuario.lerReinoAlvo());
		
		if (reinoAlvo.isConquistado()) {
			interfaceDeUsuario.exibirTexto("O reino selecionado ja foi conquistado!");
			return;
		}
		
		if (jogador.getExercito().getTotalTropasTreinadas() < reinoAlvo.getDefesa()) {
			estadoDoJogo.perder();
			return;
		}
		
		reinoAlvo.serConquistado(jogador.getNome());
		jogador.adicionarReinoConquistado(reinoAlvo.getNomeReino());
		
		interfaceDeUsuario.exibirTexto("\nReino conquistado!");
	}
}
	
