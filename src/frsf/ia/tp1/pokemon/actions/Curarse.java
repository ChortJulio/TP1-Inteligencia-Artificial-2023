package frsf.ia.tp1.pokemon.actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import frsf.ia.tp1.pokemon.Const;
import frsf.ia.tp1.pokemon.PokemonAgentState;
import frsf.ia.tp1.pokemon.PokemonEnvironmentState;
import frsf.ia.tp1.pokemon.pokeparadas.Pokeparada;
import lombok.ToString;

@ToString
public class Curarse extends SearchAction {

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		PokemonAgentState pokemonState = (PokemonAgentState) s;
		
		int nodoActual = pokemonState.getNodoActual();
		
		if (pokemonState.estaVivo() && pokemonState.getMapaAgente().get(nodoActual) == 2) {
			pokemonState.recargarEnergia(Const.randomBetween(Const.energiaMaximaRecargable, Const.energiaMinimaRecargable));
			pokemonState.getMapaAgente().put(nodoActual, 0);
			
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
		
		int nodoActualAgente = pokemonEnviromentState.getPosicionAgente();
		
		if (pokemonState.estaVivo() && pokemonEnviromentState.getMapaAmbiente().get(nodoActualAgente) == 2) {
			pokemonEnviromentState.getMapaAmbiente().put(nodoActualAgente, 0);
			
			for (Pokeparada pokeparada : pokemonEnviromentState.getListaPokeparadas()) {
				if (pokeparada.getNodo() == nodoActualAgente) {
					pokeparada.setTurnosParaRestablecerse(Const.turnosMaximosParaReabastecerPokebolas);
					break;
				}
			}
			
			
			return pokemonEnviromentState;
		}
		return null;
	}

}
