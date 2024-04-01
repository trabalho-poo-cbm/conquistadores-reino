package br.com.cbm.conquistadores.reino.domain.entities;

public class Reino {
	
	private String nomeReino;
	private String nomeRei;
	private Recursos recursos;
	private Exercito exercito;
	private Edificacoes edificacoes;
	private boolean conquistado;

	public Reino(String nomeReino, String nomeRei, Recursos recursos, Exercito exercito, Edificacoes edificacoes) {
		this.nomeReino = nomeReino;
		this.nomeRei = nomeRei;
		this.recursos = recursos;
		this.exercito = exercito;
		this.edificacoes = edificacoes;
		this.conquistado = false;
	}

	public String getNomeReino() {
		return nomeReino;
	}
	
	public Recursos getRecursos() {
		return recursos;
	}
	
	public Exercito getExercito() {
		return exercito;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("\nReino: ").append(nomeReino)
				.append("\nRei: ").append(nomeRei);
		if (conquistado) {
			builder.append("\nCONQUISTADO");
		} else {
			builder.append(recursos.toString())
					.append(recursos.toString())
					.append(exercito.toString())
					.append(edificacoes.toString());
		}
		return builder.toString();
	}
	
	public int getDefesa() {
		int defesa = (int) ((0.5*exercito.getTotalTropasTreinadas()) + (0.5*edificacoes.getTotalEdificacoesConstruidas()));
		return defesa;
	}
}