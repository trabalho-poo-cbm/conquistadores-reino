package br.com.cbm.conquistadores.reino.domain.entities;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

public class Exercito {

    private Map<Soldado, Integer> tropasTreinadas;
    private Timer timer;

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

        iniciarTimer();
    }

    private void iniciarTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                treinarTropas();
            }
        }, 0, 20 * 1000); 
    }

    public void treinarTropas() {

        tropasTreinadas.put(Soldado.ARQUEIRO, tropasTreinadas.get(Soldado.ARQUEIRO) + 1);

        tropasTreinadas.put(Soldado.CAVALEIRO, tropasTreinadas.get(Soldado.CAVALEIRO) + 1);
        
        tropasTreinadas.put(Soldado.TANQUE, tropasTreinadas.get(Soldado.TANQUE) + 1);
    }

    public Map<Soldado, Integer> getTropasTreinadas() {
        return tropasTreinadas;
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