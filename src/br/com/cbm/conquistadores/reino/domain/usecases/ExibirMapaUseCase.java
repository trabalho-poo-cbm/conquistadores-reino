package br.com.cbm.conquistadores.reino.domain.usecases;

import br.com.cbm.conquistadores.reino.app.ui.InterfaceDeUsuarioFacade;
import br.com.cbm.conquistadores.reino.domain.entities.Mapa;

public class ExibirMapaUseCase {

	private final  Mapa mapa;
	private final InterfaceDeUsuarioFacade interfaceDeUsuario;

	public ExibirMapaUseCase(Mapa mapa, InterfaceDeUsuarioFacade interfaceDeUsuario) {
		this.mapa = mapa;
		this.interfaceDeUsuario = interfaceDeUsuario;
	}

	public void exibirMapa() {
		interfaceDeUsuario.exibirInformacaoMapa(mapa);
	}
}