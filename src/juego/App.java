package juego;

public class App {

	public static void main(String[] args) {
		Posicion p1 = new Posicion(1, 6);
		System.out.println(p1);
		Posicion p2 = new Posicion(6, 3);
		System.out.println(p2);
		System.out.println(p1.calculadorDistancias(p2));
		
		System.out.println("---------");
		
		Unidad u1 = new Unidad(new Posicion(0, 0));
		System.out.println(u1);
		Unidad u2 = new Unidad(new Posicion(1, 1));
		System.out.println(u2);
		System.out.println(u1.distanciaCon(u2));
	}

}
