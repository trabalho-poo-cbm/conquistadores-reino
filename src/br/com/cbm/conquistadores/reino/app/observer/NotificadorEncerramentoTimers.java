package br.com.cbm.conquistadores.reino.app.observer;

import java.util.ArrayList;
import java.util.List;

import br.com.cbm.conquistadores.reino.domain.entities.Jogador;
import br.com.cbm.conquistadores.reino.domain.entities.Mapa;

public class NotificadorEncerramentoTimers {

	private final List<InterrompedorTimerObserver> interrompedores;
	
	// TODO: Garantir que todos os objetos que usarem timers estarão aqui
	public NotificadorEncerramentoTimers(Jogador jogador, Mapa mapa) {
		this.interrompedores = new ArrayList<>();
		this.interrompedores.add(jogador.getRecursos());
	}

	public void encerrarTimers() {
		this.interrompedores.forEach(InterrompedorTimerObserver::interromperTimer);
	}
}
