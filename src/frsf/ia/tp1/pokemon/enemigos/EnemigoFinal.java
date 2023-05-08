package frsf.ia.tp1.pokemon.enemigos;

import frsf.ia.tp1.pokemon.Const;
import lombok.ToString;

@ToString
public class EnemigoFinal {

	private int nodo;
	private int energia;
	
	public EnemigoFinal(int nodo) {
		this.nodo = nodo;
		this.energia = Const.randomBetween(Const.vidaMaximoEnemigoFinal, Const.vidaMinimoEnemigoFinal);
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
