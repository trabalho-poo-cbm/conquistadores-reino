package br.com.cbm.conquistadores.reino.app.ui;

import java.io.PrintWriter;
import java.util.Scanner;

// TODO: Separar responsabilidades em mais objetos
public class InterfaceDeUsuarioFacade {

	private final Scanner scanner;
	private final PrintWriter writer;

	public InterfaceDeUsuarioFacade(){
		this.scanner = new Scanner(System.in);
		this.writer = new PrintWriter(System.out);
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
		writer.println(titulo);
	}
	
	public void imprimirAcoes() {
		final String acoes = """
				1 - Exibir informacoes
				2 - Treinar exercito
				3 - Construir edificacoes
				4 - Conquistar Reino
				5 - Sair
				""";
		writer.println(acoes);
	}

	public int lerAcao(){
		return 0;
	}
}