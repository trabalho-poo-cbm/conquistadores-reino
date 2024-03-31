package br.com.cbm.conquistadores.reino.app.commands;

public class ConquistarReinoCommand implements AcaoCommand {

	@Override
	public void execute() {
		
		// Implementação deve ser feita em uma classe de use case
		// Combate e feito calculando a diferenca de valores entre exercito do jogador e exercito e edificacoes do reino a ser conquistado
			// Em caso de vitoria, o reino e anexado ao Jogador, seus recursos são somados, as edificações e exército são somados apenas uma porcentagem
			// Em caso de derrota, o jogo e encerrado
			// Ao conquitar todos os reinos, o jogo é finalizado com vitória
				// É necessário fazer uma checagem se todos os reinos no mapa para verificar se todos os reinos estão conquistados, se sim encerrar jogo
		System.out.println("Conquistar Reino");
	}
}