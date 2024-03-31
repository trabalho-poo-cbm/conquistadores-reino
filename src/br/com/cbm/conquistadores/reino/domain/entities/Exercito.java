package br.com.cbm.conquistadores.reino.domain.entities;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Exercito {

    private Map<Soldado, Integer> tropasTreinadas;
    private Recursos recursos;

    private enum Soldado {
    	ARQUEIRO,
    	CAVALEIRO,
    	TANQUE
    }
    
    public Exercito(int arqueiro, int cavaleiro, int tanque) {
    	this.tropasTreinadas = new ConcurrentHashMap<>();
    	this.tropasTreinadas.put(Soldado.ARQUEIRO, arqueiro);
    	this.tropasTreinadas.put(Soldado.CAVALEIRO, cavaleiro);
    	this.tropasTreinadas.put(Soldado.TANQUE, tanque);
	}

	public Map<Soldado, Integer> getTropasTreinadas() {
        return tropasTreinadas;
    }

	// TODO: Ajustar parte da lógica na classe usecase
    public void treinarTropas(int madeiraNecessaria, int ferroNecessario) {
        if (recursos.consumirRecursos(madeiraNecessaria, ferroNecessario)) {
        	tropasTreinadas.put(Soldado.ARQUEIRO, tropasTreinadas.getOrDefault(Soldado.ARQUEIRO, 0) + 10);
        	tropasTreinadas.put(Soldado.CAVALEIRO, tropasTreinadas.getOrDefault(Soldado.CAVALEIRO, 0) + 10);
        	tropasTreinadas.put(Soldado.TANQUE, tropasTreinadas.getOrDefault(Soldado.TANQUE, 0) + 10);
            System.out.println("Tropas treinadas: " + tropasTreinadas);
        } else {
            System.out.println("Recursos insuficientes para treinar tropas!");
        }
    }
    
    @Override
    public String toString() {
    	return new StringBuilder()
    			.append("\nTropas treinadas:")
    			.append("\n\tArqueiros: ")
    			.append(tropasTreinadas.get(Soldado.ARQUEIRO))
    			.append(" | Cavaleiros: ")
    			.append(tropasTreinadas.get(Soldado.CAVALEIRO))
    			.append(" | Tanques: ")
    			.append(tropasTreinadas.get(Soldado.TANQUE))
    			.toString();
    }
}