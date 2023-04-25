package frsf.ia.tp1.pokemon;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;
import frsf.ia.tp1.pokemon.enemigos.EnemigoFinal;

public class PokemonGoal extends GoalTest {

    @Override
    public boolean isGoalState(AgentState agentState) {
        PokemonAgentState estadoPokemon = (PokemonAgentState) agentState;
        PokemonEnvironmentState estadoAmbiente = new PokemonEnvironmentState();
        
        boolean cumplioMetaFinal = false;
        
        if(estadoPokemon.estaVivo() 
    		&& estadoPokemon.getNodoActual() == Const.nodoPosicionEnemigoFinal
    		&& estadoAmbiente.getJefeFinal().getEnergia() <= 0) {
        	cumplioMetaFinal = true;
        }
        
        return cumplioMetaFinal;
    }
}
