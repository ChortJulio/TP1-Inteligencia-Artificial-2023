package frsf.ia.tp1.pokemon;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class PokemonEnvironment extends Environment{
	
	public PokemonEnvironment() {
		// Create the environment state
		this.environmentState = new PokemonEnvironmentState();
	}

	@Override
    public PokemonEnvironmentState getEnvironmentState() {
        return (PokemonEnvironmentState) super.getEnvironmentState();
    }
	
	@Override
	public Perception getPercept() {
		
		PokemonPerception perception = new PokemonPerception();
		
		perception.initPerception(this);
		
		return perception;
	}
	
    @Override
    public String toString() {
        return environmentState.toString();
    }
    
    @Override
    public boolean agentFailed(Action actionReturned) {

        PokemonEnvironmentState pokemonEnvironmentState = this.getEnvironmentState();

//        int agentEnergy = pokemonEnvironmentState.getAgentEnergy();
//
//        // FIXME: The pacman agent always has the same energy
//        // If the agent has no energy, he failed
//        if (agentEnergy <= 0)
//            return true;

        return false;
    }

}
