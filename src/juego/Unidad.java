package juego;

public abstract class Unidad {
	protected Posicion posicion;
	protected int salud;
	private static final int SALUD_INICIAL = 100;
	
	public Unidad(Posicion posicion) {
		this.posicion = posicion;
		this.salud = SALUD_INICIAL;
	}

	public int getSalud() {
		return this.salud;
	}
	
	public double distanciaCon(Unidad otraUnidad) {
		return this.posicion.calculadorDistancias(otraUnidad.posicion);
	}
	
	public void atacar(Unidad otraUnidad) {
		if (this.puedeAtacar(otraUnidad))
			otraUnidad.recibirDanio();
	}
	
	public abstract boolean puedeAtacar(Unidad otraUnidad);

	public abstract void recibirDanio();

	@Override
	public String toString() {
		return "(" + posicion + ")";
	}
	
}
