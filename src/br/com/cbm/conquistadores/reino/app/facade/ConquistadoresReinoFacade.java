package br.com.cbm.conquistadores.reino.app.facade;

import br.com.cbm.conquistadores.reino.app.commands.AcaoCommand;
import br.com.cbm.conquistadores.reino.app.commands.ConquistarReinoCommand;
import br.com.cbm.conquistadores.reino.app.commands.ConstruirEdificacacoesCommand;
import br.com.cbm.conquistadores.reino.app.commands.ExibirInformacoesCommand;
import br.com.cbm.conquistadores.reino.app.commands.SairCommand;
import br.com.cbm.conquistadores.reino.app.commands.TreinarExercitoCommand;
import br.com.cbm.conquistadores.reino.app.commands.processor.AcaoProcessor;
import br.com.cbm.conquistadores.reino.app.ui.InterfaceDeUsuarioFacade;
import br.com.cbm.conquistadores.reino.domain.entities.ConquistadoresReinoState;

public class ConquistadoresReinoFacade {

	private final ConquistadoresReinoState estadoDoJogo;
	private final InterfaceDeUsuarioFacade interfaceDeUsuario;
	private final AcaoProcessor acaoProcessor;
	
	public ConquistadoresReinoFacade() {
		this.estadoDoJogo = new ConquistadoresReinoState();
		this.interfaceDeUsuario = new InterfaceDeUsuarioFacade();
		this.acaoProcessor = new AcaoProcessor();
	}
	
	public void jogar() {
		this.iniciarJogo();
		while (estadoDoJogo.estaEmAndamento()) {
			interfaceDeUsuario.imprimirAcoes();
			int acao = interfaceDeUsuario.lerAcao();
			acaoProcessor.processa(defineComando(acao));
		}
		// encerrar jogo
	}

	private AcaoCommand defineComando(int acao) {
		return switch(acao) {
			case 1 -> new ExibirInformacoesCommand();
			case 2 -> new TreinarExercitoCommand();
			case 3 -> new ConstruirEdificacacoesCommand();
			case 4 -> new ConquistarReinoCommand();
			case 5 -> new SairCommand(estadoDoJogo);
			default -> throw new IllegalArgumentException("Valor inesperado para acao (esperado de 1 a 5): " + acao);
		};
	}

	private void iniciarJogo() {
		this.estadoDoJogo.inciar();
		this.interfaceDeUsuario.imprimirTitulo();
	}
}