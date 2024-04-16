package br.com.cbm.conquistadores.reino.domain.entities;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import br.com.cbm.conquistadores.reino.config.InicializadorMapa;

public class Mapa {
	
	private static final Mapa INSTANCE;
	private final String nome;
	private final Map<Integer, Reino> reinos;
	
	static {
		INSTANCE = new Mapa();
	}
	
	private Mapa() {
		this.nome = "Niflheim";
		this.reinos = InicializadorMapa.inicializar();
	}
	
	public static Mapa getInstance() {
		return INSTANCE;
	}
	
	public String getNome() {
        return nome;
    }


    public Map<Integer, Reino> getReinos() {
        return reinos;
    }
    
    public Reino obterReino(Integer alvo) {
		return this.reinos.get(alvo);
	}
    
    @Override
    public String toString() {
    	return new StringBuilder()
    			.append("Informações do Mapa:")
    			.append("\nNome do Mapa: ")
    			.append(nome)
    			.append("\nReinos:")
    			.append(obterReinosComoTexto())
    			.toString();
    }

	private String obterReinosComoTexto() {
		StringBuilder reinosBuilder = new StringBuilder();
        Set<Entry<Integer, Reino>> reinosNoMapa = reinos.entrySet();
        for (Map.Entry<Integer, Reino> reino : reinosNoMapa) {
        	reinosBuilder.append("\n\n[").append(reino.getKey()).append("]");
            reinosBuilder.append(reino.getValue().toString());
        }
        reinosBuilder.append("\n\n[8]")
        		.append("\nReino: Arkanor")
        		.append("\nRei: Placeholder")
        		.append("\nCONQUISTADO");
        return reinosBuilder.toString();
	}

	public boolean isConquistado() {
		return reinos.values().stream().allMatch(Reino::isConquistado);
	}
}