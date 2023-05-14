package frsf.ia.tp1.pokemon.enemigos;

import frsf.ia.tp1.pokemon.Const;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EnemigoFinal {

	private int nodo;
	private int energia;
	
	public EnemigoFinal(int nodo) {
		this.nodo = nodo;
		this.energia = Const.vidaEnemigoFinal;
	}
}
