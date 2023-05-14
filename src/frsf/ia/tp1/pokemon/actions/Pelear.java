package frsf.ia.tp1.pokemon.actions;

import java.util.stream.Collectors;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import frsf.ia.tp1.pokemon.PokemonAgentState;
import frsf.ia.tp1.pokemon.PokemonEnvironmentState;
import lombok.ToString;

@ToString
public class Pelear extends SearchAction {

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		PokemonAgentState pokemonState = (PokemonAgentState) s;
		
		int nodoActual = pokemonState.getNodoActual();
		
		int energiaEnemigo;
		
		if ( pokemonState.estaVivo() && 
			(pokemonState.getMapaAgente().get(nodoActual) == 1 || pokemonState.getMapaAgente().get(nodoActual) == 3) &&
			 !pokemonState.escapo()) {
			
			//System.out.println("--------- Pelear --------- ");
			//System.out.println(pokemonState);
			
		
			if (pokemonState.getMapaAgente().get(nodoActual) == 3) energiaEnemigo = pokemonState.getEnergiaEnemigoFinal();
			else energiaEnemigo = pokemonState.getEnergiaEnemigo();
			
			if (pokemonState.getEscudo() < energiaEnemigo) {
				pokemonState.setEnergia(pokemonState.getEnergia() - (energiaEnemigo - pokemonState.getEscudo()));
			}
			
			pokemonState.setEscudo(0);
			
			if (pokemonState.estaVivo()) {
				pokemonState.getMapaAgente().put(nodoActual, 0);
				pokemonState.recargarEnergia((int) Math.floor(pokemonState.getEnergiaEnemigo() * 0.2));
			}
			
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
		
		if ( pokemonState.estaVivo() && !pokemonState.escapo()) {
			
			//System.out.println("Pelear dentro del execute del ambiente");
			
			if (pokemonState.getEscudo() < pokemonState.getEnergiaEnemigo()) {
				pokemonState.setEnergia(pokemonState.getEnergia() - (pokemonState.getEnergiaEnemigo() - pokemonState.getEscudo()));
			}
			
			if (pokemonState.getMapaAgente().get(nodoActual) == 1) {
				// Eliminar enemigo de la lista de enemigos del ambiente
				pokemonEnviromentState.setListaEnemigos(
						pokemonEnviromentState.getListaEnemigos().stream()
						.filter(e -> e.getNodo() == nodoActual )
						.collect(Collectors.toList()));
			}
			
			if (pokemonState.getMapaAgente().get(nodoActual) == 3) {
				pokemonEnviromentState.getJefeFinal().setEnergia(0);
				pokemonEnviromentState.getMapaAmbiente().put(pokemonEnviromentState.getPosicionAgente(), 0);
			}
			
			pokemonState.setEscudo(0);
			
			if (pokemonState.estaVivo()) {
				pokemonState.getMapaAgente().put(nodoActual, 0);
				pokemonState.recargarEnergia((int) Math.floor(pokemonState.getEnergiaEnemigo() * 0.2));
			}
			
			return pokemonEnviromentState;
		}
		
		return null;
	}

}
