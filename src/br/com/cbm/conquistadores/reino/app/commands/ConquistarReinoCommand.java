package br.com.cbm.conquistadores.reino.app.commands;

public class ConquistarReinoCommand implements AcaoCommand {

	@Override
	public void execute() {
		System.out.println("Conquistar Reino");
	}
}