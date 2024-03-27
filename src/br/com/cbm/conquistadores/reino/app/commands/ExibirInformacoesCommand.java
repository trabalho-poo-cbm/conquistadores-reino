package br.com.cbm.conquistadores.reino.app.commands;

public class ExibirInformacoesCommand implements AcaoCommand {

	@Override
	public void execute() {
		System.out.println("Exibir informacoes");
	}
}