package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import juego.*;

public class CaballeroTests {
	Unidad c1, c2, c3;
	
	@Before
	public void setUp() {
		c1 = new Caballero(new Posicion(0, 0));
		c2 = new Caballero(new Posicion(1, 1));
		c3 = new Caballero(new Posicion(2, 2));
	}

	@Test
	public void construyeUnidadCaballero() {
		assertNotNull(c1);
		assertNotNull(c2);
	}
	
	@Test
	public void calculaDistanciaEntreUnidades() {
		assertEquals(Math.sqrt(2), c1.distanciaCon(c2), 0);
		assertEquals(1.414, c1.distanciaCon(c2), 0.001);
		Unidad u3 = new Caballero(new Posicion(-1, 6));
		Unidad u4 = new Caballero(new Posicion(6, -3));
		assertEquals(11.401, u3.distanciaCon(u4), 0.001);
	}
	
	@Test
	public void caballeroPuedeAtacarTest() {
		assertTrue(c1.puedeAtacar(c2));
		Unidad s3 = new Soldado(new Posicion(1.5, 1.5));
		assertTrue(c1.puedeAtacar(s3)); // distancia: 2.121
		Unidad a4 = new Arquero(new Posicion(1.4, 1.4));
		assertTrue(c1.puedeAtacar(a4)); // 1.979
	}
	
	@Test
	public void caballeroAtacaYHaceDanioTest() {
		assertEquals(100, c2.getSalud());
		c1.atacar(c2);
		assertEquals(70, c2.getSalud());
		c1.atacar(c2);
		assertEquals(40, c2.getSalud());
		c1.atacar(c2);
		assertEquals(10, c2.getSalud());
		c1.atacar(c3);
		assertEquals(70, c3.getSalud());
		c1.atacar(c3);
		assertEquals(70, c3.getSalud());
	}
	
	@Test
	public void caballeroAtacaFueraDeRangoNoHaceDanio() {
		Unidad s3 = new Soldado(new Posicion(2.5, 2.5));
		assertEquals(100, s3.getSalud());
		c1.atacar(s3); //ditancia: 3.535
		assertEquals(100, s3.getSalud());
	}
}
