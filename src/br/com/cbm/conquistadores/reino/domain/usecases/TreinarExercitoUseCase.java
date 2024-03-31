package br.com.cbm.conquistadores.reino.domain.usecases;

import br.com.cbm.conquistadores.reino.domain.entities.Exercito;
import java.util.Timer;
import java.util.TimerTask;

public class TreinarExercitoUseCase {
    
        private Exercito exercito;
//        private Timer timer;
    
        public TreinarExercitoUseCase(Exercito exercito) {
            this.exercito = exercito;
    
//            timer = new Timer();
//            timer.scheduleAtFixedRate(new TimerTask() {
//                @Override
//                public void run() {
//                    execute();
//                }
//            }, 0, 20 * 1000); // A cada 20 segundos
        }

        public void treinarExercito() {
            exercito.treinarTropas(10, 10);
        }
        
        @Override
        protected void finalize() throws Throwable {
//        	timer.cancel();
        }
}