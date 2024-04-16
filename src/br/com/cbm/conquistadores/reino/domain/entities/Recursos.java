package br.com.cbm.conquistadores.reino.domain.entities;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

import br.com.cbm.conquistadores.reino.app.observer.InterrompedorTimerObserver;

public class Recursos extends TimerTask implements InterrompedorTimerObserver {

	private final Map<Recurso, Integer> recursos;
    private Timer timer;

    public Recursos(int ferro, int madeira, int ouro) {
        this.recursos = new ConcurrentHashMap<>();
        this.recursos.put(Recurso.FERRO, ferro);
        this.recursos.put(Recurso.MADEIRA, madeira);
        this.recursos.put(Recurso.OURO, ouro);
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                recursos.put(Recurso.MADEIRA, recursos.getOrDefault(Recurso.MADEIRA, 0) + 10);
                recursos.put(Recurso.FERRO, recursos.getOrDefault(Recurso.FERRO, 0) + 10);
            }
        }, 0, 45 * 1000);
    }

    public enum Recurso {
    	FERRO,
    	MADEIRA,
    	OURO
    }
    
    public Map<Recurso, Integer> getRecursos() {
		return recursos;
	}

    public void consumirRecursos(Map<Recurso, Integer> orcamento) {
    	recursos.put(Recurso.FERRO, recursos.get(Recurso.FERRO) - orcamento.getOrDefault(Recurso.FERRO, 0));
        recursos.put(Recurso.MADEIRA, recursos.get(Recurso.MADEIRA) - orcamento.getOrDefault(Recurso.MADEIRA, 0));
        recursos.put(Recurso.OURO, recursos.get(Recurso.OURO) - orcamento.getOrDefault(Recurso.OURO, 0));
    }
    
    @Override
    public void run() {
        recursos.put(Recurso.MADEIRA, recursos.getOrDefault(Recurso.MADEIRA, 0) + 10);
        recursos.put(Recurso.FERRO, recursos.getOrDefault(Recurso.FERRO, 0) + 10);
    }

	@Override
	public void interromperTimer() {
		timer.cancel();
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
			.append("\nRecursos:")
			.append("\n\tFerro: ")
			.append(recursos.get(Recurso.FERRO))
			.append(" | Madeira: ")
			.append(recursos.get(Recurso.MADEIRA))
			.append(" | Ouro: ")
			.append(recursos.get(Recurso.OURO))
			.toString();
	}
}