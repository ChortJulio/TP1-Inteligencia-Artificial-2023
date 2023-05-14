package frsf.ia.tp1.pokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

import frsf.cidisi.faia.state.EnvironmentState;
import frsf.ia.tp1.pokemon.enemigos.Enemigo;
import frsf.ia.tp1.pokemon.enemigos.EnemigoFinal;
import frsf.ia.tp1.pokemon.pokeparadas.Pokeparada;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class PokemonEnvironmentState extends EnvironmentState{

	private int posicionAgente;
	private LinkedHashMap<Integer, Integer> mapaAmbiente;
	private HashMap<Integer, ArrayList<Integer>> mapaSucesoresAmbiente;
	private List<Enemigo> listaEnemigos;
	private EnemigoFinal jefeFinal;
	private List<Pokeparada> listaPokeparadas;
	private int turnosRestantesParaUtilizarSatelite;
	
	public PokemonEnvironmentState() {
		
		this.initState();
		
	}
	
	@Override
	public void initState() {
		
		this.posicionAgente = 1;
		this.mapaAmbiente = cargarMapaAmbiente();
		this.mapaSucesoresAmbiente = cargarMapaSucesoresAmbiente();
		this.listaPokeparadas = cargarListaPokeparadas();
		this.listaEnemigos = cargarListaEnemigos();
		this.jefeFinal = cargarEnemigoFinal();
		this.turnosRestantesParaUtilizarSatelite = Const.cantidadTurnosParaUtilizarSatelite;
		
	}
	
	private LinkedHashMap<Integer, Integer> cargarMapaAmbiente() {
		
		LinkedHashMap<Integer, Integer> mapaAmbienteInicial = new LinkedHashMap<>();
		
		for(int i = 1; i <= Const.cantidadNodos; i++) {
			mapaAmbienteInicial.put(i, 0);
		}
		
		return mapaAmbienteInicial;
	}
	
	private HashMap<Integer, ArrayList<Integer>> cargarMapaSucesoresAmbiente() {
		
		HashMap<Integer, ArrayList<Integer>> mapaSucesoresAmbienteInicial = new HashMap<>();
		
		mapaSucesoresAmbienteInicial.put(1, Const.sucesoresNodo1);
		mapaSucesoresAmbienteInicial.put(2, Const.sucesoresNodo2);
		mapaSucesoresAmbienteInicial.put(3, Const.sucesoresNodo3);
		mapaSucesoresAmbienteInicial.put(4, Const.sucesoresNodo4);
		mapaSucesoresAmbienteInicial.put(5, Const.sucesoresNodo5);
		mapaSucesoresAmbienteInicial.put(6, Const.sucesoresNodo6);
		mapaSucesoresAmbienteInicial.put(7, Const.sucesoresNodo7);
		mapaSucesoresAmbienteInicial.put(8, Const.sucesoresNodo8);
		mapaSucesoresAmbienteInicial.put(9, Const.sucesoresNodo9);
		mapaSucesoresAmbienteInicial.put(10, Const.sucesoresNodo10);
		mapaSucesoresAmbienteInicial.put(11, Const.sucesoresNodo11);
		mapaSucesoresAmbienteInicial.put(12, Const.sucesoresNodo12);
		mapaSucesoresAmbienteInicial.put(13, Const.sucesoresNodo13);
		mapaSucesoresAmbienteInicial.put(14, Const.sucesoresNodo14);
		mapaSucesoresAmbienteInicial.put(15, Const.sucesoresNodo15);
		mapaSucesoresAmbienteInicial.put(16, Const.sucesoresNodo16);
		mapaSucesoresAmbienteInicial.put(17, Const.sucesoresNodo17);
		mapaSucesoresAmbienteInicial.put(18, Const.sucesoresNodo18);
		mapaSucesoresAmbienteInicial.put(19, Const.sucesoresNodo19);
		mapaSucesoresAmbienteInicial.put(20, Const.sucesoresNodo20);
		mapaSucesoresAmbienteInicial.put(21, Const.sucesoresNodo21);
		mapaSucesoresAmbienteInicial.put(22, Const.sucesoresNodo22);
		mapaSucesoresAmbienteInicial.put(23, Const.sucesoresNodo23);
		mapaSucesoresAmbienteInicial.put(24, Const.sucesoresNodo24);
		mapaSucesoresAmbienteInicial.put(25, Const.sucesoresNodo25);
		mapaSucesoresAmbienteInicial.put(26, Const.sucesoresNodo26);
		mapaSucesoresAmbienteInicial.put(27, Const.sucesoresNodo27);
		mapaSucesoresAmbienteInicial.put(28, Const.sucesoresNodo28);
		mapaSucesoresAmbienteInicial.put(29, Const.sucesoresNodo29);
		
		return mapaSucesoresAmbienteInicial;
	}
	
	private EnemigoFinal cargarEnemigoFinal() {
		
		// Cargar jefe final en el mapa del ambiente
		this.mapaAmbiente.put(Const.nodoPosicionEnemigoFinal, 3);
		
		return new EnemigoFinal(Const.nodoPosicionEnemigoFinal);
	}
	
	private ArrayList<Enemigo> cargarListaEnemigos() {
		
		ArrayList<Enemigo> listaEnemigosInicial = new ArrayList<>();
		ArrayList<Integer> nodosVacios = new ArrayList<>();

		for(Integer key : this.mapaAmbiente.keySet()) {
			if (this.mapaAmbiente.get(key) == 0) {
				nodosVacios.add(key);
			}
		}
		
		Random randomGenerator = new Random(Const.seed);
		
		while(listaEnemigosInicial.size() < Const.cantidadEnemigos) {
			
			Enemigo e = new Enemigo(nodosVacios.get(randomGenerator.nextInt(nodosVacios.size())));
			
			nodosVacios.remove((Integer) e.getNodo());
			
			listaEnemigosInicial.add(e);
		}		
		
		return listaEnemigosInicial;
	}
	
	private ArrayList<Pokeparada> cargarListaPokeparadas() {
		
		ArrayList<Pokeparada> listaPokeparadasInicial = new ArrayList<>();
		
		listaPokeparadasInicial.add(new Pokeparada(6, 0));
//		listaPokeparadasInicial.add(new Pokeparada(11, 0));
//		listaPokeparadasInicial.add(new Pokeparada(14, 0));
//		listaPokeparadasInicial.add(new Pokeparada(19, 0));
//		listaPokeparadasInicial.add(new Pokeparada(23, 0));
		
		mapaAmbiente.put(6, 2);
//		mapaAmbiente.put(11, 2);
//		mapaAmbiente.put(14, 2);
//		mapaAmbiente.put(19, 2);
//		mapaAmbiente.put(23, 2);
		
		return listaPokeparadasInicial;
	}
	
	public void moverEnemigos() {
		for (Enemigo enemigo : this.listaEnemigos) {
			if (enemigo.getTurnosHastaMoverse() == 0) {
				
				enemigo.setNodo(nodoAlQueSeMueveElEnemigo(enemigo));
				enemigo.setTurnosHastaMoverse(Const.randomBetween(Const.turnosMaximoHastaMoverseEnemigo, Const.turnosMinimoHastaMoverseEnemigo));
				
			} else {
				enemigo.restarTurnoParaMoverse();
			}
		}
	}
	
	private int nodoAlQueSeMueveElEnemigo(Enemigo e) {
		List<Integer> listaPosiblesNodos = this.mapaSucesoresAmbiente.get(e.getNodo());
		
		Random randomGenerator = new Random(Const.seed);
		
		while (listaPosiblesNodos.size() != 0) {
			
			int nodoCandidatoAMoverse = listaPosiblesNodos.get(randomGenerator.nextInt(listaPosiblesNodos.size()));
			
			if (this.mapaAmbiente.get(nodoCandidatoAMoverse) == 0 && !existePokeparadaEnNodo(nodoCandidatoAMoverse)) {
				return nodoCandidatoAMoverse;
			} else {
				listaPosiblesNodos.remove((Integer) nodoCandidatoAMoverse);
			}
		}
		
		return e.getNodo();
		
	}
	
	private boolean existePokeparadaEnNodo(Integer nodo) {
		
		boolean existePokeparadaEnNodo = false;
		
		for (Pokeparada pokeparada : this.listaPokeparadas) {
			if (pokeparada.getNodo() == nodo) {
				existePokeparadaEnNodo = true;
				break;
			}
		}
		
		return existePokeparadaEnNodo;
	}
	/*
	 * Environment: PokemonEnvironmentState(posicionAgente=4, listaEnemigos=[], jefeFinal=EnemigoFinal(nodo=5, energia=5), listaPokeparadas=[Pokeparada(nodo=6, turnosParaRestablecerse=5)], turnosRestantesParaUtilizarSatelite=9)
*/
	@Override
	public String toString() {
		
		String estadoAmbiente = "----- ESTADO AMBIENTE ------\n";
		estadoAmbiente += "Posicion agente: "+this.posicionAgente+". Lista enemigos: "+this.listaEnemigos+".\n";
		estadoAmbiente += "Posicion jefe final: "+this.jefeFinal.getNodo()+". Energia jefe final: "+this.jefeFinal.getEnergia()+"\n";
		//estadoAmbiente += "Lista pokeparadas: "+this.listaPokeparadas+". Turnos restantes para satelite: "+this.turnosRestantesParaUtilizarSatelite+"\n";
		estadoAmbiente += "Turnos restantes para satelite: "+this.turnosRestantesParaUtilizarSatelite+"\n";

		return estadoAmbiente;
	}
	
}
