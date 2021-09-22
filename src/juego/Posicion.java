package juego;

public class Posicion {
	private int ejeX;
	private int ejeY;

	public Posicion(int ejeX, int ejeY) {
		this.ejeX = ejeX;
		this.ejeY = ejeY;
	}
	
	public int calculadorDistancias(Posicion otroPunto) {
		return (int) Math.sqrt(Math.pow(this.ejeX - otroPunto.ejeX, 2) +
					 Math.pow(this.ejeY - otroPunto.ejeY, 2));
	}

	@Override
	public String toString() {
		return "(" + ejeX + ", " + ejeY + ")";
	}
}
