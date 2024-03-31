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
        // TODO: Recurso não herda de timer task, usar classe anônima aqui
        timer.scheduleAtFixedRate(this, 0, 45 * 1000); // A cada 45 segundos
    }

    public enum Recurso {
    	FERRO,
    	MADEIRA,
    	OURO
    }
    
    public Map<Recurso, Integer> getRecursos() {
		return recursos;
	}

    public boolean consumirRecursos(int madeiraNecessaria, int ferroNecessario) {
        int madeira = recursos.getOrDefault(Recurso.MADEIRA, 0);
        int ferro = recursos.getOrDefault(Recurso.FERRO, 0);
    	
    	if (madeira >= madeiraNecessaria && ferro >= ferroNecessario) {
            
            recursos.put(Recurso.MADEIRA, recursos.get(Recurso.MADEIRA) - madeiraNecessaria);
            recursos.put(Recurso.FERRO, recursos.get(Recurso.FERRO) - ferroNecessario);
            
            return true;
        }
        return false;
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