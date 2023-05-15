package frsf.ia.tp1.pokemon.actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import frsf.ia.tp1.pokemon.PokemonAgentState;
import frsf.ia.tp1.pokemon.PokemonEnvironmentState;
import lombok.ToString;

@ToString
public class Escapar extends SearchAction {

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		PokemonAgentState pokemonState = (PokemonAgentState) s;
		
		int nodoActual = pokemonState.getNodoActual();
		
		if (pokemonState.estaVivo() && 
			(pokemonState.getMapaAgente().get(nodoActual) == 1 || pokemonState.getMapaAgente().get(nodoActual) == 3) &&
			!pokemonState.escapo()) {
			
			pokemonState.setEnergia(pokemonState.getEnergia() - pokemonState.getEnergiaEnemigo() / 4);
			pokemonState.setEscapo(true);
			
			return pokemonState;
		}
		return null;
	}

	@Override
	public Double getCost() {
		// TODO Auto-generated method stub
		return 0.0;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		PokemonEnvironmentState pokemonEnviromentState = (PokemonEnvironmentState) est;
		PokemonAgentState pokemonState = ((PokemonAgentState) ast);
		
		int nodoActual = pokemonEnviromentState.getPosicionAgente();
		
		// No pasa nada
		if (pokemonState.estaVivo() && 
			(pokemonState.getMapaAgente().get(nodoActual) == 1 || pokemonState.getMapaAgente().get(nodoActual) == 3) &&
			!pokemonState.escapo()) {
			
			pokemonState.setEnergia(pokemonState.getEnergia() - pokemonState.getEnergiaEnemigo() / 4);
			pokemonState.setEscapo(true);
				
			return pokemonEnviromentState;
		}
		
		return null;
	}

}
