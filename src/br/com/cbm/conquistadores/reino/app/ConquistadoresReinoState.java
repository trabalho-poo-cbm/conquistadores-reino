package br.com.cbm.conquistadores.reino.app;

// TODO: Criar estados de vitoria e derrota
public class ConquistadoresReinoState {

	private State estado;
	
	private enum State {
		EM_ANDAMENTO,
		ENCERRADO,
		GANHO;
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

	public void vencer() {
		this.estado = State.GANHO;
	}
}