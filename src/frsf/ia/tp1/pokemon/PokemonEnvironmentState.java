package frsf.ia.tp1.pokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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
	private HashMap<Integer, List<Integer>> mapaSucesoresAmbiente;
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
		this.mapaSucesoresAmbiente = Const.sucesores();
		this.jefeFinal = cargarEnemigoFinal();
		this.listaPokeparadas = cargarListaPokeparadas();
		this.listaEnemigos = cargarListaEnemigos();
		this.turnosRestantesParaUtilizarSatelite = Const.cantidadTurnosParaUsarSateliteInicial;
	}
	
	private LinkedHashMap<Integer, Integer> cargarMapaAmbiente() {
		
		LinkedHashMap<Integer, Integer> mapaAmbienteInicial = new LinkedHashMap<>();
		
		for(int i = 1; i <= Const.cantidadNodos; i++) {
			mapaAmbienteInicial.put(i, 0);
		}
		
		return mapaAmbienteInicial;
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
		listaPokeparadasInicial.add(new Pokeparada(11, 0));
		listaPokeparadasInicial.add(new Pokeparada(14, 0));
		listaPokeparadasInicial.add(new Pokeparada(19, 0));
		listaPokeparadasInicial.add(new Pokeparada(23, 0));
		
		mapaAmbiente.put(6, 2);
		mapaAmbiente.put(11, 2);
		mapaAmbiente.put(14, 2);
		mapaAmbiente.put(19, 2);
		mapaAmbiente.put(23, 2);
		
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
		List<Integer> listaPosiblesNodos = this.mapaSucesoresAmbiente.get(e.getNodo()).stream().collect(Collectors.toList());
		
		Random randomGenerator = new Random(Const.seed);
		
		while (listaPosiblesNodos.size() != 0) {
			
			int nodoCandidatoAMoverse = listaPosiblesNodos.get(randomGenerator.nextInt(listaPosiblesNodos.size()));
			
			if (this.mapaAmbiente.get(nodoCandidatoAMoverse) == 0 
					&& !existePokeparadaEnNodo(nodoCandidatoAMoverse)
					&& !existeEnemigo(nodoCandidatoAMoverse)) {
				return nodoCandidatoAMoverse;
			} else {
				listaPosiblesNodos.remove((Integer) nodoCandidatoAMoverse);
			}
		}
		
		return e.getNodo();
		
	}
	
	private boolean existePokeparadaEnNodo(Integer nodo) {
		return listaPokeparadas.stream().anyMatch(p -> p.getNodo() == nodo);
	}
	
	private boolean existeEnemigo(Integer nodo) {
		return listaEnemigos.stream().anyMatch(e -> e.getNodo() == nodo);
	}
	/*
	 * Environment: PokemonEnvironmentState(posicionAgente=4, listaEnemigos=[], jefeFinal=EnemigoFinal(nodo=5, energia=5), listaPokeparadas=[Pokeparada(nodo=6, turnosParaRestablecerse=5)], turnosRestantesParaUtilizarSatelite=9)
*/
	@SuppressWarnings("unchecked")
	@Override
	public String toString() {
		HashMap<Integer, Integer> mapaAImprimir = (HashMap<Integer, Integer>) this.mapaAmbiente.clone();	
		
		String estadoAmbiente = "----- ESTADO AMBIENTE ------\n";
		estadoAmbiente += "Posicion agente: "+this.posicionAgente + "\n";
		estadoAmbiente += "Lista enemigos: " + "\n";
		for (Enemigo e : this.listaEnemigos) {
			estadoAmbiente += "     " + e + "\n";
			mapaAImprimir.put(e.getNodo(), 1);
		}
		estadoAmbiente += "Posicion jefe final: "+this.jefeFinal.getNodo()+". Energia jefe final: "+this.jefeFinal.getEnergia()+"\n";
		estadoAmbiente += "Turnos restantes para satelite: "+this.turnosRestantesParaUtilizarSatelite+"\n";
		estadoAmbiente += Const.mapaActual(mapaAImprimir, posicionAgente);

		return estadoAmbiente;
	}
	
}
