package frsf.ia.tp1.pokemon.enemigos;

import frsf.ia.tp1.pokemon.Const;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Enemigo {

	private int nodo;
	private int energia;
	private int turnosHastaMoverse;
	
	public Enemigo(int nodo) {
		this.nodo = nodo;
		this.energia = Const.randomBetween(Const.vidaMaximoEnemigo, Const.vidaMinimoEnemigo);
		this.turnosHastaMoverse = Const.randomBetween(Const.turnosMaximoHastaMoverseEnemigo, Const.turnosMinimoHastaMoverseEnemigo);
	}
	
	public void restarTurnoParaRestablerse() {
		this.turnosHastaMoverse -= 1;
	}
}
