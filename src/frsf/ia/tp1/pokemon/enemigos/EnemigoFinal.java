package frsf.ia.tp1.pokemon.enemigos;

import java.util.Random;

import frsf.ia.tp1.pokemon.Const;

public class EnemigoFinal {

	private int nodo;
	private int energia;
	
	private Random randomGenerator = new Random(Const.seed);
	
	public EnemigoFinal() {
		this.nodo = Const.nodoPosicionEnemigoFinal;
		this.energia = this.randomGenerator.nextInt(Const.vidaMaximoEnemigoFinal - Const.vidaMinimoEnemigoFinal + 1) + Const.vidaMinimoEnemigoFinal;
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
}
