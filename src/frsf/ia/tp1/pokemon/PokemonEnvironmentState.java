package frsf.ia.tp1.pokemon;

import java.util.ArrayList;
import java.util.HashMap;

import frsf.cidisi.faia.state.EnvironmentState;
import frsf.ia.tp1.pokemon.enemigos.*;

public class PokemonEnvironmentState extends EnvironmentState{

	private HashMap<Integer, Integer> mapaAmbiente;
	private HashMap<Integer, ArrayList<Integer>> mapaSucesoresAmbiente;
	private ArrayList<Enemigo> listaEnemigos;
	private EnemigoFinal jefeFinal;
	private HashMap<Integer, Integer> turnosRestantesParaReabastecerPokebolas;
	private Integer turnosRestantesParaUtilizarSatelite;
	
	public PokemonEnvironmentState() {
		
		this.mapaAmbiente = cargarMapaAmbiente();
		this.mapaSucesoresAmbiente = cargarMapaSucesoresAmbiente();
		this.listaEnemigos = cargarListaEnemigos();
		this.jefeFinal = new EnemigoFinal();
		this.turnosRestantesParaReabastecerPokebolas = cargarTurnosRestantesParaReabastecerPokebolas();
		this.turnosRestantesParaUtilizarSatelite = 0;
		
		
	}
	
	
	@Override
	public void initState() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private HashMap<Integer, Integer> cargarMapaAmbiente() {
		
		return null;
	}
	
	private HashMap<Integer, ArrayList<Integer>> cargarMapaSucesoresAmbiente() {
		return null;
	}
	
	private ArrayList<Enemigo> cargarListaEnemigos() {
		return null;
	}
	
	private HashMap<Integer, Integer> cargarTurnosRestantesParaReabastecerPokebolas() {
		return null;
	}

}
