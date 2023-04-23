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
		
		HashMap<Integer, Integer> mapaAmbienteInicial = new HashMap<>();

		mapaAmbienteInicial.put(1, 0);
		mapaAmbienteInicial.put(2, 0);
		mapaAmbienteInicial.put(3, 0);
		mapaAmbienteInicial.put(4, 0);
		mapaAmbienteInicial.put(5, 0);
		mapaAmbienteInicial.put(6, 2);
		mapaAmbienteInicial.put(7, 0);
		mapaAmbienteInicial.put(8, 0);
		mapaAmbienteInicial.put(9, 0);
		mapaAmbienteInicial.put(10, 0);
		mapaAmbienteInicial.put(11, 2);
		mapaAmbienteInicial.put(12, 0);
		mapaAmbienteInicial.put(13, 0);
		mapaAmbienteInicial.put(14, 2);
		mapaAmbienteInicial.put(15, 0);
		mapaAmbienteInicial.put(16, 0);
		mapaAmbienteInicial.put(17, 0);
		mapaAmbienteInicial.put(18, 0);
		mapaAmbienteInicial.put(19, 0);
		mapaAmbienteInicial.put(20, 0);
		mapaAmbienteInicial.put(21, 0);
		mapaAmbienteInicial.put(22, 0);
		mapaAmbienteInicial.put(23, 2);
		mapaAmbienteInicial.put(24, 0);
		mapaAmbienteInicial.put(25, 0);
		mapaAmbienteInicial.put(26, 0);
		mapaAmbienteInicial.put(27, 0);
		mapaAmbienteInicial.put(28, 0);
		mapaAmbienteInicial.put(29, 0);
		
		return mapaAmbienteInicial;
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
