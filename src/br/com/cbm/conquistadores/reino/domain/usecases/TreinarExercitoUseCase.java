package br.com.cbm.conquistadores.reino.domain.usecases;

import java.util.Map;

import br.com.cbm.conquistadores.reino.app.ui.InterfaceDeUsuarioFacade;
import br.com.cbm.conquistadores.reino.domain.entities.Exercito;
import br.com.cbm.conquistadores.reino.domain.entities.Recursos;
import br.com.cbm.conquistadores.reino.domain.entities.Recursos.Recurso;

public class TreinarExercitoUseCase {
    
    private final Exercito exercito;
    private final Recursos recursos;
	private final InterfaceDeUsuarioFacade interfaceDeUsuario;
            
    public TreinarExercitoUseCase(Exercito exercito, Recursos recursos,
    		InterfaceDeUsuarioFacade interfaceDeUsuario) {
        this.exercito = exercito;
        this.recursos = recursos;
		this.interfaceDeUsuario = interfaceDeUsuario;
    }

    public void treinarExercito() {
    	Map<Recursos.Recurso, Integer> orcamento = Map.of(Recursos.Recurso.FERRO, 10, Recursos.Recurso.MADEIRA, 10);
    	interfaceDeUsuario.exibirCustoTreinamentoExercito(exercito, recursos, orcamento);
    	if (interfaceDeUsuario.confirmaAcao() && isRecursosSuficientes(recursos, orcamento)) {
    		recursos.consumirRecursos(orcamento);
    		exercito.treinarTropas();
    		interfaceDeUsuario.exibirTexto("Tropas treinadas com sucesso!");
    	} else {
    		interfaceDeUsuario.exibirTexto("Recursos insuficientes para treinar tropas!");
        }
    }

	private boolean isRecursosSuficientes(Recursos recursos, Map<Recurso, Integer> orcamento) {
		int ferro = recursos.getRecursos().getOrDefault(Recurso.FERRO, 0);
		int madeira = recursos.getRecursos().getOrDefault(Recurso.MADEIRA, 0);
		int ferroNecessario = orcamento.get(Recursos.Recurso.FERRO);
		int madeiraNecessaria = orcamento.get(Recursos.Recurso.MADEIRA);
		return ferro >= ferroNecessario && madeira >= madeiraNecessaria;
	}
}