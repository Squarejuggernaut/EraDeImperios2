package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import juego.Posicion;
import juego.Unidad;

public class UnidadTests {
	Unidad u1;
	Unidad u2;
	
	@Before
	public void setUp() {
		u1 = new Unidad(new Posicion(0, 0));
		u2 = new Unidad(new Posicion(1, 1));
	}

	@Test
	public void construyeUnidad() {
		assertNotNull(u1);
		assertNotNull(u2);
	}
	
	@Test
	public void calculaDistanciaEntreUnidades() {
		assertEquals(Math.sqrt(2), u1.distanciaCon(u2), 0);
		assertEquals(1.414, u1.distanciaCon(u2), 0.001);
		Unidad u3 = new Unidad(new Posicion(-1, 6));
		Unidad u4 = new Unidad(new Posicion(6, -3));
		assertEquals(11.401, u3.distanciaCon(u4), 0.001);
	}
	
	@Test
	public void puedeAtacarTest() {
		assertTrue(u1.puedeAtacar(u2));
		Unidad u3 = new Unidad(new Posicion(1.5, 1.5));
		assertFalse(u1.puedeAtacar(u3)); // Da 2.121
		Unidad u4 = new Unidad(new Posicion(1.4, 1.4));
		assertTrue(u1.puedeAtacar(u4)); // 1.979
	}
	
	@Test
	public void atacarYHaceDanioTest() {
		assertEquals(100, u2.getSalud());
		u1.atacar(u2);
		assertEquals(90, u2.getSalud());
		u1.atacar(u2);
		assertEquals(80, u2.getSalud());
	}
	
	@Test
	public void atacaFueraDeRangoNoHaceDanio() {
		Unidad u3 = new Unidad(new Posicion(2, 2));
		assertEquals(100, u3.getSalud());
		u1.atacar(u3);
		assertEquals(100, u3.getSalud());
	}
}
