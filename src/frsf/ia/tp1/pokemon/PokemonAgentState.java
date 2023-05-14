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
import frsf.ia.tp1.pokemon.ataquesEspeciales.AtaqueEspecial;
import frsf.ia.tp1.pokemon.enemigos.Enemigo;
import frsf.ia.tp1.pokemon.enemigos.EnemigoFinal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
public class PokemonAgentState extends SearchBasedAgentState {
	
	private int nodoActual;
	private HashMap<Integer, Integer> mapaAgente;
	private HashMap<Integer, List<Integer>> mapaSucesoresAgente;
	private HashMap<Integer, Integer> energiaEnemigosSucesores;
	private HashMap<Integer, Integer> visitasAlNodo;
	private int energiaInicial;
	private int energia;
	private int energiaEnemigo;
	private List<AtaqueEspecial> ataquesEspeciales;
	private int escudo;
	private boolean escapo;
	private int cantidadPokemonsAdversarios;
	private int cantidadMovimientosTotales;
	private int energiaEnemigoFinal;
	
	public PokemonAgentState() {
		
		this.initState();
	}
	
	public boolean escapo() {
		return this.escapo;
	}
	
	@Override
	public void initState() {
		
		this.nodoActual = Const.nodoInicialAgente;
		this.energiaEnemigoFinal = Const.vidaEnemigoFinal;
		this.mapaAgente = cargarMapaAgente();
		this.mapaSucesoresAgente = Const.sucesores();
		this.energiaEnemigosSucesores = new HashMap<Integer, Integer>();
		this.visitasAlNodo = cargarVisitasAlNodo();
		this.energiaInicial = Const.energiaInicialAgente;
		this.energia = energiaInicial;
		this.energiaEnemigo = 0; //VER
		this.ataquesEspeciales = cargarAtaquesEspecialesIniciales();
		this.escudo = 0;
		this.escapo = false;
		this.cantidadPokemonsAdversarios = Const.cantidadEnemigos;
		this.cantidadMovimientosTotales = 0;
	}
	
	public boolean estaVivo() {
		return (this.energia > 0);
	}
	
	public void recargarEnergia(int cantidadEnergia) {
		
		this.energia += cantidadEnergia;
		
		for(AtaqueEspecial ae : this.ataquesEspeciales) {
			if (ae.getTurnosRestantesParaUtilizar() == -1) {
				ae.habilitarAtaqueEspecial(this.energia, this.energiaInicial);
			}
		}
	}
	
	public boolean puedeMoverse(Integer nodoAlQueSeMueve) {
		return (this.mapaAgente.get(nodoActual) == 0 || this.escapo) 
				&& this.visitasAlNodo.get(nodoAlQueSeMueve) < Const.cantidadVisitasANodoMaximas;
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
	
	private HashMap<Integer, Integer> cargarVisitasAlNodo() {
		HashMap<Integer, Integer> visitasAlNodo = new HashMap<>();
		
		for (int i = 1; i <= Const.cantidadNodos; i++) {
			visitasAlNodo.put(i, 0);
		}
		
		visitasAlNodo.put(Const.nodoInicialAgente, 1);
		
		return visitasAlNodo;
	}
	
	private ArrayList<AtaqueEspecial> cargarAtaquesEspecialesIniciales() {
		
		ArrayList<AtaqueEspecial> ataquesEspecialesIniciales = new ArrayList<>();
		
		ataquesEspecialesIniciales.add(new AtaqueEspecial(0, Const.porcentajeRecuperacionEnergiaAtaque0, -1, Const.porcentajeDeVidaNecesarioParaHabilitarAtaqueEspecial0));
		ataquesEspecialesIniciales.add(new AtaqueEspecial(1, Const.porcentajeRecuperacionEnergiaAtaque1, -1, Const.porcentajeDeVidaNecesarioParaHabilitarAtaqueEspecial1));
		ataquesEspecialesIniciales.add(new AtaqueEspecial(2, Const.porcentajeRecuperacionEnergiaAtaque2, -1, Const.porcentajeDeVidaNecesarioParaHabilitarAtaqueEspecial2));
		
		return ataquesEspecialesIniciales;
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
		return cantidadPokemonsAdversarios == other.cantidadPokemonsAdversarios
				&& energiaEnemigo == other.energiaEnemigo && energiaInicial == other.energiaInicial
				&& escapo == other.escapo && escudo == other.escudo && Objects.equals(mapaAgente, other.mapaAgente)
				&& Objects.equals(mapaSucesoresAgente, other.mapaSucesoresAgente) && nodoActual == other.nodoActual
				&& ataquesEspeciales.equals(other.ataquesEspeciales);
	}

	@SuppressWarnings("unchecked")
	@Override
	public SearchBasedAgentState clone() {
		
		PokemonAgentState newState = new PokemonAgentState(
												this.nodoActual,
												(HashMap<Integer, Integer>) this.mapaAgente.clone(),
												(HashMap<Integer, List<Integer>>) this.mapaSucesoresAgente.clone(),
												(HashMap<Integer, Integer>) this.energiaEnemigosSucesores.clone(),
												(HashMap<Integer, Integer>) this.visitasAlNodo.clone(),
												this.energiaInicial,
												this.energia, 
												this.energiaEnemigo, 
												this.ataquesEspeciales.stream().map(ae -> ae.clone()).collect(Collectors.toList()), 
												this.escudo, 
												this.escapo, 
												this.cantidadPokemonsAdversarios,
												this.cantidadMovimientosTotales, 
												this.energiaEnemigoFinal);
		
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
		
		this.energiaEnemigosSucesores.clear();
		for (Integer nodo : percepcion.getEnergiaEnemigosSucesores().keySet()) {
			this.energiaEnemigosSucesores.put(nodo, percepcion.getEnergiaEnemigosSucesores().get(nodo));
		}
		
		if (percepcion.isPuedeUsarSatelite()) {
			this.mapaAgente = (HashMap<Integer, Integer>) percepcion.getMapaPorSatelite().clone();
		}
		
	}

	@Override
	public String toString() {
		
		String estadoPokemon = "----- ESTADO POKEMON ------\n";
		estadoPokemon += "Nodo actual: " + this.nodoActual + ". Energia: " + this.energia + ".\n";
		estadoPokemon += "Energia enemigo: " + this.energiaEnemigo + ". Escudo: " + this.escudo+". Escapo: " + this.escapo + "\n";
		estadoPokemon += "Ataques especiales: " + "\n";
		for (AtaqueEspecial a : this.ataquesEspeciales) {
			estadoPokemon += "     " + a + "\n";
		}
		estadoPokemon += "Cant enemigos restante: " + this.cantidadPokemonsAdversarios + "\n";
		estadoPokemon += "Contenido nodo actual: " + this.mapaAgente.get(this.nodoActual) + "\n";
		estadoPokemon += "Cantidad movimientos: " + this.cantidadMovimientosTotales + "\n";

		return estadoPokemon;
	}


}
