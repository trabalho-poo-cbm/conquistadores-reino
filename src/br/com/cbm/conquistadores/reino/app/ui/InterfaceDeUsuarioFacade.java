package br.com.cbm.conquistadores.reino.app.ui;

import java.util.Scanner;

// TODO: Separar responsabilidades em mais objetos
public class InterfaceDeUsuarioFacade {

	private final Scanner scanner;

	public InterfaceDeUsuarioFacade(){
		this.scanner = new Scanner(System.in);
	}

	public void imprimirTitulo() {
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
		System.out.println(titulo);
	}
	
	public void imprimirAcoes() {
		final String acoes = """
				1 - Exibir informacoes do jogador
				2 - Exibir mapa
				3 - Treinar exercito
				4 - Construir edificacoes
				5 - Conquistar Reino
				6 - Sair
				""";
		System.out.println(acoes);
	}

	public int lerAcao(){

		int numero = 0;

		do{
			numero = lerNatural("Digite um número inteiro entre 1 e 6: ");
		} while(numero < 1 || numero > 6);
		return numero;
	}

	private int lerNatural(String mensagem){

		String entrada;
		int numero = 0;

		do {
			System.out.println(mensagem);
			entrada = scanner.nextLine();

			boolean isNumber = true;
			for (char c : entrada.toCharArray()) {
				if (!Character.isDigit(c)) {
					isNumber = false;
					break;
				}
			}

			if (!isNumber) {
				System.out.println("Entrada inválida. ".concat(mensagem));
				continue;
			}

			numero = Integer.parseInt(entrada);

		} while (numero < 0);

		return numero;
	}
}