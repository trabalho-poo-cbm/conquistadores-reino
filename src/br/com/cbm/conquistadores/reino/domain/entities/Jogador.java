package br.com.cbm.conquistadores.reino.domain.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jogador {
	
	private final static Jogador INSTANCE;
	private String nomeRei;
    private List<String> reinosConquistados;
    private Recursos recursos;
    private Exercito exercito;
    private Edificacoes edificacoes;

    static {
    	INSTANCE = new Jogador();
    }
    
    private Jogador() {
    	Random random = new Random();
    	this.nomeRei = "Bjorn";
    	this.reinosConquistados = new ArrayList<>();
    	this.reinosConquistados.add("Arkanor");
    	this.recursos = new Recursos(random.nextInt(16) + 10, random.nextInt(16) + 10, random.nextInt(16) + 10);
    	this.exercito = new Exercito(random.nextInt(16) + 10, random.nextInt(16) + 10, random.nextInt(16) + 10);
    	this.edificacoes = new Edificacoes(random.nextInt(16) + 10, random.nextInt(16) + 10, random.nextInt(16) + 10);
    }

    public static Jogador getInstance() {
        return INSTANCE;
    }

    public String getNome() {
        return nomeRei;
    }

    public List<String> getReinosConquistados() {
        return reinosConquistados;
    }

    public Exercito getExercito() {
        return exercito;
    }

    public Recursos getRecursos() {
    	return recursos;
    }

    public Edificacoes getEdificacoes(){
        return edificacoes;
    }
    
    public void adicionarReinoConquistado(String nomeReino) {
        reinosConquistados.add(nomeReino);
    }
    
    @Override
    public String toString() {
    	return new StringBuilder()
    			.append("Informações do Jogador:")
    			.append("\nNome: ")
    			.append(nomeRei)
    			.append(obterReinosConquistadosComoTexto())
    			.append(recursos.toString())
    			.append(exercito.toString())
    			.append(edificacoes.toString())
    			.toString();
    }

	private String obterReinosConquistadosComoTexto() {
		if (reinosConquistados.isEmpty()) {
    		return "\nO jogador não conquistou nenhum reino ainda.";
    	} 
		StringBuilder reinosConquistadosBuilder = new StringBuilder("\nReinos Conquistados:");
		for (String nomeReino : reinosConquistados) {
			reinosConquistadosBuilder.append("\n\tReino: ").append(nomeReino);
        }
		return reinosConquistadosBuilder.toString();
	}
}