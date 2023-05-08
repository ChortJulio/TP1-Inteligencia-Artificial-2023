package frsf.ia.tp1.pokemon.pokeparadas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Pokeparada {
	
	private int nodo;
	private int turnosParaRestablecerse;
	
	public void restarTurnoParaRestablerse() {
		this.turnosParaRestablecerse -= 1;
	}
}
