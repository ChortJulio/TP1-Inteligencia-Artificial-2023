package frsf.ia.tp1.pokemon;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class PokemonEnvironment extends Environment{
	
	public PokemonEnvironment() {
		// Create the environment state
		PokemonEnvironmentState enviroment = new PokemonEnvironmentState();
		this.environmentState = enviroment;
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


        return false;
    }

}
