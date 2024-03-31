package br.com.cbm.conquistadores.reino.domain.entities;

import java.util.Timer;
import java.util.TimerTask;

import br.com.cbm.conquistadores.reino.app.observer.InterrompedorTimerObserver;

public class Recursos extends TimerTask implements InterrompedorTimerObserver {

    private int madeira;
    private int ferro;
    private Timer timer;

    public Recursos() {
        this.madeira = 100;
        this.ferro = 100;

        timer = new Timer();
        timer.scheduleAtFixedRate(this, 0, 45 * 1000); // A cada 45 segundos
    }

    public int getMadeira() {
        return madeira;
    }

    public void setMadeira(int madeira) {
        this.madeira = madeira;
    }

    public int getFerro() {
        return ferro;
    }

    public void setFerro(int ferro) {
        this.ferro = ferro;
    }

    public boolean consumirRecursos(int madeiraNecessaria, int ferroNecessario) {
        if (madeira >= madeiraNecessaria && ferro >= ferroNecessario) {
            madeira -= madeiraNecessaria;
            ferro -= ferroNecessario;
            return true;
        }
        return false;
    }

    @Override
    public void run() {
        madeira += 10;
        ferro += 10;
    }

	@Override
	public void interromperTimer() {
		timer.cancel();
	}
}