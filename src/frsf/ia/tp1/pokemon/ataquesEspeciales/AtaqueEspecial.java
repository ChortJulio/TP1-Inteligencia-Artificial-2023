package frsf.ia.tp1.pokemon.ataquesEspeciales;

import frsf.ia.tp1.pokemon.Const;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AtaqueEspecial {
	
	private int numeroAtaque;
	@ToString.Exclude
	private double porcentajeRecuperacionEnergia;
	private int turnosRestantesParaUtilizar;
	@ToString.Exclude
	private double porcentajeDeVidaNecesarioParaHabilitar;

	public void habilitarAtaqueEspecial(int energiaActual, int energiaInicial) {
		if (energiaActual >= energiaInicial * this.porcentajeDeVidaNecesarioParaHabilitar &&
			this.turnosRestantesParaUtilizar == -1) {
			this.turnosRestantesParaUtilizar = Const.cantidadTurnosParaUtilizarAtaque;
		}
	}
	
	public void usarAtaque() {
		this.turnosRestantesParaUtilizar = Const.cantidadTurnosParaUtilizarAtaque;
	}
	
	public void restarUnTurnoParaUtilizar() {
		if(this.turnosRestantesParaUtilizar > 0) {
			this.turnosRestantesParaUtilizar--;
		}
	}
	
	public AtaqueEspecial clone() {
		return new AtaqueEspecial(
				numeroAtaque, 
				porcentajeRecuperacionEnergia, 
				turnosRestantesParaUtilizar, 
				porcentajeDeVidaNecesarioParaHabilitar);
	}
	
	
}
