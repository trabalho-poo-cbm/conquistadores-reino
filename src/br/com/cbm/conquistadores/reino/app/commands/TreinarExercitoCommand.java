package br.com.cbm.conquistadores.reino.app.commands;

import br.com.cbm.conquistadores.reino.domain.entities.Exercito;
import java.util.Timer;
import java.util.TimerTask;

public class TreinarExercitoCommand implements Runnable {

	private Exercito exercito;
    private Timer timer;

    public TreinarExercitoCommand(Exercito exercito) {
        this.exercito = exercito;

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                execute();
            }
        }, 0, 20 * 1000); // A cada 20 segundos
    }

    @Override
    public void run() {
        execute();
    }

    public void execute() {
        exercito.treinarTropas(10, 10);
	}
}