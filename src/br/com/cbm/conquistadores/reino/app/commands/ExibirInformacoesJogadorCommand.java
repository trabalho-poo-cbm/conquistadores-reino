package br.com.cbm.conquistadores.reino.app.commands;

import br.com.cbm.conquistadores.reino.domain.entities.Jogador;
import br.com.cbm.conquistadores.reino.domain.entities.Reino;

import java.util.Map;

public class ExibirInformacoesJogadorCommand implements AcaoCommand {
	
	private final Jogador Jogador;
	
	public ExibirInformacoesJogadorCommand(Jogador jogador) {
		this.Jogador = jogador;
	}
	
	public void exibirInformacoesJogador() {
        System.out.println("Informações do Jogador:");
        System.out.println("Nome: " + Jogador.getNome());
        System.out.println("Reinos Conquistados:");
        Map<Integer, Reino> reinosConquistados = Jogador.getReinosConquistados();
        if (reinosConquistados != null && !reinosConquistados.isEmpty()) {
            for (Map.Entry<Integer, Reino> entry : reinosConquistados.entrySet()) {
                System.out.println("Chave: " + entry.getKey() + ", Reino: " + entry.getValue().getNome());
            }
        } else {
            System.out.println("O jogador não conquistou nenhum reino ainda.");
        }
    }
	
	@Override
	public void execute() {
		// Implementação deve ser feita em uma classe de use case
		// Imprimir o objeto jogador e seus atributos
		System.out.println("Exibir informacoes");
		exibirInformacoesJogador();
	}
}