package juego;

public class Arquero extends Unidad {
	private static final int DANIO = 7;
	private static final int CANTIDAD_MAXIMAS_FLECHAS = 3;
	private int flechas;

	public Arquero(Posicion posicion) {
		super(posicion);
		this.flechas = CANTIDAD_MAXIMAS_FLECHAS;
	}

	@Override
	public boolean puedeAtacar(Unidad otraUnidad) {
		double distancia = this.distanciaCon(otraUnidad);
		return distancia <= 25 && distancia >= 5 && tieneFlechas();
	}

	@Override
	public void atacar(Unidad otraUnidad) {
		if (this.puedeAtacar(otraUnidad)) {
			otraUnidad.recibirDanio();
			this.flechas--;
		} else {
			this.recargarFlechas();
		}
	}

	@Override
	public void recibirDanio() {
		this.salud -= DANIO;
	}

	private boolean tieneFlechas() {
		return this.flechas >= 1;
	}

	private void recargarFlechas() {
		this.flechas = CANTIDAD_MAXIMAS_FLECHAS;
	}
}
