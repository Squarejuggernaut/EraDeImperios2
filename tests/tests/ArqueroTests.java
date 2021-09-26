package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import juego.*;

public class ArqueroTests {
	Unidad a1, a2, a3;
	
	@Before
	public void setUp() {
		a1 = new Arquero(new Posicion(0, 0));
		a2 = new Arquero(new Posicion(1, 1));
		a3 = new Arquero(new Posicion(-10, 10));
	}

	@Test
	public void creaArquerosTest() {
		assertNotNull(a1);
		assertNotNull(a2);
		assertNotNull(a3);
	}
	
	@Test
	public void arqueroPuedeAtacar() {
		Unidad c1 = new Caballero(new Posicion(6, 6));
		assertTrue(a1.puedeAtacar(c1)); // 8.485
		Unidad s1 = new Soldado(new Posicion(20, 20));
		assertFalse(a1.puedeAtacar(s1)); // 26.870
		assertFalse(a2.puedeAtacar(a1)); // 2
	}
	
	@Test
	public void atacar() {
		a1.atacar(a3);
		assertEquals(93, a3.getSalud());
		a1.atacar(a3);
		assertEquals(86, a3.getSalud());
		a1.atacar(a3);
		assertEquals(79, a3.getSalud());
		a1.atacar(a3); // Sin flechas en vez de atacar recarga
		assertEquals(79, a3.getSalud());
		a1.atacar(a3); // Ahora si puede seguir atacando y hacer daño
		assertEquals(72, a3.getSalud());
	}

}
