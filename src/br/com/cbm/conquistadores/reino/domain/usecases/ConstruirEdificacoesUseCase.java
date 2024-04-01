package br.com.cbm.conquistadores.reino.domain.usecases;

import br.com.cbm.conquistadores.reino.domain.entities.Edificacoes;
import br.com.cbm.conquistadores.reino.domain.entities.Recursos;

public class ConstruirEdificacoesUseCase {

    private Edificacoes edificacoes;
    private Recursos recursos;

    public ConstruirEdificacoesUseCase(Edificacoes edificacoes, Recursos recursos) {
        this.edificacoes = edificacoes;
        this.recursos = recursos;
    }

    public void construirEdificacao(int madeiraNecessaria, int pedraNecessaria) {
        if (recursos.consumirRecursos(madeiraNecessaria, pedraNecessaria)) {
            edificacoes.construir();
            System.out.println("Edificação construída com sucesso!");
        } else {
            System.out.println("Recursos insuficientes para construir edificação!");
        }
    }
}