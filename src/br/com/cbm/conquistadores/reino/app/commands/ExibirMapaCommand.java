package br.com.cbm.conquistadores.reino.app.commands;

import br.com.cbm.conquistadores.reino.app.ui.InterfaceDeUsuarioFacade;
import br.com.cbm.conquistadores.reino.domain.entities.Mapa;
import br.com.cbm.conquistadores.reino.domain.usecases.ExibirMapaUseCase;

public class ExibirMapaCommand implements AcaoCommand {
	
	private final Mapa mapa;
	private final InterfaceDeUsuarioFacade interfaceDeUsuario;
	
	public ExibirMapaCommand(Mapa mapa, InterfaceDeUsuarioFacade interfaceDeUsuario) {
		this.mapa = mapa;
		this.interfaceDeUsuario = interfaceDeUsuario;
    }
	
	@Override
	public void execute() {
		ExibirMapaUseCase useCase = new ExibirMapaUseCase(mapa, interfaceDeUsuario);
		useCase.exibirMapa();
	}
}