package frsf.ia.tp1.pokemon.actions;

import java.util.stream.Collectors;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import frsf.ia.tp1.pokemon.Const;
import frsf.ia.tp1.pokemon.PokemonAgentState;
import frsf.ia.tp1.pokemon.PokemonEnvironmentState;
import frsf.ia.tp1.pokemon.ataquesEspeciales.AtaqueEspecial;
import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
public class UsarAtaqueEspecial extends SearchAction {
	
	private int numeroAtaque;
	
	public UsarAtaqueEspecial(int numeroAtaque) {
		this.numeroAtaque = numeroAtaque;
	}

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		PokemonAgentState pokemonState = (PokemonAgentState) s;
		
		int nodoActual = pokemonState.getNodoActual();
		
		AtaqueEspecial ataque = pokemonState.getAtaquesEspeciales().get(numeroAtaque);
		
		if (pokemonState.estaVivo() &&
			ataque.getTurnosRestantesParaUtilizar() == 0 &&
			pokemonState.getMapaAgente().get(nodoActual) == 1) {
			
			pokemonState.setEscudo((int) Math.floor(pokemonState.getEscudo() + pokemonState.getEnergia()*ataque.getPorcentajeRecuperacionEnergia()));
			
			ataque.usarAtaque();
			
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
		
		AtaqueEspecial ataque = pokemonState.getAtaquesEspeciales().get(numeroAtaque);
		
		if (pokemonState.estaVivo() &&
			ataque.getTurnosRestantesParaUtilizar() == 0 &&
			pokemonState.getMapaAgente().get(nodoActual) == 1) {
			
			pokemonState.setEscudo((int) Math.floor(pokemonState.getEscudo() + pokemonState.getEnergia()*ataque.getPorcentajeRecuperacionEnergia()));
			
			ataque.usarAtaque();
			
			
			return pokemonEnviromentState;
		}
		
		return null;
	}

}
