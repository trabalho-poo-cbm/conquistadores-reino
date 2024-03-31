package br.com.cbm.conquistadores.reino.app;

import br.com.cbm.conquistadores.reino.app.commands.AcaoCommand;
import br.com.cbm.conquistadores.reino.app.commands.AcaoProcessor;
import br.com.cbm.conquistadores.reino.app.commands.ConquistarReinoCommand;
import br.com.cbm.conquistadores.reino.app.commands.ConstruirEdificacacoesCommand;
import br.com.cbm.conquistadores.reino.app.commands.ExibirInformacoesJogadorCommand;
import br.com.cbm.conquistadores.reino.app.commands.ExibirMapaCommand;
import br.com.cbm.conquistadores.reino.app.commands.SairCommand;
import br.com.cbm.conquistadores.reino.app.commands.TreinarExercitoCommand;
import br.com.cbm.conquistadores.reino.app.observer.NotificadorEncerramentoTimers;
import br.com.cbm.conquistadores.reino.app.ui.InterfaceDeUsuarioFacade;
import br.com.cbm.conquistadores.reino.domain.entities.Jogador;
import br.com.cbm.conquistadores.reino.domain.entities.Mapa;

public class ConquistadoresReinoFacade {

	private final Jogador jogador;
	private final Mapa mapa;
	private final ConquistadoresReinoState estadoDoJogo;
	private final InterfaceDeUsuarioFacade interfaceDeUsuario;
	private final AcaoProcessor acaoProcessor;
	private final NotificadorEncerramentoTimers notificadorEncerramentoTimers;
	
	public ConquistadoresReinoFacade() {
		this.jogador = Jogador.getInstance();
		this.mapa = Mapa.getInstance();
		this.estadoDoJogo = new ConquistadoresReinoState();
		this.interfaceDeUsuario = new InterfaceDeUsuarioFacade();
		this.acaoProcessor = new AcaoProcessor();
		this.notificadorEncerramentoTimers = new NotificadorEncerramentoTimers(jogador, mapa);
	}
	
	public void jogar() {
		this.iniciarJogo();
		while (estadoDoJogo.estaEmAndamento()) {
			interfaceDeUsuario.exibirAcoes();
			int acao = interfaceDeUsuario.lerAcao();
			acaoProcessor.processa(defineAcao(acao));
		}
		this.encerrarJogo();
	}

	private AcaoCommand defineAcao(int acao) {
		return switch(acao) {
			case 1 -> new ExibirInformacoesJogadorCommand(jogador, interfaceDeUsuario);
			case 2 -> new ExibirMapaCommand(mapa, interfaceDeUsuario);
			case 3 -> new TreinarExercitoCommand(jogador);
			case 4 -> new ConstruirEdificacacoesCommand();
			case 5 -> new ConquistarReinoCommand();
			case 6 -> new SairCommand(estadoDoJogo);
			default -> throw new IllegalArgumentException("Valor inesperado para acao (esperado de 1 a 5): " + acao);
		};
	}
	
	private void iniciarJogo() {
		this.estadoDoJogo.inciar();
		this.interfaceDeUsuario.exibirTitulo();
	}
	
	private void encerrarJogo() {
		notificadorEncerramentoTimers.encerrarTimers();
		// TODO Imprimir mensagem de vitória, derrota ou desistência
	}
}