package frsf.ia.tp1.pokemon.actions;

import java.util.HashMap;
import java.util.LinkedHashMap;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import frsf.ia.tp1.pokemon.Const;
import frsf.ia.tp1.pokemon.PokemonAgentState;
import frsf.ia.tp1.pokemon.PokemonEnvironmentState;
import frsf.ia.tp1.pokemon.ataquesEspeciales.AtaqueEspecial;
import frsf.ia.tp1.pokemon.enemigos.Enemigo;
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
		
		if (pokemonState.estaVivo() 
				&& pokemonState.getMapaSucesoresAgente().get(nodoActual).contains(this.nodo) 
				&& pokemonState.puedeMoverse(this.nodo)) {
			
			this.avanzarTurno(pokemonState);
			
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
		
		PokemonEnvironmentState pokemonEnvironmentState = (PokemonEnvironmentState) est;
		PokemonAgentState pokemonState = ((PokemonAgentState) ast);
		
		HashMap<Integer, Integer> mapaAImprimir = new LinkedHashMap<>();
		
		int nodoActualAgente = pokemonEnvironmentState.getPosicionAgente();
		
		if (pokemonState.estaVivo() && pokemonEnvironmentState.getMapaSucesoresAmbiente().get(nodoActualAgente).contains(this.nodo) 
				&& pokemonState.puedeMoverse(this.nodo)) {
			pokemonEnvironmentState.setPosicionAgente(this.nodo);
			
			this.avanzarTurno(pokemonState, pokemonEnvironmentState);	
			
			for (Integer nodo : pokemonEnvironmentState.getMapaAmbiente().keySet()) {
				mapaAImprimir.put(nodo, pokemonEnvironmentState.getMapaAmbiente().get(nodo));
			}
			
			for (Enemigo e : pokemonEnvironmentState.getListaEnemigos()) {
				mapaAImprimir.put(e.getNodo(), 1);
			}
			
			Const.imprimirMapaActual("mover a nodo", mapaAImprimir, this.nodo);
			
			return pokemonEnvironmentState;
		}
		
		return null;
	}
	
	private void avanzarTurno(PokemonAgentState pokemonState, PokemonEnvironmentState pokemonEnviromentState) {
//		// Actualizar agente
		this.avanzarTurno(pokemonState);
		
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
	
	private void avanzarTurno(PokemonAgentState pokemonState) {
		// Actualizar agente
		pokemonState.setNodoActual(this.nodo);
		pokemonState.setEscapo(false);
		pokemonState.setEscudo(0);
		
		// Actualizar ataques especiales
		for(AtaqueEspecial ae : pokemonState.getAtaquesEspeciales()) {
			ae.restarUnTurnoParaUtilizar();
		}
		
		// Actualiza cantidad de movimientos realizados
		pokemonState.setCantidadMovimientosTotales(pokemonState.getCantidadMovimientosTotales()+1);
		
		pokemonState.getVisitasAlNodo().put(this.nodo, pokemonState.getVisitasAlNodo().get(this.nodo) + 1);
	}

}
