package br.com.cbm.conquistadores.reino.app.commands;

public class CommandFactory {

	private CommandFactory() {
	}
	
	public static AcaoCommand criaAcao(int acao) {
		return switch(acao) {
			case 1 -> new ExibirInformacoesJogadorCommand();
			case 2 -> new ExibirMapaCommand();
			case 3 -> new TreinarExercitoCommand();
			case 4 -> new ConstruirEdificacacoesCommand();
			case 5 -> new ConquistarReinoCommand();
			case 6 -> new SairCommand();
			default -> throw new IllegalArgumentException("Valor inesperado para acao (esperado de 1 a 5): " + acao);
		};
	}
}