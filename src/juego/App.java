package juego;

public class App {

	public static void main(String[] args) {
		Posicion p1 = new Posicion(1, 6);
		System.out.println(p1);
		Posicion p2 = new Posicion(6, 3);
		System.out.println(p2);
		System.out.println(p1.calculadorDistancias(p2));
		
		System.out.println("---------");
		
		Unidad u1 = new Caballero(new Posicion(0, 0));
		System.out.println(u1);
		Unidad u2 = new Caballero(new Posicion(1.9, 1.9));
		System.out.println(u2);
		Unidad u3 = new Caballero(new Posicion(1.4, 1.4));
		System.out.println(u1.distanciaCon(u2));
		System.out.println(u1.puedeAtacar(u2)); // false
		System.out.println(u1.puedeAtacar(u3)); // true
		
		System.out.println("---------");
		System.out.println(u2.getSalud());
		u1.atacar(u2);
		System.out.println(u2.getSalud());
	}

}
