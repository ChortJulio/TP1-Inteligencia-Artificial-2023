package frsf.ia.tp1.pokemon;

import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

public class CostFunction implements IStepCostFunction {
	
	@Override
	public double calculateCost(NTree node) {
		PokemonAgentState pokemonState = (PokemonAgentState) node.getAgentState();
		
		return pokemonState.getCantidadMovimientosTotales() 
				+ (Const.cantidadEnemigos - pokemonState.getCantidadPokemonsAdversarios());
	}

}
