package br.com.cbm.conquistadores.reino.domain.usecases;

import java.util.Map;

import br.com.cbm.conquistadores.reino.app.ui.InterfaceDeUsuarioFacade;
import br.com.cbm.conquistadores.reino.domain.entities.Exercito;
import br.com.cbm.conquistadores.reino.domain.entities.Recursos;

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
//    	Map<Recursos.Recurso, Integer> orcamento = Map.of(Recursos.Recurso.FERRO, 10, Recursos.Recurso.OURO, 10);
//    	interfaceDeUsuario.exibirCustoConstrucaoEdificacoes(edificacoes, recursos, orcamento);
//    	if (interfaceDeUsuario.confirmaAcao() && isRecursosSuficientes(recursos, orcamento)) {
//    		recursos.consumirRecursos(orcamento);
//    		edificacoes.construir();
//    		interfaceDeUsuario.imprimeTexto("Edificacoes construidas com sucesso!");
//    	} else {
//    		interfaceDeUsuario.imprimeTexto("Recursos insuficientes para construir edificacoes!");
//    	}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
//    	if (recursos.consumirRecursos(madeiraNecessaria, ferroNecessario)) {
    	if (recursos.consumirRecursos(10, 10)) {
            exercito.treinarTropas();
            System.out.println("Tropas treinadas com sucesso!");
        } else {
            System.out.println("Recursos insuficientes para treinar tropas!");
        }
    }
}