package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import juego.Posicion;

public class PosicionTests {

	@Test
	public void crearPosicion() {
		Posicion p1 = new Posicion(1, 1);
		assertNotNull(p1);
		Posicion p2 = new Posicion(-1, -1);
		assertNotNull(p2);
	}
	
	@Test
	public void calculadorDeDistanciasTest() {
		Posicion p1 = new Posicion(-1, 6);
		Posicion p2 = new Posicion(6, -3);
		assertEquals(11.401, p1.calculadorDistancias(p2), 0.001);
		Posicion p3 = new Posicion(-4, -1);
		Posicion p4 = new Posicion(-6,-3);
		assertEquals(2.828, p3.calculadorDistancias(p4), 0.001);
		Posicion p5 = new Posicion(1, 1);
		Posicion p6 = new Posicion(6, 3);
		assertEquals(5.385, p5.calculadorDistancias(p6), 0.001);
	}

}
