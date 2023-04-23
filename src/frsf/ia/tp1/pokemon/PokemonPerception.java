package frsf.ia.tp1.pokemon;

import java.util.HashMap;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
import frsf.ia.tp1.pokemon.enemigos.Enemigo;

public class PokemonPerception extends Perception {
	
    public static int NODO_VACIO_PERCEPTION = 0;
    public static int POKEBOLA_PERCEPTION = 2;
    public static int BOSS_FINAL_PERCEPTION = 3;
    
    // Que hay en el nodo actual
    private int contenidoNodoActual;
    private int energiaEnemigoEnNodoActual;
    
    // Que hay en los nodos sucesores
    private HashMap<Integer, Integer> contenidoNodosSucesores;
    private HashMap<Integer, Integer> mapaPorSatelite;
    private boolean puedeUsarSatelite;

	@Override
	public void initPerception(Agent agent, Environment environment) {

		PokemonEnvironment pokemonEnviroment = (PokemonEnvironment) environment;
		PokemonEnvironmentState environmentState = pokemonEnviroment.getEnvironmentState();
		
		// Devuelve 0 si es vacio, 1 si es enemigo, 2 si es punto de energia y 3 si es el boss final
		contenidoNodoActual = environmentState.getMapaAmbiente().get(environmentState.getPosicionAgente());
		
		for (Enemigo e : environmentState.getListaEnemigos()) {
			
		}
		
		energiaEnemigoEnNodoActual = environmentState.getListaEnemigos().get(environmentState.getPosicionAgente()).getEnergia();
		
	}

}
