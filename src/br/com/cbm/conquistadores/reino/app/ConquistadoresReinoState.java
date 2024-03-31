package br.com.cbm.conquistadores.reino.app;

// TODO: Verificar necessidade de um terceiro estado de vitoria e derrota
public class ConquistadoresReinoState {

	private State estado;
	private static final ConquistadoresReinoState INSTANCE;
	
	static {
		INSTANCE = new ConquistadoresReinoState();
	}
	
	private enum State {
		EM_ANDAMENTO,
		ENCERRADO;
	}

	public static ConquistadoresReinoState getInstance() {
		return INSTANCE;
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