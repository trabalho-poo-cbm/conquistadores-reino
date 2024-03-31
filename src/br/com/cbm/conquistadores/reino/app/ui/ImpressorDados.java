package br.com.cbm.conquistadores.reino.app.ui;

public class ImpressorDados {

	public void pulaLinha() {
		System.out.println();
	}

	public void imprimeTexto(String texto) {
		System.out.println(texto);
	}

	public void imprimeObjeto(Object objeto) {
		System.out.println(objeto.toString());
	}
}