package br.com.cbm.conquistadores.reino.app.commands;

import br.com.cbm.conquistadores.reino.domain.usecases.TreinarExercitoUseCase;
import br.com.cbm.conquistadores.reino.domain.entities.Exercito;
import br.com.cbm.conquistadores.reino.domain.entities.Jogador;

public class TreinarExercitoCommand implements AcaoCommand {

    Jogador jogador = Jogador.getInstance("Teste");
    
    @Override
	public void execute() {
        // Obter o exército do jogador
        Exercito exercito = jogador.getExercito();
		
        // Criar instância do caso de uso e executar
		TreinarExercitoUseCase useCase = new TreinarExercitoUseCase(exercito);
        useCase.execute();
    }
}