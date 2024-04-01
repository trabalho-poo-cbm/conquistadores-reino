package br.com.cbm.conquistadores.reino.domain.entities;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Edificacoes {

	private final Map<Edificacao, Integer> edificacoes;
	
	public Edificacoes(int casa, int muralha, int torre) {
		this.edificacoes = new ConcurrentHashMap<>();
		edificacoes.put(Edificacao.CASA, casa);
		edificacoes.put(Edificacao.MURALHA, muralha);
		edificacoes.put(Edificacao.TORRE, torre);
	}
	
	private enum Edificacao {
		CASA,
		MURALHA,
		TORRE
	}
	
	public void construir() {
        edificacoes.put(Edificacao.CASA, edificacoes.get(Edificacao.CASA) + 5);
        edificacoes.put(Edificacao.MURALHA, edificacoes.get(Edificacao.MURALHA) + 2);
        edificacoes.put(Edificacao.TORRE, edificacoes.get(Edificacao.TORRE) + 1);
    }

	@Override
	public String toString() {
		return new StringBuilder()
				.append("\nEdificacoes:")
				.append("\n\tCasas: ")
				.append(edificacoes.get(Edificacao.CASA))
				.append(" | Muralhas: ")
				.append(edificacoes.get(Edificacao.MURALHA))
				.append(" | Torres: ")
				.append(edificacoes.get(Edificacao.TORRE))
				.toString();
	}
	
	public int getTotalEdificacoesConstruidas() {
        int totalEdificacoes = 0;
        for (int quantidade : edificacoes.values()) {
            totalEdificacoes += quantidade;
        }
        return totalEdificacoes;
    }
}