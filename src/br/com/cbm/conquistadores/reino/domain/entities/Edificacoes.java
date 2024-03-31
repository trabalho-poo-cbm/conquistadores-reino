package br.com.cbm.conquistadores.reino.domain.entities;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Edificacoes {

	private final Map<Edificacao, Integer> edificacoes;
	
	// TODO: Receber quantidade inicial do construtor
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
	
	// TODO: Ajustar formatação texto
	@Override
	public String toString() {
		return "\nEdificacoes";
	}
}