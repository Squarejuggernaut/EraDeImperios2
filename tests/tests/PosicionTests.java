package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import juego.Posicion;

public class PosicionTests {

	@Test
	public void crearPosicion() {
		Posicion p1 = new Posicion(1, 1);
		assertNotNull(p1);
	}

}
