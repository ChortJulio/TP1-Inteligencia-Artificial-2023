package frsf.ia.tp1.pokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class Const {
	public static long seed = 2;
	
	public static Random randomGenerator = new Random(Const.seed);

	public static int nodoInicialAgente = 1;

	public static int nodoPosicionEnemigoFinal = 24;
	public static int cantidadEnemigos = 7;
	public static int cantidadNodos = 29;
	public static int energiaMaximaInicialAgente = 20;
	public static int energiaMinimaInicialAgente = 10;
	public static int energiaMaximoEnemigo = 10;
	public static int energiaMinimoEnemigo = 5;
	public static int energiaMaximoEnemigoFinal = 45;
	public static int energiaMinimoEnemigoFinal = 40;
	public static int turnosMaximoHastaMoverseEnemigo = 3;
	public static int turnosMinimoHastaMoverseEnemigo = 1;
	public static int energiaMinimaRecargable = 5;
	public static int energiaMaximaRecargable = 10;
	public static int turnosMaximosParaReabastecerPokeparadas = 3;
	public static int cantidadTurnosParaUtilizarSateliteMinimo = 5;
	public static int cantidadTurnosParaUtilizarSateliteMaximo = 10;
	public static int cantidadTurnosParaUtilizarSatelite = 10;
	public static int cantidadTurnosParaUsarSateliteInicial = 0;
	public static int cantidadTurnosParaUtilizarAtaque = 3;
	public static int cantidadVisitasANodoMaximas = 3;
	public static double porcentajeRecuperacionEnergiaAtaque0 = 0.2;
	public static double porcentajeRecuperacionEnergiaAtaque1 = 0.3;
	public static double porcentajeRecuperacionEnergiaAtaque2 = 0.5;
	public static double porcentajeDeVidaNecesarioParaHabilitarAtaqueEspecial0 = 1.25;
	public static double porcentajeDeVidaNecesarioParaHabilitarAtaqueEspecial1 = 1.75;
	public static double porcentajeDeVidaNecesarioParaHabilitarAtaqueEspecial2 = 2.2;
	
	public static int energiaEnemigoFinal = Const.randomBetween(Const.energiaMaximoEnemigoFinal, Const.energiaMinimoEnemigoFinal);
	public static int energiaInicialAgente = Const.randomBetween(Const.energiaMaximaInicialAgente, Const.energiaMinimaInicialAgente);
	
	public static List<Integer> distanciaAEnemigoFinal = Const.calcularDistanciaAEnemigoFinal();
	
	public static HashMap<Integer, List<Integer>> mapaSucesores = Const.sucesores();
	
	public static List<Integer> sucesoresNodo1 = List.of(2, 4);
	public static List<Integer> sucesoresNodo2 = List.of(1, 3);
	public static List<Integer> sucesoresNodo3 = List.of(2, 4);
	public static List<Integer> sucesoresNodo4 = List.of(1, 3, 5, 7);
	public static List<Integer> sucesoresNodo5 = List.of(4, 6, 9);
	public static List<Integer> sucesoresNodo6 = List.of(5, 7);
	public static List<Integer> sucesoresNodo7 = List.of(4, 6, 8, 29);
	public static List<Integer> sucesoresNodo8 = List.of(7, 9, 11, 28);
	public static List<Integer> sucesoresNodo9 = List.of(5, 8, 10);
	public static List<Integer> sucesoresNodo10 = (List.of(9));
	public static List<Integer> sucesoresNodo11 = (List.of(8, 12, 28));
	public static List<Integer> sucesoresNodo12 = (List.of(11, 13));
	public static List<Integer> sucesoresNodo13 = (List.of(12, 14, 22, 26, 27));
	public static List<Integer> sucesoresNodo14 = (List.of(13, 15, 16));
	public static List<Integer> sucesoresNodo15 = (List.of(14));
	public static List<Integer> sucesoresNodo16 = (List.of(14, 17));
	public static List<Integer> sucesoresNodo17 = (List.of(16, 18, 22));
	public static List<Integer> sucesoresNodo18 = (List.of(17, 19));
	public static List<Integer> sucesoresNodo19 = (List.of(18, 20));
	public static List<Integer> sucesoresNodo20 = (List.of(19, 21, 24));
	public static List<Integer> sucesoresNodo21 = (List.of(20, 22));
	public static List<Integer> sucesoresNodo22 = (List.of(13, 17, 21, 23));
	public static List<Integer> sucesoresNodo23 = (List.of(22, 24));
	public static List<Integer> sucesoresNodo24 = (List.of(20, 23, 25));
	public static List<Integer> sucesoresNodo25 = (List.of(24, 26));
	public static List<Integer> sucesoresNodo26 = (List.of(13, 25, 27, 29));
	public static List<Integer> sucesoresNodo27 = (List.of(13, 26, 28));
	public static List<Integer> sucesoresNodo28 = (List.of(8, 11, 27));
	public static List<Integer> sucesoresNodo29 = (List.of(7, 26));
	
	
	public static int randomBetween(int max, int min) {
		return (randomGenerator.nextInt(max - min + 1) + min);
	}
	
	public static String mapaActual(HashMap<Integer, Integer> mapa, int nodoActualAgente) {
		HashMap<Integer, String> caracteres = new LinkedHashMap<>();
		
		for (Integer i : mapa.keySet()) {
			caracteres.put(i, mapa.get(i).toString());
		}
		
		if (mapa.get(nodoActualAgente).equals(1)) {
			caracteres.replace(nodoActualAgente, "P");
		}
		else {
			caracteres.replace(nodoActualAgente, "X");
		}
		String mapaActual = "\n+---------------- Mapa ambiente ----------------+\n";
		mapaActual += "+-----------------------------------------------+\n";
		mapaActual += "|        "+caracteres.get(11)+"  ------ "+caracteres.get(12)+"  ---- "+caracteres.get(13)+"  -------- "+caracteres.get(14)+"  --- "+caracteres.get(15)+" |\n";
		mapaActual += "|        | \\             / |  \\         \\       |\n";
		mapaActual += "|"+caracteres.get(10)+"       |   "+caracteres.get(28)+"  ----- "+caracteres.get(27)+"   /    \\         \\      |\n";
		mapaActual += "| \\     |  /          |  /      \\        "+caracteres.get(16)+"      |\n";
		mapaActual += "|  "+caracteres.get(9)+" --- "+caracteres.get(8)+"            | /        \\        \\     |\n";
		mapaActual += "| /      |            |/          \\        \\    |\n";
		mapaActual += "|"+caracteres.get(5)+" - "+caracteres.get(6)+" - "+caracteres.get(7)+" --- "+caracteres.get(29)+"  -- "+caracteres.get(26)+"       "+caracteres.get(23)+"  -- "+caracteres.get(22)+"  ----- "+caracteres.get(17)+"   |\n";
		mapaActual += "|  \\    /             |      |      |       |   |\n";
		mapaActual += "|    "+caracteres.get(4)+" --- "+caracteres.get(3)+"          |      |      "+caracteres.get(21)+"       "+caracteres.get(18)+"   |\n";
		mapaActual += "|    |    /           |      |      |       |   |\n";
		mapaActual += "|    |   "+caracteres.get(2)+"            "+caracteres.get(25)+"  --- "+caracteres.get(24)+"  --- "+caracteres.get(20)+"  ---- "+caracteres.get(19)+"   |\n";
		mapaActual += "|    | /                                        |\n";
		mapaActual += "|    "+caracteres.get(1)+"                                          |\n";		
		mapaActual += "+-----------------------------------------------+\n";
		
		return mapaActual;
	}

	public static void imprimirCartelVictoria() {
		
		String cartelVictoria = "+-------------------------------------------------------------------------------+\n";
		cartelVictoria += "| __         __   _     _____    _______    _____     _____     _       __      |\n";
		cartelVictoria += "| \\ \\       / /  | |   / ____|  |___ ___|  /  __ \\   |  _  |   | |     /  \\     |\n";
		cartelVictoria += "|  \\ \\     / /   | |   | |         | |     | /  \\ |  | |_| |   | |    / /\\ \\    |\n";
		cartelVictoria += "|   \\ \\   / /    | |   | |         | |     | |  | |  |  _  |   | |   / /__\\ \\   |\n";
		cartelVictoria += "|    \\ \\_/ /     | |   | |___      | |     | \\__/ |  | | \\ \\   | |  / _____  \\  |\n";
		cartelVictoria += "|     \\___/      |_|   \\_____|     |_|     \\_____/   |_|  \\_\\  |_| /_/      \\_\\ |\n";
		cartelVictoria += "|                                                                               |\n";
		cartelVictoria += "+-------------------------------------------------------------------------------+\n";
		
		System.out.println(cartelVictoria);
	}
	
	public static HashMap<Integer, List<Integer>> sucesores() {
		HashMap<Integer, List<Integer>> mapaSucesores = new HashMap<>();
		
		mapaSucesores.put(1, Const.sucesoresNodo1);
		mapaSucesores.put(2, Const.sucesoresNodo2);
		mapaSucesores.put(3, Const.sucesoresNodo3);
		mapaSucesores.put(4, Const.sucesoresNodo4);
		mapaSucesores.put(5, Const.sucesoresNodo5);
		mapaSucesores.put(6, Const.sucesoresNodo6);
		mapaSucesores.put(7, Const.sucesoresNodo7);
		mapaSucesores.put(8, Const.sucesoresNodo8);
		mapaSucesores.put(9, Const.sucesoresNodo9);
		mapaSucesores.put(10, Const.sucesoresNodo10);
		mapaSucesores.put(11, Const.sucesoresNodo11);
		mapaSucesores.put(12, Const.sucesoresNodo12);
		mapaSucesores.put(13, Const.sucesoresNodo13);
		mapaSucesores.put(14, Const.sucesoresNodo14);
		mapaSucesores.put(15, Const.sucesoresNodo15);
		mapaSucesores.put(16, Const.sucesoresNodo16);
		mapaSucesores.put(17, Const.sucesoresNodo17);
		mapaSucesores.put(18, Const.sucesoresNodo18);
		mapaSucesores.put(19, Const.sucesoresNodo19);
		mapaSucesores.put(20, Const.sucesoresNodo20);
		mapaSucesores.put(21, Const.sucesoresNodo21);
		mapaSucesores.put(22, Const.sucesoresNodo22);
		mapaSucesores.put(23, Const.sucesoresNodo23);
		mapaSucesores.put(24, Const.sucesoresNodo24);
		mapaSucesores.put(25, Const.sucesoresNodo25);
		mapaSucesores.put(26, Const.sucesoresNodo26);
		mapaSucesores.put(27, Const.sucesoresNodo27);
		mapaSucesores.put(28, Const.sucesoresNodo28);
		mapaSucesores.put(29, Const.sucesoresNodo29);
		
		return mapaSucesores;
	}
	
	public static int distanciaANodoFinal(int nodo) {
		return distanciaAEnemigoFinal.get(nodo-1);
	}
	
	public static ArrayList<Integer> calcularDistanciaAEnemigoFinal() {
//		List<Integer> nodos = new ArrayList<>();
//		HashMap<Integer, Integer> distancias = new HashMap<>();
//		PriorityQueue<Integer> cola = new PriorityQueue<>((e1, e2) -> distancias.get(e1).compareTo(e2));
//		
//		Integer nodoOrigen = nodoPosicionEnemigoFinal;
//		Integer nodoDestino = nodoInicialAgente;
//		
//		for (int i=1; i<=cantidadNodos; i++) {
//			nodos.add(i);
//			distancias.put(i, Integer.MAX_VALUE);
//		}
		
		return new ArrayList<Integer>(List.of(
				6, // Nodo 1
				7, // Nodo 2
				6, // Nodo 3
				5, // Nodo 4
				6, // Nodo 5
				5, // Nodo 6
				4, // Nodo 7
				5, // Nodo 8
				6, // Nodo 9
				7, // Nodo 10
				5, // Nodo 11
				4, // Nodo 12
				3, // Nodo 13
				4, // Nodo 14
				5, // Nodo 15
				4, // Nodo 16
				3, // Nodo 17
				3, // Nodo 18
				2, // Nodo 19
				1, // Nodo 20
				2, // Nodo 21
				2, // Nodo 22
				1, // Nodo 23
				0, // Nodo 24
				1, // Nodo 25
				2, // Nodo 26
				3, // Nodo 27
				4, // Nodo 28
				3 // Nodo 29				
				));
		
//		distancias.put(nodoOrigen, 0);
//		cola.offer(nodoOrigen);
//		
//		System.out.println(cola);
//		
//		while (!cola.isEmpty()) {
//			Integer nodo = cola.poll();
//			
//			if (distancias.get(nodo) > distancias[nodoActual.indice]) {
//                continue;
//            }
//			for (Integer sucesor : Const.mapaSucesoresAgenteInicial.get(nodo)) {
//				
//			}
//		}
	}

}
