package br.com.cbm.conquistadores.reino.app.commands;

import br.com.cbm.conquistadores.reino.domain.entities.Edificacoes;
import br.com.cbm.conquistadores.reino.domain.entities.Jogador;
import br.com.cbm.conquistadores.reino.domain.entities.Recursos;
import br.com.cbm.conquistadores.reino.domain.usecases.ConstruirEdificacoesUseCase;

public class ConstruirEdificacacoesCommand implements AcaoCommand {

	private final Jogador jogador;
    
    public ConstruirEdificacacoesCommand(Jogador jogador) {
		this.jogador = jogador;
	}
    
    @Override
	public void execute() {
        Edificacoes edificacoes = jogador.getEdificacoes();
        Recursos recursos = jogador.getRecursos();
		ConstruirEdificacoesUseCase useCase = new ConstruirEdificacoesUseCase(edificacoes, recursos);
        useCase.construirEdificacao(10, 10);
    }
}