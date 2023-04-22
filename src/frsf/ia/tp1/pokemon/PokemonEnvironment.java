package frsf.ia.tp1.pokemon;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class PokemonEnvironment extends Environment{
	
	public PokemonEnvironment() {
		// Create the environment state
		this.environmentState = new PokemonEnvironmentState();
	}

	@Override
	public Perception getPercept() {
		// TODO Auto-generated method stub
		return null;
	}
	
    @Override
    public String toString() {
        return environmentState.toString();
    }

}
