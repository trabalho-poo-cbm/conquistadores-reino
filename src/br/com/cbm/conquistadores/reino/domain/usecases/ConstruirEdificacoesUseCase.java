package br.com.cbm.conquistadores.reino.domain.usecases;

import java.util.Map;

import br.com.cbm.conquistadores.reino.app.ui.InterfaceDeUsuarioFacade;
import br.com.cbm.conquistadores.reino.domain.entities.Edificacoes;
import br.com.cbm.conquistadores.reino.domain.entities.Recursos;
import br.com.cbm.conquistadores.reino.domain.entities.Recursos.Recurso;

public class ConstruirEdificacoesUseCase {

    private final Edificacoes edificacoes;
    private final Recursos recursos;
	private final InterfaceDeUsuarioFacade interfaceDeUsuario;

    public ConstruirEdificacoesUseCase(Edificacoes edificacoes, Recursos recursos,
    		InterfaceDeUsuarioFacade interfaceDeUsuario) {
        this.edificacoes = edificacoes;
        this.recursos = recursos;
		this.interfaceDeUsuario = interfaceDeUsuario;
    }

    public void construirEdificacao() {
    	Map<Recursos.Recurso, Integer> orcamento = Map.of(Recursos.Recurso.FERRO, 10, Recursos.Recurso.OURO, 10);
    	interfaceDeUsuario.exibirCustoConstrucaoEdificacoes(edificacoes, recursos, orcamento);
    	if (interfaceDeUsuario.confirmaAcao() && isRecursosSuficientes(recursos, orcamento)) {
    		recursos.consumirRecursos(orcamento);
    		edificacoes.construir();
    		interfaceDeUsuario.exibirTexto("Edificacoes construidas com sucesso!");
    	} else {
    		interfaceDeUsuario.exibirTexto("Recursos insuficientes para construir edificacoes!");
    	}
    }

	private boolean isRecursosSuficientes(Recursos recursos, Map<Recurso, Integer> orcamento) {
		int ferro = recursos.getRecursos().getOrDefault(Recurso.FERRO, 0);
		int ouro = recursos.getRecursos().getOrDefault(Recurso.OURO, 0);
		int ferroNecessario = orcamento.get(Recursos.Recurso.FERRO);
		int ouroNecessario = orcamento.get(Recursos.Recurso.OURO);
		return ferro >= ferroNecessario && ouro >= ouroNecessario;
	}
}