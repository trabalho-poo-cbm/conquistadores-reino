package br.com.cbm.conquistadores.reino.domain.entities;

public class Reino {

	private String nome;
	private Rei rei;
	private Recursos recursos;
	private Exercito exercito;
	private Edificacoes edificacoes;
	
	public String getNome() {
		return nome;
	}
	
	// O Reino é composto nome, rei, recursos(madeira, pedra, ouro), exercito(arqueiro, cavaleiro, tanque), edificacao (muralha, torre, casa)
}