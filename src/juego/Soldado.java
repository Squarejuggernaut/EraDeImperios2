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

		return this.estaVivo && otraUnidad.estaVivo &&
			   distancia <= 1.5 && distancia > 0 && !estaCansado();
	}

	@Override
	public void atacar(Unidad otraUnidad) {
		if (this.puedeAtacar(otraUnidad)) {
			otraUnidad.recibirDanio(DANIO);
			if (!otraUnidad.estaVivo)
				this.robarDinero(otraUnidad);
			this.energia -= 25;
		} else {
			this.descansar();
		}
	}

	private boolean estaCansado() {
		return this.energia == 0;
	}

	private void descansar() {
		this.energia = ENERGIA_MAXIMA;
	}
}
