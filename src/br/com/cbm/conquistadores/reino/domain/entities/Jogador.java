package br.com.cbm.conquistadores.reino.domain.entities;

import java.util.Map;

public class Jogador {
	private String nome;
    private Map<Integer, Reino> reinosConquistados = null;
    private static Jogador instance;
    private Exercito exercito;

    public Jogador(String nome) {
        this.nome = nome;
    }

    public static Jogador getInstance(String nome) {
        if (instance == null) {
            instance = new Jogador(nome);
        }
        return instance;
    }

    public String getNome() {
        return nome;
    }

    public Map<Integer, Reino> getReinosConquistados() {
        return reinosConquistados;
    }

    public void adicionarReinoConquistado(Integer chave, Reino reino) {
        reinosConquistados.put(chave, reino);
    }

    public Exercito getExercito() {
        return exercito;
    }
 
}