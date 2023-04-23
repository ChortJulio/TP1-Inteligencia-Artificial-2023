package frsf.ia.tp1.pokemon.enemigos;

import java.util.Random;

import frsf.ia.tp1.pokemon.Const;

public class Enemigo {

	private int nodo;
	private int energia;
	private int turnosHastaMoverse;
	
	private Random randomGenerator = new Random(Const.seed);
	
	public Enemigo(int nodo) {
		this.nodo = nodo;
		this.energia = this.randomGenerator.nextInt(Const.vidaMaximoEnemigo - Const.vidaMinimoEnemigo + 1) + Const.vidaMinimoEnemigo;
		this.turnosHastaMoverse = this.randomGenerator.nextInt(Const.turnosMaximoHastaMoverseEnemigo) + Const.turnosMinimoHastaMoverseEnemigo;
	}
	
	public int getNodo() {
		return nodo;
	}
	public void setNodo(int nodo) {
		this.nodo = nodo;
	}
	public int getEnergia() {
		return energia;
	}
	public void setEnergia(int energia) {
		this.energia = energia;
	}
	public int getTurnosHastaMoverse() {
		return turnosHastaMoverse;
	}
	public void setTurnosHastaMoverse(int turnosHastaMoverse) {
		this.turnosHastaMoverse = turnosHastaMoverse;
	}
}
