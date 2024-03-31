package br.com.cbm.conquistadores.reino.domain.entities;

import java.util.Map;

import br.com.cbm.conquistadores.reino.config.InicializadorMapa;

public class Mapa {
	
	private static final Mapa INSTANCE;
	private final String name;
	private final Map<Integer, Reino> reinos;
	
	static {
		INSTANCE = new Mapa();
	}
	
	private Mapa() {
		// TODO: Definir nome do mapa no construtor
		this.name = "Placeholder";
		this.reinos = InicializadorMapa.inicializar();
	}
	
	public static Mapa getInstance() {
		return INSTANCE;
	}
	
	public String getName() {
        return name;
    }


    public Map<Integer, Reino> getReinos() {
        return reinos;
    }
}