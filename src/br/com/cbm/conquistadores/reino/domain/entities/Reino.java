package br.com.cbm.conquistadores.reino.domain.entities;

import java.util.Map;

public class Reino {

	private String nome;
	private Rei rei;
	private Exercito exercito;
	private Map<Recurso, Integer> recursos;
}