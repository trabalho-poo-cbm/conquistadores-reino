package br.com.cbm.conquistadores.reino.app;

import br.com.cbm.conquistadores.reino.app.commands.AcaoCommand;
import br.com.cbm.conquistadores.reino.app.commands.AcaoProcessor;
import br.com.cbm.conquistadores.reino.app.commands.CommandFactory;
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
		this.estadoDoJogo = ConquistadoresReinoState.getInstance();
		this.interfaceDeUsuario = new InterfaceDeUsuarioFacade();
		this.acaoProcessor = new AcaoProcessor();
		this.notificadorEncerramentoTimers = new NotificadorEncerramentoTimers(jogador, mapa);
	}
	
	public void jogar() {
		this.iniciarJogo();
		while (estadoDoJogo.estaEmAndamento()) {
			interfaceDeUsuario.imprimirAcoes();
			int acao = interfaceDeUsuario.lerAcao();
			acaoProcessor.processa(CommandFactory.criaAcao(acao));
		}
		this.encerrarJogo();
	}

	private void iniciarJogo() {
		this.estadoDoJogo.inciar();
		this.interfaceDeUsuario.imprimirTitulo();
	}
	
	private void encerrarJogo() {
		notificadorEncerramentoTimers.encerrarTimers();
		// TODO Imprimir mensagem de vitória, derrota ou desistência
	}
}