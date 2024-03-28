package br.com.cbm.conquistadores.reino.domain.entities;

// TODO: Verificar possibilidade de usar Singleton ao invés de instanciar na Facade do jogo
// TODO: Verificar necessidade de um terceiro estado de vitoria e derrota
// TODO: Simplificar nome ou mover de pacote
public class ConquistadoresReinoState {

	private State estado;
	
	private enum State {
		EM_ANDAMENTO,
		ENCERRADO;
	}
	
	public void inciar() {
		this.estado = State.EM_ANDAMENTO;
	}

	public boolean estaEmAndamento() {
		return estado == State.EM_ANDAMENTO;
	}
	
	public void encerrar() {
		this.estado = State.ENCERRADO;
	}
}