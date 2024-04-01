package br.com.cbm.conquistadores.reino.app.commands;

import br.com.cbm.conquistadores.reino.domain.entities.Exercito;
import br.com.cbm.conquistadores.reino.domain.entities.Jogador;
import br.com.cbm.conquistadores.reino.domain.entities.Recursos;
import br.com.cbm.conquistadores.reino.domain.usecases.TreinarExercitoUseCase;

public class TreinarExercitoCommand implements AcaoCommand {

    private final Jogador jogador;
    
    public TreinarExercitoCommand(Jogador jogador) {
		this.jogador = jogador;
	}
    
    @Override
	public void execute() {
        Exercito exercito = jogador.getExercito();
        Recursos recursos = jogador.getRecursos();
		TreinarExercitoUseCase useCase = new TreinarExercitoUseCase(exercito, recursos);
        useCase.treinarExercito(10, 10);
    }
}