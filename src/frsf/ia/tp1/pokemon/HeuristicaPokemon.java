package frsf.ia.tp1.pokemon;

import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

public class HeuristicaPokemon implements IEstimatedCostFunction {
	
	@Override
    public double getEstimatedCost(NTree node) {
        PokemonAgentState pokemonState = (PokemonAgentState) node.getAgentState();

        return 1;
    }

}
