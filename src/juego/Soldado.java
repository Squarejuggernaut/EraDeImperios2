package juego;

public class Soldado extends Unidad {
	private static final int DANIO = 20;

	public Soldado(Posicion posicion) {
		super(posicion);
	}

	@Override
	public boolean puedeAtacar(Unidad otraUnidad) {
		return this.distanciaCon(otraUnidad) <= 1.5 &&
		       this.distanciaCon(otraUnidad) > 0;
	}

	@Override
	public void recibirDanio() {
		this.salud -= DANIO;
	}
}
