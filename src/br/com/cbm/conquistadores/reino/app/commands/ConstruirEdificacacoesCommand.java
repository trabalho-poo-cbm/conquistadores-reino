package br.com.cbm.conquistadores.reino.app.commands;

import br.com.cbm.conquistadores.reino.app.ui.InterfaceDeUsuarioFacade;
import br.com.cbm.conquistadores.reino.domain.entities.Edificacoes;
import br.com.cbm.conquistadores.reino.domain.entities.Jogador;
import br.com.cbm.conquistadores.reino.domain.entities.Recursos;
import br.com.cbm.conquistadores.reino.domain.usecases.ConstruirEdificacoesUseCase;

public class ConstruirEdificacacoesCommand implements AcaoCommand {

	private final Jogador jogador;
	private final InterfaceDeUsuarioFacade interfaceDeUsuario;
    
    public ConstruirEdificacacoesCommand(Jogador jogador, InterfaceDeUsuarioFacade interfaceDeUsuario) {
		this.jogador = jogador;
		this.interfaceDeUsuario = interfaceDeUsuario;
	}
    
    @Override
	public void execute() {
        Edificacoes edificacoes = jogador.getEdificacoes();
        Recursos recursos = jogador.getRecursos();
		ConstruirEdificacoesUseCase useCase = new ConstruirEdificacoesUseCase(edificacoes, recursos, interfaceDeUsuario);
        useCase.construirEdificacao();
    }
}