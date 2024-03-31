package br.com.cbm.conquistadores.reino.domain.entities;

public class Reino {
	
	private String nomeReino;
	private String nomeRei;
	private Recursos recursos;
	private Exercito exercito;
	private Edificacoes edificacoes;

	public Reino(String nomeReino, String nomeRei, Recursos recursos, Exercito exercito, Edificacoes edificacoes) {
		this.nomeReino = nomeReino;
		this.nomeRei = nomeRei;
		this.recursos = recursos;
		this.exercito = exercito;
		this.edificacoes = edificacoes;
	}

	public String getNomeReino() {
		return nomeReino;
	}
	
	public Recursos getRecursos() {
		return recursos;
	}
	
	// O Reino é composto nome, rei, recursos(madeira, pedra, ouro), exercito(arqueiro, cavaleiro, tanque), edificacao (muralha, torre, casa)
}