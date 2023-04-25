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
		
		HashMap<Integer, ArrayList<Integer>> mapaSucesoresAmbienteInicial = new HashMap<>();
		
		mapaSucesoresAmbienteInicial.put(1, new ArrayList<Integer>(List.of(2, 4)));
		mapaSucesoresAmbienteInicial.put(2, new ArrayList<Integer>(List.of(1, 3)));
		mapaSucesoresAmbienteInicial.put(3, new ArrayList<Integer>(List.of(2, 4)));
		mapaSucesoresAmbienteInicial.put(4, new ArrayList<Integer>(List.of(1, 3, 5, 7)));
		mapaSucesoresAmbienteInicial.put(5, new ArrayList<Integer>(List.of(6, 9)));
		mapaSucesoresAmbienteInicial.put(6, new ArrayList<Integer>(List.of(5, 7)));
		mapaSucesoresAmbienteInicial.put(7, new ArrayList<Integer>(List.of(4, 6, 8, 29)));
		mapaSucesoresAmbienteInicial.put(8, new ArrayList<Integer>(List.of(7, 9, 11, 28)));
		mapaSucesoresAmbienteInicial.put(9, new ArrayList<Integer>(List.of(5, 8, 10)));
		mapaSucesoresAmbienteInicial.put(10, new ArrayList<Integer>(List.of(9)));
		mapaSucesoresAmbienteInicial.put(11, new ArrayList<Integer>(List.of(8, 12, 28)));
		mapaSucesoresAmbienteInicial.put(12, new ArrayList<Integer>(List.of(11, 13)));
		mapaSucesoresAmbienteInicial.put(13, new ArrayList<Integer>(List.of(12, 14, 22, 26, 27)));
		mapaSucesoresAmbienteInicial.put(14, new ArrayList<Integer>(List.of(13, 15, 16)));
		mapaSucesoresAmbienteInicial.put(15, new ArrayList<Integer>(List.of(14)));
		mapaSucesoresAmbienteInicial.put(16, new ArrayList<Integer>(List.of(14, 17)));
		mapaSucesoresAmbienteInicial.put(17, new ArrayList<Integer>(List.of(16, 18, 22)));
		mapaSucesoresAmbienteInicial.put(18, new ArrayList<Integer>(List.of(17, 19)));
		mapaSucesoresAmbienteInicial.put(19, new ArrayList<Integer>(List.of(18, 20)));
		mapaSucesoresAmbienteInicial.put(20, new ArrayList<Integer>(List.of(19, 21, 24)));
		mapaSucesoresAmbienteInicial.put(21, new ArrayList<Integer>(List.of(20, 22)));
		mapaSucesoresAmbienteInicial.put(22, new ArrayList<Integer>(List.of(13, 17, 21, 23)));
		mapaSucesoresAmbienteInicial.put(23, new ArrayList<Integer>(List.of(22, 24)));
		mapaSucesoresAmbienteInicial.put(24, new ArrayList<Integer>(List.of(20, 23, 25)));
		mapaSucesoresAmbienteInicial.put(25, new ArrayList<Integer>(List.of(24, 26)));
		mapaSucesoresAmbienteInicial.put(26, new ArrayList<Integer>(List.of(13, 25, 27, 29)));
		mapaSucesoresAmbienteInicial.put(27, new ArrayList<Integer>(List.of(13, 26, 28)));
		mapaSucesoresAmbienteInicial.put(28, new ArrayList<Integer>(List.of(8, 11, 27)));
		mapaSucesoresAmbienteInicial.put(29, new ArrayList<Integer>(List.of(7, 26)));
		
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
