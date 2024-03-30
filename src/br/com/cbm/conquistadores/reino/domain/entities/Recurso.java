package br.com.cbm.conquistadores.reino.domain.entities;

import java.util.Timer;
import java.util.TimerTask;

public class Recurso extends TimerTask {

    private int madeira;
    private int ferro;
    private Timer tempo;

    public Recurso() {
        this.madeira = 100;
        this.ferro = 100;

        tempo = new Timer();
        tempo.scheduleAtFixedRate(this, 0, 45 * 1000); // A cada 45 segundos
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
        // Aumenta a quantidade de recursos
        madeira += 10;
        ferro += 10;

        // Exibe a quantidade atual de recursos
        System.out.println("Madeira: " + madeira + " | Ferro: " + ferro);
    }
}