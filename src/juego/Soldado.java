package juego;

public class Soldado extends Unidad {
	private static final int DANIO = 20;
	private static final int ENERGIA_MAXIMA = 100;
	private int energia;

	public Soldado(Posicion posicion) {
		super(posicion);
		this.energia = ENERGIA_MAXIMA;
	}

	@Override
	public boolean puedeAtacar(Unidad otraUnidad) {
		double distancia = this.distanciaCon(otraUnidad);
		return distancia <= 1.5 && distancia > 0 && !estaCansado();
	}

	@Override
	public void atacar(Unidad otraUnidad) {
		if (this.puedeAtacar(otraUnidad)) {
			otraUnidad.recibirDanio();
			this.energia -= 25;
		} else {
			this.descansar();
		}
	}

	@Override
	public void recibirDanio() {
		this.salud -= DANIO;
	}

	private boolean estaCansado() {
		return this.energia == 0;
	}

	private void descansar() {
		this.energia = ENERGIA_MAXIMA;
	}
}
