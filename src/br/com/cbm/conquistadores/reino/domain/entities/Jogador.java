package br.com.cbm.conquistadores.reino.domain.entities;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
	
	private String nome;
    private List<String> reinosConquistados;
    private Recursos recursos;
    private Exercito exercito;
    private Edificacoes edificacoes;
    private final static Jogador INSTANCE;

    static {
    	INSTANCE = new Jogador();
    }
    
    private Jogador() {
    	// TODO: Definir nome padrão para o Jogador ou deixar escolher
    	this.nome = "";
    	this.reinosConquistados = new ArrayList<>();
    	this.recursos = new Recursos();
    	this.exercito = new Exercito(recursos); // TODO: Recursos não é dependência de exército
    	this.edificacoes = new Edificacoes();
    }

    public static Jogador getInstance() {
        return INSTANCE;
    }

    public String getNome() {
        return nome;
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
    
    public void adicionarReinoConquistado(String nomeReino) {
        reinosConquistados.add(nomeReino);
    }
}