package br.com.cbm.conquistadores.reino.app.commands;

import java.util.List;

import br.com.cbm.conquistadores.reino.domain.entities.Jogador;

public class ExibirInformacoesJogadorCommand implements AcaoCommand {
	
	private final Jogador jogador;
	
	public ExibirInformacoesJogadorCommand() {
		this.jogador = Jogador.getInstance();
	}
	
	public void exibirInformacoesJogador() {
        System.out.println("Informações do Jogador:");
        System.out.println("Nome: " + jogador.getNome());
        System.out.println("Reinos Conquistados:");
        List<String> reinosConquistados = jogador.getReinosConquistados();
        if (reinosConquistados != null && !reinosConquistados.isEmpty()) {
        	for (String nomeReino : reinosConquistados) {
                System.out.println("Reino: " + nomeReino);
            }
        } else {
            System.out.println("O jogador não conquistou nenhum reino ainda.");
        }
    }
	
	@Override
	public void execute() {
		System.out.println("Exibir informacoes");
		exibirInformacoesJogador();
	}
}