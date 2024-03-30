package br.com.cbm.conquistadores.reino.app.commands;

import br.com.cbm.conquistadores.reino.domain.entities.Exercito;
import br.com.cbm.conquistadores.reino.domain.entities.Jogador;
import br.com.cbm.conquistadores.reino.domain.usecases.TreinarExercitoUseCase;

public class TreinarExercitoCommand implements AcaoCommand {

    Jogador jogador = Jogador.getInstance();
    
    @Override
	public void execute() {
        // Obter o exército do jogador
        Exercito exercito = jogador.getExercito();
		
        // Criar instância do caso de uso e executar
		TreinarExercitoUseCase useCase = new TreinarExercitoUseCase(exercito);
        useCase.execute();
    }
}