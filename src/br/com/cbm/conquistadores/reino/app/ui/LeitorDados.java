package br.com.cbm.conquistadores.reino.app.ui;

import java.util.Scanner;

public class LeitorDados {

	private final Scanner scanner;

	public LeitorDados() {
		this.scanner = new Scanner(System.in);
	}
	
	public int lerNatural(String mensagem, String mensagemErro){

		String entrada = "";
		int numero = -1;

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

			if (!isNumber || entrada.isBlank()) {
				System.out.println(mensagemErro);
				continue;
			}

			numero = Integer.parseInt(entrada);

		} while (numero < 0);

		return numero;
	}

	public String leSimOuNao(String mensagem, String mensagemErro) {
		String resposta = "";
		boolean respostaValida = false;
		while (!respostaValida) {
			System.out.print(mensagem);
			resposta = scanner.nextLine().toUpperCase();
			if (resposta.equals("S") || resposta.equals("N")) {
				break;
			}
			System.out.println(mensagemErro);
		}
        return resposta;
	}
}