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
public class MoverANodo extends SearchAction {
	
	private int nodo;
	
	public MoverANodo(int nodo) {
		this.nodo = nodo;
	}

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		PokemonAgentState pokemonState = (PokemonAgentState) s;
		
		int nodoActual = pokemonState.getNodoActual();
		
		if (pokemonState.estaVivo() && pokemonState.getMapaSucesoresAgente().get(nodoActual).contains(this.nodo) 
				&& pokemonState.puedeMoverse()) {
			System.out.println(" ------------ Mover a nodo --------------");
			System.out.println("Mover a nodo - Nodo actual: " + nodoActual);
			
			pokemonState.setNodoActual(this.nodo);
			pokemonState.setEscapo(false);
			pokemonState.setEscudo(0);
			
			System.out.println("Mover a nodo - Nodo al que se movio: " + this.nodo);
			System.out.println("Mover a nodo - Mapa agente: " + pokemonState.getMapaAgente());
			
			
			
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
		
		System.out.println("Mover a nodo - Este es el metodo execute que cambia el ambiente");
		
		PokemonEnvironmentState pokemonEnviromentState = (PokemonEnvironmentState) est;
		PokemonAgentState pokemonState = ((PokemonAgentState) ast);
		
		int nodoActualAgente = pokemonEnviromentState.getPosicionAgente();
		
		if (pokemonState.estaVivo() && pokemonEnviromentState.getMapaSucesoresAmbiente().get(nodoActualAgente).contains(this.nodo) 
				&& pokemonState.puedeMoverse()) {
			pokemonEnviromentState.setPosicionAgente(this.nodo);
			
			this.avanzarTurno(pokemonState, pokemonEnviromentState);
			
			return pokemonEnviromentState;
		}
		
		return null;
	}
	
	private void avanzarTurno(PokemonAgentState pokemonState, PokemonEnvironmentState pokemonEnviromentState) {
		
		// Actualizar Pokeparadas
		for (Pokeparada pokeparada: pokemonEnviromentState.getListaPokeparadas()) {
			
			if (pokeparada.getTurnosParaRestablecerse() == 0) {
				pokemonEnviromentState.getMapaAmbiente().put(pokeparada.getNodo(), 2);
				pokeparada.setTurnosParaRestablecerse(Const.turnosMaximosParaReabastecerPokebolas);
			} else {
				pokeparada.restarTurnoParaRestablerse();
			}
		}
		
		// Actualizar enemigos
		pokemonEnviromentState.moverEnemigos();
		
		// Actualizar turnos para utilizar satelite
		if (pokemonEnviromentState.getTurnosRestantesParaUtilizarSatelite() == 0) {
			pokemonEnviromentState.setTurnosRestantesParaUtilizarSatelite(Const.cantidadTurnosParaUtilizarSatelite);
		} else {
			pokemonEnviromentState.setTurnosRestantesParaUtilizarSatelite(pokemonEnviromentState.getTurnosRestantesParaUtilizarSatelite() - 1);
		}
	}

}
