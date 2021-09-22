package juego;

public class Unidad {
	private Posicion posicion;
	
	public Unidad(Posicion posicion) {
		this.posicion = posicion;
	}
	
	public int distanciaCon(Unidad otraUnidad) {
		return this.posicion.calculadorDistancias(otraUnidad.posicion);
	}

	@Override
	public String toString() {
		return "(" + posicion + ")";
	}
}
