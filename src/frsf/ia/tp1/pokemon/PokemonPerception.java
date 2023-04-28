package frsf.ia.tp1.pokemon;

import java.util.HashMap;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
import frsf.ia.tp1.pokemon.enemigos.Enemigo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PokemonPerception extends Perception {
    
    // Que hay en el nodo actual
    private int contenidoNodoActual;
    private int energiaEnemigoEnNodoActual;
    
    // Que hay en los nodos sucesores
    private HashMap<Integer, Integer> contenidoNodosSucesores;
    private HashMap<Integer, Integer> mapaPorSatelite;
    private boolean puedeUsarSatelite;
    
    public PokemonPerception() {
    	
    }
    
    public PokemonPerception(Agent agent, Environment environment) {
    	super(agent, environment);
    }

	@Override
	public void initPerception(Agent agent, Environment environment) {

		PokemonEnvironment pokemonEnviroment = (PokemonEnvironment) environment;
		PokemonEnvironmentState environmentState = pokemonEnviroment.getEnvironmentState();
		
		// Contiene 0 si es vacio, 2 si es punto de energia y 3 si es el boss final
		contenidoNodoActual = environmentState.getMapaAmbiente().get(environmentState.getPosicionAgente());
		energiaEnemigoEnNodoActual = 0;
		contenidoNodosSucesores = new HashMap<>();
		mapaPorSatelite = new HashMap<>();
		
		/* 
		 * 	Por cada sucesor, se lo carga en el mapa contenidoNodosSucesores y se carga su respectivo
		 *	estado que figura en el mapa 
		 */
		for (Integer nodo : environmentState.getMapaSucesoresAmbiente().get(environmentState.getPosicionAgente())) {
			contenidoNodosSucesores.put(nodo, environmentState.getMapaAmbiente().get(nodo));
		}
		
		// Si se tiene el satelite, se setea la bandera para que lo sepa el agente
		if (environmentState.getTurnosRestantesParaUtilizarSatelite() == 0) {
			puedeUsarSatelite = true;
			mapaPorSatelite = (HashMap<Integer, Integer>) environmentState.getMapaSucesoresAmbiente().clone();
		}
		
		/*
		 * Por cada enemigo:
		 */
		for (Enemigo e : environmentState.getListaEnemigos()) {
			// Si hay un enemigo en el nodo del agente, se le pasa la energia del mismo
			if (e.getNodo() == environmentState.getPosicionAgente()) {
				contenidoNodoActual = 1;
				energiaEnemigoEnNodoActual = e.getEnergia();
			}
			
			// Si hay un enemigo en un sucesor, se agrega esta informacion a contenidoNodosSucesores
			if (contenidoNodosSucesores.keySet().contains(e.getNodo()))	{
				contenidoNodosSucesores.put(e.getNodo(), 1);
			}
			
			// Si se tiene que pasar el satelite, se agrega la informacion de que hay un enemigo al mapa
			if (puedeUsarSatelite) mapaPorSatelite.put(e.getNodo(), 1);
		}
		
		// Si el agente esta en el nodo del jefe final, se le pasa la energia del jefe
		if (environmentState.getPosicionAgente() == environmentState.getJefeFinal().getNodo()) {
			energiaEnemigoEnNodoActual = environmentState.getJefeFinal().getEnergia();
		}
	}

}
