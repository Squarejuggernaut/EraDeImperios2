package juego;

public class Unidad {
	private Posicion posicion;
	private int salud;
	
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
	
	public boolean puedeAtacar(Unidad otraUnidad) {
		return this.distanciaCon(otraUnidad) < 2;
	}
	
	public void atacar(Unidad otraUnidad) {
		if (this.puedeAtacar(otraUnidad))
			otraUnidad.recibirDanio();
	}

	public void recibirDanio() {
		this.salud -= 10;
	}

	@Override
	public String toString() {
		return "(" + posicion + ")";
	}
	
}
