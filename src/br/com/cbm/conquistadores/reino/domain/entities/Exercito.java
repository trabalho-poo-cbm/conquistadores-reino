package br.com.cbm.conquistadores.reino.domain.entities;

public class Exercito {

    private int tropasTreinadas;
    private Recursos recursos;

    // TODO: Receber quantidade inicial do construtor
    public Exercito(Recursos recursos) {

    	
    	this.tropasTreinadas = 0;
    }

    public Exercito(int arqueiro, int cavaleiro, int tanque) {
    	// arqueiro, cavaleiro, tanque
		// TODO Auto-generated constructor stub
	}

	public int getTropasTreinadas() {
        return tropasTreinadas;
    }

    public void setTropasTreinadas(int tropasTreinadas) {
        this.tropasTreinadas = tropasTreinadas;
    }

    public void treinarTropas(int madeiraNecessaria, int ferroNecessario) {
        if (recursos.consumirRecursos(madeiraNecessaria, ferroNecessario)) {
            tropasTreinadas++;
            System.out.println("Tropas treinadas: " + tropasTreinadas);
        } else {
            System.out.println("Recursos insuficientes para treinar tropas!");
        }
    }
    
    // TODO: Ajustar formatação texto
    @Override
    public String toString() {
    	return "\nTropas treinadas: " + tropasTreinadas;
    }
}