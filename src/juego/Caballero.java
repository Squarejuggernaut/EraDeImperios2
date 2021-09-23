package juego;

public class Caballero extends Unidad {
	private static final int DANIO = 30;

	public Caballero(Posicion posicion) {
		super(posicion);
	}
	
	@Override
	public boolean puedeAtacar(Unidad otraUnidad) {
		return this.distanciaCon(otraUnidad) <= 3 &&
			   this.distanciaCon(otraUnidad) >= 1;
	}

	@Override
	public void recibirDanio() {
		this.salud -= DANIO;		
	}
}
