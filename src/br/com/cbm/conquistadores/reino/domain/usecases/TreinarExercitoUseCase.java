package br.com.cbm.conquistadores.reino.domain.usecases;

import br.com.cbm.conquistadores.reino.domain.entities.Exercito;
import br.com.cbm.conquistadores.reino.domain.entities.Recursos;

public class TreinarExercitoUseCase {
    
    private Exercito exercito;
    private Recursos recursos;
            
    public TreinarExercitoUseCase(Exercito exercito, Recursos recursos) {
        this.exercito = exercito;
        this.recursos = recursos;
    }

    public void treinarExercito(int madeiraNecessaria, int ferroNecessario) {
        if (recursos.consumirRecursos(madeiraNecessaria, ferroNecessario)) {
            exercito.treinarTropas();
            System.out.println("Tropas treinadas com sucesso!");
        } else {
            System.out.println("Recursos insuficientes para treinar tropas!");
        }
    }
}