package br.com.cbm.conquistadores.reino.app.commands.processor;

import br.com.cbm.conquistadores.reino.app.commands.AcaoCommand;

public class AcaoProcessor {

	public void processa(AcaoCommand acao) {
		acao.execute();
	}
}