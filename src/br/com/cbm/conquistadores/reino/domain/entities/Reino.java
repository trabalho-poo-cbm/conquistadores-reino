package br.com.cbm.conquistadores.reino.domain.entities;

public class Reino {

	private String nomeReino;
	private String nomeRei;
	private Recursos recursos;
	private Exercito exercito;
	private Edificacoes edificacoes;
	
	public String getNomeReino() {
		return nomeReino;
	}
	
	// O Reino é composto nome, rei, recursos(madeira, pedra, ouro), exercito(arqueiro, cavaleiro, tanque), edificacao (muralha, torre, casa)
}