package frsf.ia.tp1.pokemon;

import java.util.ArrayList;
import java.util.List;

public class Const {

	public static long seed = 1;
	public static int energiaInicialAgente = 20;
	public static int nodoPosicionEnemigoFinal = 24;
	public static int cantidadEnemigos = 7;
	public static int vidaMaximoEnemigo = 15;
	public static int vidaMinimoEnemigo = 5;
	public static int vidaMaximoEnemigoFinal = 60;
	public static int vidaMinimoEnemigoFinal = 30;
	public static int turnosMaximoHastaMoverseEnemigo = 3;
	public static int turnosMinimoHastaMoverseEnemigo = 1;
	public static int turnosParaUtilizarSatelite = 10;
	public static int turnosRestantesParaReabastecerPokebolas = 3;
	
	public static int contenidoInicialNodo1 = 0;
	public static int contenidoInicialNodo2 = 0;
	public static int contenidoInicialNodo3 = 0;
	public static int contenidoInicialNodo4 = 0;
	public static int contenidoInicialNodo5 = 0;
	public static int contenidoInicialNodo6 = 2;
	public static int contenidoInicialNodo7 = 0;
	public static int contenidoInicialNodo8 = 0;
	public static int contenidoInicialNodo9 = 0;
	public static int contenidoInicialNodo10 = 0;
	public static int contenidoInicialNodo11 = 2;
	public static int contenidoInicialNodo12 = 0;
	public static int contenidoInicialNodo13 = 0;
	public static int contenidoInicialNodo14 = 2;
	public static int contenidoInicialNodo15 = 0;
	public static int contenidoInicialNodo16 = 0;
	public static int contenidoInicialNodo17 = 0;
	public static int contenidoInicialNodo18 = 0;
	public static int contenidoInicialNodo19 = 0;
	public static int contenidoInicialNodo20 = 0;
	public static int contenidoInicialNodo21 = 0;
	public static int contenidoInicialNodo22 = 0;
	public static int contenidoInicialNodo23 = 2;
	public static int contenidoInicialNodo24 = 3;
	public static int contenidoInicialNodo25 = 0;
	public static int contenidoInicialNodo26 = 0;
	public static int contenidoInicialNodo27 = 0;
	public static int contenidoInicialNodo28 = 0;
	public static int contenidoInicialNodo29 = 0;
	
	public static ArrayList<Integer> sucesoresNodo1 = new ArrayList<Integer>(List.of(2, 4));
	public static ArrayList<Integer> sucesoresNodo2 = new ArrayList<Integer>(List.of(1, 3));
	public static ArrayList<Integer> sucesoresNodo3 = new ArrayList<Integer>(List.of(2, 4));
	public static ArrayList<Integer> sucesoresNodo4 = new ArrayList<Integer>(List.of(1, 3, 5, 7));
	public static ArrayList<Integer> sucesoresNodo5 = new ArrayList<Integer>(List.of(6, 9));
	public static ArrayList<Integer> sucesoresNodo6 = new ArrayList<Integer>(List.of(5, 7));
	public static ArrayList<Integer> sucesoresNodo7 = new ArrayList<Integer>(List.of(4, 6, 8, 29));
	public static ArrayList<Integer> sucesoresNodo8 = new ArrayList<Integer>(List.of(7, 9, 11, 28));
	public static ArrayList<Integer> sucesoresNodo9 = new ArrayList<Integer>(List.of(5, 8, 10));
	public static ArrayList<Integer> sucesoresNodo10 = new ArrayList<Integer>(List.of(9));
	public static ArrayList<Integer> sucesoresNodo11 = new ArrayList<Integer>(List.of(8, 12, 28));
	public static ArrayList<Integer> sucesoresNodo12 = new ArrayList<Integer>(List.of(11, 13));
	public static ArrayList<Integer> sucesoresNodo13 = new ArrayList<Integer>(List.of(12, 14, 22, 26, 27));
	public static ArrayList<Integer> sucesoresNodo14 = new ArrayList<Integer>(List.of(13, 15, 16));
	public static ArrayList<Integer> sucesoresNodo15 = new ArrayList<Integer>(List.of(14));
	public static ArrayList<Integer> sucesoresNodo16 = new ArrayList<Integer>(List.of(14, 17));
	public static ArrayList<Integer> sucesoresNodo17 = new ArrayList<Integer>(List.of(16, 18, 22));
	public static ArrayList<Integer> sucesoresNodo18 = new ArrayList<Integer>(List.of(17, 19));
	public static ArrayList<Integer> sucesoresNodo19 = new ArrayList<Integer>(List.of(18, 20));
	public static ArrayList<Integer> sucesoresNodo20 = new ArrayList<Integer>(List.of(19, 21, 24));
	public static ArrayList<Integer> sucesoresNodo21 = new ArrayList<Integer>(List.of(20, 22));
	public static ArrayList<Integer> sucesoresNodo22 = new ArrayList<Integer>(List.of(13, 17, 21, 23));
	public static ArrayList<Integer> sucesoresNodo23 = new ArrayList<Integer>(List.of(22, 24));
	public static ArrayList<Integer> sucesoresNodo24 = new ArrayList<Integer>(List.of(20, 23, 25));
	public static ArrayList<Integer> sucesoresNodo25 = new ArrayList<Integer>(List.of(24, 26));
	public static ArrayList<Integer> sucesoresNodo26 = new ArrayList<Integer>(List.of(13, 25, 27, 29));
	public static ArrayList<Integer> sucesoresNodo27 = new ArrayList<Integer>(List.of(13, 26, 28));
	public static ArrayList<Integer> sucesoresNodo28 = new ArrayList<Integer>(List.of(8, 11, 27));
	public static ArrayList<Integer> sucesoresNodo29 = new ArrayList<Integer>(List.of(7, 26));

}
