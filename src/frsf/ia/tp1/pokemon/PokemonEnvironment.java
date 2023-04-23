package frsf.ia.tp1.pokemon;

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
		
		return perception;
	}
	
    @Override
    public String toString() {
        return environmentState.toString();
    }

}
