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
		
		if (pokemonState.estaVivo() && pokemonState.getMapaSucesoresAgente().get(nodoActual).contains(this.nodo) && pokemonState.puedeMoverse(this.nodo)) {
			
//			System.out.println("Estado al mover: " + pokemonState);
			
			pokemonState.setNodoActual(this.nodo);
			pokemonState.setEscapo(false);
			pokemonState.setEscudo(0);
			
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
		
		//System.out.println("Mover a nodo - Este es el metodo execute que cambia el ambiente");
		
		PokemonEnvironmentState pokemonEnvironmentState = (PokemonEnvironmentState) est;
		PokemonAgentState pokemonState = ((PokemonAgentState) ast);
		
		int nodoActualAgente = pokemonEnvironmentState.getPosicionAgente();
		
		if (pokemonState.estaVivo() && pokemonEnvironmentState.getMapaSucesoresAmbiente().get(nodoActualAgente).contains(this.nodo) 
				&& pokemonState.puedeMoverse(this.nodo)) {
			pokemonEnvironmentState.setPosicionAgente(this.nodo);
			
//			System.out.println("Estado al mover: " + pokemonState);
			
			this.avanzarTurno(pokemonState, pokemonEnvironmentState);			
			Const.imprimirMapaActual("mover a nodo", pokemonEnvironmentState.getMapaAmbiente(), this.nodo);
			
			return pokemonEnvironmentState;
		}
		
		return null;
	}
	
	private void avanzarTurno(PokemonAgentState pokemonState, PokemonEnvironmentState pokemonEnviromentState) {
		
		// Actualizar agente
		pokemonState.setNodoActual(this.nodo);
		pokemonState.setEscapo(false);
		pokemonState.setEscudo(0);
		
		// Actualiza cantidad de movimientos realizados
		pokemonState.setCantidadMovimientosTotales(pokemonState.getCantidadMovimientosTotales()+1);
		
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
