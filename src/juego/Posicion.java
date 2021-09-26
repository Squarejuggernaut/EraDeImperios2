package juego;

public class Posicion {
	private double ejeX;
	private double ejeY;

	public Posicion(double ejeX, double ejeY) {
		this.ejeX = ejeX;
		this.ejeY = ejeY;
	}
	
	public double calculadorDistancias(Posicion otroPunto) {
		return Math.sqrt(Math.pow(this.ejeX - otroPunto.ejeX, 2) +
			   Math.pow(this.ejeY - otroPunto.ejeY, 2));
	}
	
	public void desplazar(double nuevoX, double nuevoY) {
		this.ejeX += nuevoX;
		this.ejeY += nuevoY;
	}

	@Override
	public String toString() {
		return "(" + ejeX + ", " + ejeY + ")";
	}
}
