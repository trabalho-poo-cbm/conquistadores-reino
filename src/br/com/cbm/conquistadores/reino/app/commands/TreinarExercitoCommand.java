package br.com.cbm.conquistadores.reino.app.commands;

import br.com.cbm.conquistadores.reino.domain.entities.Exercito;
import br.com.cbm.conquistadores.reino.domain.entities.Jogador;
import br.com.cbm.conquistadores.reino.domain.usecases.TreinarExercitoUseCase;

public class TreinarExercitoCommand implements AcaoCommand {

    private final Jogador jogador;
    
    public TreinarExercitoCommand(Jogador jogador) {
		this.jogador = jogador;
	}
    
    @Override
	public void execute() {
        Exercito exercito = jogador.getExercito();
		TreinarExercitoUseCase useCase = new TreinarExercitoUseCase(exercito);
        useCase.treinarExercito();
    }
}