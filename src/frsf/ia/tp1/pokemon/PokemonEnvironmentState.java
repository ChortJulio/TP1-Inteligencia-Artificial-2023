package frsf.ia.tp1.pokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

import frsf.cidisi.faia.state.EnvironmentState;
import frsf.ia.tp1.pokemon.enemigos.Enemigo;
import frsf.ia.tp1.pokemon.enemigos.EnemigoFinal;
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
	private ArrayList<Enemigo> listaEnemigos;
	private EnemigoFinal jefeFinal;
	private HashMap<Integer, Integer> turnosRestantesParaReabastecerPokebolas;
	private int turnosRestantesParaUtilizarSatelite;
	
	public PokemonEnvironmentState() {
		
		this.initState();
		
	}
	
	
	@Override
	public void initState() {
		
		this.posicionAgente = 1;
		this.mapaAmbiente = cargarMapaAmbiente();
		this.mapaSucesoresAmbiente = cargarMapaSucesoresAmbiente();
		this.listaEnemigos = cargarListaEnemigos();
		this.jefeFinal = new EnemigoFinal();
		this.turnosRestantesParaReabastecerPokebolas = cargarTurnosRestantesParaReabastecerPokebolas();
		this.turnosRestantesParaUtilizarSatelite = 10;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private LinkedHashMap<Integer, Integer> cargarMapaAmbiente() {
		
		LinkedHashMap<Integer, Integer> mapaAmbienteInicial = new LinkedHashMap<>();

		mapaAmbienteInicial.put(1, Const.contenidoInicialNodo1);
		mapaAmbienteInicial.put(2, Const.contenidoInicialNodo2);
		mapaAmbienteInicial.put(3, Const.contenidoInicialNodo3);
		mapaAmbienteInicial.put(4, Const.contenidoInicialNodo4);
		mapaAmbienteInicial.put(5, Const.contenidoInicialNodo5);
		mapaAmbienteInicial.put(6, Const.contenidoInicialNodo6);
		mapaAmbienteInicial.put(7, Const.contenidoInicialNodo7);
		mapaAmbienteInicial.put(8, Const.contenidoInicialNodo8);
		mapaAmbienteInicial.put(9, Const.contenidoInicialNodo9);
		mapaAmbienteInicial.put(10, Const.contenidoInicialNodo10);
		mapaAmbienteInicial.put(11, Const.contenidoInicialNodo11);
		mapaAmbienteInicial.put(12, Const.contenidoInicialNodo12);
		mapaAmbienteInicial.put(13, Const.contenidoInicialNodo13);
		mapaAmbienteInicial.put(14, Const.contenidoInicialNodo14);
		mapaAmbienteInicial.put(15, Const.contenidoInicialNodo15);
		mapaAmbienteInicial.put(16, Const.contenidoInicialNodo16);
		mapaAmbienteInicial.put(17, Const.contenidoInicialNodo17);
		mapaAmbienteInicial.put(18, Const.contenidoInicialNodo18);
		mapaAmbienteInicial.put(19, Const.contenidoInicialNodo19);
		mapaAmbienteInicial.put(20, Const.contenidoInicialNodo20);
		mapaAmbienteInicial.put(21, Const.contenidoInicialNodo21);
		mapaAmbienteInicial.put(22, Const.contenidoInicialNodo22);
		mapaAmbienteInicial.put(23, Const.contenidoInicialNodo23);
		mapaAmbienteInicial.put(24, Const.contenidoInicialNodo24);
		mapaAmbienteInicial.put(25, Const.contenidoInicialNodo25);
		mapaAmbienteInicial.put(26, Const.contenidoInicialNodo26);
		mapaAmbienteInicial.put(27, Const.contenidoInicialNodo27);
		mapaAmbienteInicial.put(28, Const.contenidoInicialNodo28);
		mapaAmbienteInicial.put(29, Const.contenidoInicialNodo29);
		
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
	
	private ArrayList<Enemigo> cargarListaEnemigos() {
		
		ArrayList<Enemigo> listaEnemigosInicial = new ArrayList<>();
		ArrayList<Integer> nodosVacios = new ArrayList<>();

		for(Integer key : this.mapaAmbiente.keySet()) {
			if (this.mapaAmbiente.get(key) == 0) {
				nodosVacios.add(key);
			}
		}
		
		Random randomGenerator = new Random(Const.seed);
		
		while(listaEnemigosInicial.size() < 7) {
			
			Enemigo e = new Enemigo(nodosVacios.get(randomGenerator.nextInt(nodosVacios.size())));
			
			nodosVacios.remove(e.getNodo());
			
			listaEnemigosInicial.add(e);
		}
		
		
		return listaEnemigosInicial;
	}
	
	private HashMap<Integer, Integer> cargarTurnosRestantesParaReabastecerPokebolas() {
		
		HashMap<Integer, Integer> turnosRestantesParaReabastecerPokebolasInicial = new HashMap<>();
		
		ArrayList<Integer> nodosConPokebolas = new ArrayList<>();
		
		for(Integer key : this.mapaAmbiente.keySet()) {
			if (this.mapaAmbiente.get(key) == 2) {
				nodosConPokebolas.add(key);
			}
		}
		
		for(Integer nodoConPokebola : nodosConPokebolas) {
			turnosRestantesParaReabastecerPokebolasInicial.put(0, nodoConPokebola);
		}		
		
		return turnosRestantesParaReabastecerPokebolasInicial;
	}
	
}
