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
	
	public abstract boolean puedeAtacar(Unidad otraUnidad);
	
	public abstract void atacar(Unidad otraUnidad);

	public abstract void recibirDanio();
	
}
