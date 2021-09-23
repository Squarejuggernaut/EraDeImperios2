package juego;

public class Arquero extends Unidad {
	private static final int DANIO = 7;

	public Arquero(Posicion posicion) {
		super(posicion);
	}

	@Override
	public boolean puedeAtacar(Unidad otraUnidad) {
		return this.distanciaCon(otraUnidad) <= 25 &&
			   this.distanciaCon(otraUnidad) >= 5;
	}

	@Override
	public void recibirDanio() {
		this.salud -= DANIO;
	}
}
