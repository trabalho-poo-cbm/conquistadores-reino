package br.com.cbm.conquistadores.reino.app.commands;

public class AcaoProcessor {

	public void processa(AcaoCommand acao) {
		acao.execute();
	}
}