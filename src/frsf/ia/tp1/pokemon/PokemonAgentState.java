package frsf.ia.tp1.pokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.ia.tp1.pokemon.enemigos.Enemigo;
import frsf.ia.tp1.pokemon.enemigos.EnemigoFinal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonAgentState extends SearchBasedAgentState {
	
	private int nodoActual;
	private LinkedHashMap<Integer, Integer> mapaAgente;
	private HashMap<Integer, ArrayList<Integer>> mapaSucesoresAgente;
	private int energiaInicial;
	private int energia;
	private int energiaEnemigo;
	private ArrayList<Integer> turnosRestantesParaUtilizarAtaquesEspeciales;
	private int escudo;
	private boolean escapo;
	private int cantidadPokemonsAdversarios;
	
	public PokemonAgentState() {
		
		this.initState();
	}
	
	@Override
	public void initState() {
		
		this.nodoActual = 1;
		this.mapaAgente = cargarMapaAgente();
		this.mapaSucesoresAgente = cargarMapaSucesoresAgente();
		this.energiaInicial = Const.energiaInicialAgente;
		this.energia = energiaInicial;
		this.energiaEnemigo = 0; //VER
		this.turnosRestantesParaUtilizarAtaquesEspeciales = cargarTurnosRestantesParaUtilizarAtaquesEspeciales();
		this.escudo = 0;
		this.escapo = false;
		this.cantidadPokemonsAdversarios = 10;
	}
	
	public boolean estaVivo() {
		return (this.energia > 0);
	}
	
	private LinkedHashMap<Integer, Integer> cargarMapaAgente() {
		return null;
	}
	
	private HashMap<Integer, ArrayList<Integer>> cargarMapaSucesoresAgente() {
		return null;
	}
	
	private ArrayList<Integer> cargarTurnosRestantesParaUtilizarAtaquesEspeciales() {
		return null;
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SearchBasedAgentState clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateState(Perception p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}



}
