package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import juego.Posicion;
import juego.Unidad;

public class UnidadTests {

	@Test
	public void construyeUnidad() {
		Unidad u1 = new Unidad(new Posicion(0, 0));
		assertNotNull(u1);
		Unidad u2 = new Unidad(new Posicion(1, 1));
		assertNotNull(u2);
	}
	
	@Test
	public void calculaDistanciaEntreUnidades() {
		Unidad u1 = new Unidad(new Posicion(0, 0));
		Unidad u2 = new Unidad(new Posicion(1, 1));
		assertEquals((int)Math.sqrt(2), u1.distanciaCon(u2));
		assertEquals(1, u1.distanciaCon(u2));
		
		Unidad u3 = new Unidad(new Posicion(-1, 6));
		Unidad u4 = new Unidad(new Posicion(6, -3));
		assertEquals(11, u3.distanciaCon(u4));
	}
}
