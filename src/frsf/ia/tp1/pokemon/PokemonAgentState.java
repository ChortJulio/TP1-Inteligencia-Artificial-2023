package frsf.ia.tp1.pokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.ia.tp1.pokemon.enemigos.Enemigo;
import frsf.ia.tp1.pokemon.enemigos.EnemigoFinal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class PokemonAgentState extends SearchBasedAgentState {
	
	private int nodoActual;
	private HashMap<Integer, Integer> mapaAgente;
	private HashMap<Integer, ArrayList<Integer>> mapaSucesoresAgente;
	private int energiaInicial;
	private int energia;
	private int energiaEnemigo;
	private List<Integer> turnosRestantesParaUtilizarAtaquesEspeciales;
	private int escudo;
	private boolean escapo;
	private int cantidadPokemonsAdversarios;
	
	public PokemonAgentState() {
		
		this.initState();
	}
	
	public boolean escapo() {
		return this.escapo;
	}
	
	@Override
	public void initState() {
		
		this.nodoActual = Const.nodoInicialAgente;
		this.mapaAgente = cargarMapaAgente();
		this.mapaSucesoresAgente = cargarMapaSucesoresAgente();
		this.energiaInicial = Const.energiaInicialAgente;
		this.energia = energiaInicial;
		this.energiaEnemigo = 0; //VER
		this.turnosRestantesParaUtilizarAtaquesEspeciales = cargarTurnosRestantesParaUtilizarAtaquesEspeciales();
		this.escudo = 0;
		this.escapo = false;
		this.cantidadPokemonsAdversarios = Const.cantidadEnemigos;
	}
	
	public boolean estaVivo() {
		return (this.energia > 0);
	}
	
	public void recargarEnergia(int cantidadEnergia) {
		
		this.energia += cantidadEnergia;
		
		if(this.energia >= this.energiaInicial*1.25 && this.turnosRestantesParaUtilizarAtaquesEspeciales.get(0) == -1) {
			this.turnosRestantesParaUtilizarAtaquesEspeciales.add(0, 0);
		}
		
		if(this.energia >= this.energiaInicial*1.75 && this.turnosRestantesParaUtilizarAtaquesEspeciales.get(1) == -1) {
			this.turnosRestantesParaUtilizarAtaquesEspeciales.add(1, 0);
		}
		
		if(this.energia >= this.energiaInicial*2.2 && this.turnosRestantesParaUtilizarAtaquesEspeciales.get(2) == -1) {
			this.turnosRestantesParaUtilizarAtaquesEspeciales.add(2, 0);
		}
	}
	
	public boolean puedeMoverse() {
		
		boolean puedeMoverse = false;
		
		if(this.mapaAgente.get(nodoActual) == 0 || this.escapo) {
			puedeMoverse = true;
		}
		
		return puedeMoverse;
	}
	
	private LinkedHashMap<Integer, Integer> cargarMapaAgente() {

		LinkedHashMap<Integer, Integer> mapaAgenteInicial = new LinkedHashMap<>();
		
		for (int i = 1; i <= Const.cantidadNodos; i++) {
			mapaAgenteInicial.put(i, 0);
		}
		
		mapaAgenteInicial.put(Const.nodoPosicionEnemigoFinal, 3);

//		mapaAgenteInicial.put(1, Const.contenidoInicialNodo1);
//		mapaAgenteInicial.put(2, Const.contenidoInicialNodo2);
//		mapaAgenteInicial.put(3, Const.contenidoInicialNodo3);
//		mapaAgenteInicial.put(4, Const.contenidoInicialNodo4);
//		mapaAgenteInicial.put(5, Const.contenidoInicialNodo5);
//		mapaAgenteInicial.put(6, Const.contenidoInicialNodo6);
//		mapaAgenteInicial.put(7, Const.contenidoInicialNodo7);
//		mapaAgenteInicial.put(8, Const.contenidoInicialNodo8);
//		mapaAgenteInicial.put(9, Const.contenidoInicialNodo9);
//		mapaAgenteInicial.put(10, Const.contenidoInicialNodo10);
//		mapaAgenteInicial.put(11, Const.contenidoInicialNodo11);
//		mapaAgenteInicial.put(12, Const.contenidoInicialNodo12);
//		mapaAgenteInicial.put(13, Const.contenidoInicialNodo13);
//		mapaAgenteInicial.put(14, Const.contenidoInicialNodo14);
//		mapaAgenteInicial.put(15, Const.contenidoInicialNodo15);
//		mapaAgenteInicial.put(16, Const.contenidoInicialNodo16);
//		mapaAgenteInicial.put(17, Const.contenidoInicialNodo17);
//		mapaAgenteInicial.put(18, Const.contenidoInicialNodo18);
//		mapaAgenteInicial.put(19, Const.contenidoInicialNodo19);
//		mapaAgenteInicial.put(20, Const.contenidoInicialNodo20);
//		mapaAgenteInicial.put(21, Const.contenidoInicialNodo21);
//		mapaAgenteInicial.put(22, Const.contenidoInicialNodo22);
//		mapaAgenteInicial.put(23, Const.contenidoInicialNodo23);
//		mapaAgenteInicial.put(24, Const.contenidoInicialNodo24);
//		mapaAgenteInicial.put(25, Const.contenidoInicialNodo25);
//		mapaAgenteInicial.put(26, Const.contenidoInicialNodo26);
//		mapaAgenteInicial.put(27, Const.contenidoInicialNodo27);
//		mapaAgenteInicial.put(28, Const.contenidoInicialNodo28);
//		mapaAgenteInicial.put(29, Const.contenidoInicialNodo29);
		
		return mapaAgenteInicial;
	}
	
	private HashMap<Integer, ArrayList<Integer>> cargarMapaSucesoresAgente() {
		
		HashMap<Integer, ArrayList<Integer>> mapaSucesoresAgenteInicial = new HashMap<>();
		
		mapaSucesoresAgenteInicial.put(1, Const.sucesoresNodo1);
		mapaSucesoresAgenteInicial.put(2, Const.sucesoresNodo2);
		mapaSucesoresAgenteInicial.put(3, Const.sucesoresNodo3);
		mapaSucesoresAgenteInicial.put(4, Const.sucesoresNodo4);
		mapaSucesoresAgenteInicial.put(5, Const.sucesoresNodo5);
		mapaSucesoresAgenteInicial.put(6, Const.sucesoresNodo6);
		mapaSucesoresAgenteInicial.put(7, Const.sucesoresNodo7);
		mapaSucesoresAgenteInicial.put(8, Const.sucesoresNodo8);
		mapaSucesoresAgenteInicial.put(9, Const.sucesoresNodo9);
		mapaSucesoresAgenteInicial.put(10, Const.sucesoresNodo10);
		mapaSucesoresAgenteInicial.put(11, Const.sucesoresNodo11);
		mapaSucesoresAgenteInicial.put(12, Const.sucesoresNodo12);
		mapaSucesoresAgenteInicial.put(13, Const.sucesoresNodo13);
		mapaSucesoresAgenteInicial.put(14, Const.sucesoresNodo14);
		mapaSucesoresAgenteInicial.put(15, Const.sucesoresNodo15);
		mapaSucesoresAgenteInicial.put(16, Const.sucesoresNodo16);
		mapaSucesoresAgenteInicial.put(17, Const.sucesoresNodo17);
		mapaSucesoresAgenteInicial.put(18, Const.sucesoresNodo18);
		mapaSucesoresAgenteInicial.put(19, Const.sucesoresNodo19);
		mapaSucesoresAgenteInicial.put(20, Const.sucesoresNodo20);
		mapaSucesoresAgenteInicial.put(21, Const.sucesoresNodo21);
		mapaSucesoresAgenteInicial.put(22, Const.sucesoresNodo22);
		mapaSucesoresAgenteInicial.put(23, Const.sucesoresNodo23);
		mapaSucesoresAgenteInicial.put(24, Const.sucesoresNodo24);
		mapaSucesoresAgenteInicial.put(25, Const.sucesoresNodo25);
		mapaSucesoresAgenteInicial.put(26, Const.sucesoresNodo26);
		mapaSucesoresAgenteInicial.put(27, Const.sucesoresNodo27);
		mapaSucesoresAgenteInicial.put(28, Const.sucesoresNodo28);
		mapaSucesoresAgenteInicial.put(29, Const.sucesoresNodo29);
		
		return mapaSucesoresAgenteInicial;
	}
	
	private ArrayList<Integer> cargarTurnosRestantesParaUtilizarAtaquesEspeciales() {
		
		ArrayList<Integer> turnosRestantesParaUtilizarAtaquesEspecialInicial = new ArrayList<>();
		
		turnosRestantesParaUtilizarAtaquesEspecialInicial.add(0, -1);
		turnosRestantesParaUtilizarAtaquesEspecialInicial.add(1, -1);
		turnosRestantesParaUtilizarAtaquesEspecialInicial.add(2, -1);
		
		return turnosRestantesParaUtilizarAtaquesEspecialInicial;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PokemonAgentState other = (PokemonAgentState) obj;
		return cantidadPokemonsAdversarios == other.cantidadPokemonsAdversarios && energia == other.energia
				&& energiaEnemigo == other.energiaEnemigo && energiaInicial == other.energiaInicial
				&& escapo == other.escapo && escudo == other.escudo && Objects.equals(mapaAgente, other.mapaAgente)
				&& Objects.equals(mapaSucesoresAgente, other.mapaSucesoresAgente) && nodoActual == other.nodoActual
				&& Objects.equals(turnosRestantesParaUtilizarAtaquesEspeciales,
						other.turnosRestantesParaUtilizarAtaquesEspeciales);
	}

	@SuppressWarnings("unchecked")
	@Override
	public SearchBasedAgentState clone() {
		
		PokemonAgentState newState = new PokemonAgentState(
												this.nodoActual,
												(HashMap<Integer, Integer>) this.mapaAgente.clone(),
												(HashMap<Integer, ArrayList<Integer>>) this.mapaSucesoresAgente.clone(),
												this.energiaInicial,
												this.energia, 
												this.energiaEnemigo, 
												this.turnosRestantesParaUtilizarAtaquesEspeciales.stream().collect(Collectors.toList()), 
												this.escudo, 
												this.escapo, 
												this.cantidadPokemonsAdversarios);
		
		return newState;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void updateState(Perception p) {
		
		PokemonPerception percepcion = (PokemonPerception) p;
		
		this.nodoActual = percepcion.getPosicionAgente();
		
		this.mapaAgente.put(nodoActual, percepcion.getContenidoNodoActual());
		
		this.energiaEnemigo = percepcion.getEnergiaEnemigoEnNodoActual();
		
		for (Integer nodo : percepcion.getContenidoNodosSucesores().keySet()) {
			this.mapaAgente.put(nodo, percepcion.getContenidoNodosSucesores().get(nodo));
		}
		
		if (percepcion.isPuedeUsarSatelite()) {
			this.mapaAgente = (HashMap<Integer, Integer>) percepcion.getMapaPorSatelite().clone();
		}
		
	}

	@Override
	public String toString() {
		
		String estadoPokemon = "----- ESTADO POKEMON ------\n";
		estadoPokemon += "Nodo actual: "+this.nodoActual+". Energia: "+this.energia+".\n";
		estadoPokemon += "Energia enemigo: "+this.energiaEnemigo+". Escudo: "+this.escudo+". Escapo: "+this.escapo+"\n";
		estadoPokemon += "Ataques especiales: "+this.turnosRestantesParaUtilizarAtaquesEspeciales+". Cantidad de enemigos restante: "+this.cantidadPokemonsAdversarios+"\n";

		return estadoPokemon;
	}


}
