package br.com.cbm.conquistadores.reino.domain.entities;

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