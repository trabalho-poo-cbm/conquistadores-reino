package br.com.cbm.conquistadores.reino.domain.entities;

import java.util.Map;

public class Mapa {
	
	private String Name;
	private final Map<Integer, Reino> reinos = null;
	
	public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void adicionarReino(Integer chave, Reino reino) {
        reinos.put(chave, reino);
    }

    public Map<Integer, Reino> getReinos() {
        return reinos;
    }
}