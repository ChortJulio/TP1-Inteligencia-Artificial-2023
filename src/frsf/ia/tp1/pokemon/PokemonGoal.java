package frsf.ia.tp1.pokemon;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class PokemonGoal extends GoalTest{

    @Override
    public boolean isGoalState(AgentState agentState) {
        //if (((PacmanAgentState) agentState).isNoMoreFood() &&
        //        ((PacmanAgentState) agentState).isAllWorldKnown()) {
        //    return true;
        //}
        return false;
    }
}
