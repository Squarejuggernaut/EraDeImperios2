package juego;

public class Caballero extends Unidad {
	private static final int DANIO = 30;
	private static final int VALENTIA_COMPLETA = 100;
	private int valentia;

	public Caballero(Posicion posicion) {
		super(posicion);
		this.valentia = VALENTIA_COMPLETA;
	}

	@Override
	public boolean puedeAtacar(Unidad otraUnidad) {
		double distancia = this.distanciaCon(otraUnidad);
		return distancia <= 3 && distancia >= 1 && !caballoEstaAsustado();
	}

	@Override
	public void atacar(Unidad otraUnidad) {
		if (this.puedeAtacar(otraUnidad)) {
			otraUnidad.recibirDanio();
			this.valentia -= 25;
		} else {
			this.huir();
			this.calmar();
		}
	}

	@Override
	public void recibirDanio() {
		this.salud -= DANIO;
	}

	private boolean caballoEstaAsustado() {
		return this.valentia == 0;
	}

	private void huir() {
		if (caballoEstaAsustado()) {
			if (Math.random() >= 0.5)
				this.posicion.desplazar(2, 1);
			else
				this.posicion.desplazar(-1, 2);
		}
	}
	
	private void calmar() {
		this.valentia = VALENTIA_COMPLETA;
	}

}
