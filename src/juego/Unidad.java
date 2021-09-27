package juego;

public abstract class Unidad {
	protected Posicion posicion;
	protected int salud;
	protected int dinero;
	protected boolean estaVivo;
	private static final int SALUD_INICIAL = 100;
	private static final int DINERO_INICIAL = 20;

	public Unidad(Posicion posicion) {
		this.posicion = posicion;
		this.salud = SALUD_INICIAL;
		this.dinero = DINERO_INICIAL;
		this.estaVivo = true;
	}

	public int getSalud() {
		return this.salud;
	}

	public int getDinero() {
		return this.dinero;
	}

	public double distanciaCon(Unidad otraUnidad) {
		return this.posicion.calculadorDistancias(otraUnidad.posicion);
	}

	protected void recibirDanio(int danio) {
		this.salud -= danio;
		if (this.salud <= 0)
			this.estaVivo = false;
	}

	protected void robarDinero(Unidad otraUnidad) {
		this.dinero += otraUnidad.dinero;
		otraUnidad.dinero = 0;
	}
	
	public void comprarPocion() {
		int costoPocion = 30;
		if (this.dinero >= costoPocion) {
			this.dinero -= costoPocion;
			this.salud = SALUD_INICIAL;
		}
	}

	public abstract boolean puedeAtacar(Unidad otraUnidad);

	public abstract void atacar(Unidad otraUnidad);

}
