package frsf.ia.tp1.pokemon;

import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class PokemonSearchMain {

	public static void main(String[] args) {
		
		PokemonAgent pokemon = new PokemonAgent();
		
		PokemonEnvironment ambiente = new PokemonEnvironment();
		
		SearchBasedAgentSimulator simulador =
                new SearchBasedAgentSimulator(ambiente, pokemon);
        
		simulador.start();
	}

}
