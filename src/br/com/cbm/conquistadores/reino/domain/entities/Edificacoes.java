package br.com.cbm.conquistadores.reino.domain.entities;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Edificacoes {

	private final Map<Edificacao, Integer> edificacoes;
	
	// TODO: Receber quantidade inicial do construtor
	public Edificacoes() {
		this.edificacoes = new ConcurrentHashMap<>();
		edificacoes.put(Edificacao.CASA, 20);
		edificacoes.put(Edificacao.MURALHA, 2);
		edificacoes.put(Edificacao.TORRE, 5);
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