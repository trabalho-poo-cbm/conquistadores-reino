package br.com.cbm.conquistadores.reino.app.ui;

import br.com.cbm.conquistadores.reino.domain.entities.Jogador;
import br.com.cbm.conquistadores.reino.domain.entities.Mapa;

public class InterfaceDeUsuarioFacade {

	private final ImpressorDados impressor;
	private final LeitorDados leitor;

	public InterfaceDeUsuarioFacade(){
		this.impressor = new ImpressorDados();
		this.leitor = new LeitorDados();
	}

	public void exibirTitulo() {
		final String titulo = """
				  _____                        _     _            _                     
				 / ____|                      (_)   | |          | |                    
				| |     ___  _ __   __ _ _   _ _ ___| |_ __ _  __| | ___  _ __ ___  ___ 
				| |    / _ \\| '_ \\ / _` | | | | / __| __/ _` |/ _` |/ _ \\| '__/ _ \\/ __|
				| |___| (_) | | | | (_| | |_| | \\__ \\ || (_| | (_| | (_) | | |  __/\\__ \\
				 \\_____\\___/|_| |_|\\__, |\\__,_|_|___/\\__\\__,_|\\__,_|\\___/|_|  \\___||___/
				                      | |_____      _                                   
				                      |_|  __ \\    (_)                                  
				                        | |__) |___ _ _ __   ___                        
				                        |  _  // _ \\ | '_ \\ / _ \\                       
				                        | | \\ \\  __/ | | | | (_) |                      
				                        |_|  \\_\\___|_|_| |_|\\___/                       
                                                                        
				""";
		this.impressor.imprimeTexto(titulo);
	}
	
	public void exibirAcoes() {
		final String acoes = """
				1 - Exibir informacoes do jogador
				2 - Exibir mapa
				3 - Treinar exercito
				4 - Construir edificacoes
				5 - Conquistar Reino
				6 - Sair
				""";
		this.impressor.pulaLinha();
		this.impressor.imprimeTexto(acoes);
	}

	public int lerAcao(){
		final String mensagemExibicao = "Qual acao deseja realizar: ";
		final String mensagemErro = "Entrada invalida. Espera-se um numero inteiro entre 1 e 6. ";
		boolean acaoValida = false;
		int numero = -1;
		do {
			numero = leitor.lerNatural(mensagemExibicao, mensagemErro);
			if (numero >= 1 && numero <= 6) {
				break;
			}
			impressor.imprimeTexto(mensagemErro);
		} while(!acaoValida);
		return numero;
	}

	public void exibibirInformacaoJogador(Jogador jogador) {
		this.impressor.pulaLinha();
		this.impressor.imprimeObjeto(jogador);
	}

	public void exibirInformacaoMapa(Mapa mapa) {
		this.impressor.pulaLinha();
		this.impressor.imprimeObjeto(mapa);
	}
}