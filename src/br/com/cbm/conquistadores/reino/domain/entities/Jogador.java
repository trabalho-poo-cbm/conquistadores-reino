package br.com.cbm.conquistadores.reino.domain.entities;

import java.util.Map;

public class Jogador {
	private String nome;
    private Map<Integer, Reino> reinosConquistados = null;

    public Jogador(String nome) {
        this.nome = nome;
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
 
}