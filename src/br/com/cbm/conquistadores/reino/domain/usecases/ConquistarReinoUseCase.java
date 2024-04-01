package br.com.cbm.conquistadores.reino.domain.usecases;

import java.util.Scanner;

import br.com.cbm.conquistadores.reino.app.ConquistadoresReinoState;
import br.com.cbm.conquistadores.reino.app.ui.ImpressorDados;
import br.com.cbm.conquistadores.reino.app.ui.InterfaceDeUsuarioFacade;
import br.com.cbm.conquistadores.reino.domain.entities.Jogador;
import br.com.cbm.conquistadores.reino.domain.entities.Mapa;
import br.com.cbm.conquistadores.reino.domain.entities.Reino;
public class ConquistarReinoUseCase {

	private final Jogador jogador;
	private final Mapa mapa;
	private final InterfaceDeUsuarioFacade interfaceDeUsuario;
	private final ImpressorDados impressor;
	private final Scanner scanner;
	private ConquistadoresReinoState estadoDoJogo;
	
	public ConquistarReinoUseCase(Jogador jogador, Mapa mapa, InterfaceDeUsuarioFacade interfaceDeUsuario, ConquistadoresReinoState estadoDoJogo) {
		this.jogador = jogador;
		this.mapa = mapa;
		this.interfaceDeUsuario = interfaceDeUsuario;
		this.estadoDoJogo = estadoDoJogo;
		this.impressor = new ImpressorDados();
		this.scanner = new Scanner(System.in);
	}
	
	public void conquistarReino() {
		interfaceDeUsuario.exibirInformacaoMapa(mapa);
		final String pergunta = "Qual reino deseja atacar?";
		impressor.imprimeTexto(pergunta);
		
		
		String entrada;
		int numero = 0;

		do {
			entrada = scanner.nextLine();

			boolean isNumber = true;
			for (char c : entrada.toCharArray()) {
				if (!Character.isDigit(c)) {
					isNumber = false;
					break;
				}
			}

			if (!isNumber) {
				System.out.println("Entrada inválida. ");
				continue;
			}

			numero = Integer.parseInt(entrada);

		} while (numero < 0);
		
		Reino alvo = mapa.getReinos().get(numero);
		
		if (reinoConquistado(alvo)) {
			final String mensagem = "O reino selecionado ja foi conquistado!";
			impressor.imprimeTexto(mensagem);
			return;
		}
		
		if (jogador.getExercito().getTotalTropasTreinadas() < alvo.getDefesa()) {
			estadoDoJogo.perder();
			return;
		}
		
		jogador.adicionarReinoConquistado(alvo.getNomeReino());
		alvo.setNomeRei(jogador.getNome());
		alvo.setConquistado();
		
		
		//exibe o resultado
	}
	
	private boolean reinoConquistado(Reino alvo) {
        if (jogador.getReinosConquistados().contains(alvo.getNomeReino())) {
            return true; 
        }
        return false;
	}
}
	
