package br.com.cbm.conquistadores.reino.app.commands;

import br.com.cbm.conquistadores.reino.domain.entities.Mapa;
import br.com.cbm.conquistadores.reino.domain.entities.Reino;

import java.util.Map;

public class ExibirMapaCommand implements AcaoCommand {
	
	private final Mapa mapa;
	
	public ExibirMapaCommand(Mapa mapa) {
        this.mapa = mapa;
    }

    public void exibirMapa() {
        System.out.println("Informações do Mapa:");
        System.out.println("Nome do Mapa: " + mapa.getName());
        System.out.println("Reinos no Mapa:");
        Map<Integer, Reino> reinosNoMapa = mapa.getReinos();
        if (reinosNoMapa != null && !reinosNoMapa.isEmpty()) {
            for (Map.Entry<Integer, Reino> entry : reinosNoMapa.entrySet()) {
                System.out.println("Chave: " + entry.getKey() + ", Reino: " + entry.getValue().getNome());
            }
        } else {
            System.out.println("O mapa não possui nenhum reino.");
        }
    }
	
	@Override
	public void execute() {
		// Implementação deve ser feita em uma classe de use case
		// Exibir objeto mapa
			// O mapa possui um nome é composto por reinos (usar map<Integer, Reino>)
		exibirMapa();
		
	}
}