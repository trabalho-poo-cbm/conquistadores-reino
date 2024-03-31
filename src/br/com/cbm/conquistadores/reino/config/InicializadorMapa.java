package br.com.cbm.conquistadores.reino.config;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import br.com.cbm.conquistadores.reino.domain.entities.Edificacoes;
import br.com.cbm.conquistadores.reino.domain.entities.Exercito;
import br.com.cbm.conquistadores.reino.domain.entities.Recursos;
import br.com.cbm.conquistadores.reino.domain.entities.Reino;

public class InicializadorMapa {

    private static final List<String> nomesReinos = Arrays.asList(
            "Valhalla", "Avalon", "Midgard", "Eldorado", "Atlantis", "Camelot", "Olympus"
    );

    private static final List<String> nomesReis = Arrays.asList(
            "Avelinno", "Uther", "Merlin", "Guinevere", "Lancelot", "Morgana", "Galahad"
    );

    public static Map<Integer, Reino> inicializar() {
        Map<Integer, Reino> reinos = new ConcurrentHashMap<>();
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            String nomeReino = nomesReinos.get(i);
            String nomeRei = nomesReis.get(i);
            Recursos recursos = new Recursos(random.nextInt(16) + 10, random.nextInt(16) + 10, random.nextInt(16) + 10);
            Exercito exercito = new Exercito(random.nextInt(16) + 10, random.nextInt(16) + 10, random.nextInt(16) + 10);
            Edificacoes edificacoes = new Edificacoes(random.nextInt(16) + 10, random.nextInt(16) + 10, random.nextInt(16) + 10);
            Reino reino = new Reino(nomeReino, nomeRei, recursos, exercito, edificacoes);
            reinos.put(i + 1, reino);
        }
        return reinos;
    }
}