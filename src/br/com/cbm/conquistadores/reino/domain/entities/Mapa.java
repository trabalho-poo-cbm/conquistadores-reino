package br.com.cbm.conquistadores.reino.domain.entities;

import java.util.HashMap;
import java.util.Map;

public class Mapa {
	
	private String Name;
	private final Map<Integer, Reino> reinos;
	private static final Mapa INSTANCE;
	
	static {
		INSTANCE = new Mapa();
		// TODO: Popular reinos no atributo reinos;
	}
	
	private Mapa() {
		// TODO: Definir nome no construtor
		this.reinos = new HashMap<>();
	}
	
	public static Mapa getInstance() {
		return INSTANCE;
	}
	
	public String getName() {
        return Name;
    }


    public Map<Integer, Reino> getReinos() {
        return reinos;
    }
	
	// TODO: Remover método, pois não se deve adicionar reinos aqui
	@Deprecated()
    public void adicionarReino(Integer chave, Reino reino) {
        reinos.put(chave, reino);
    }
}