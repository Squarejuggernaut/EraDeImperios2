package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import juego.*;

public class SoldadoTests {
Unidad s1, s2, s3;
	
	@Before
	public void setUp() {
		s1 = new Soldado(new Posicion(0, 0));
		s2 = new Soldado(new Posicion(1, 1));
		s3 = new Soldado(new Posicion(2, 2));
	}

	@Test
	public void creaSoldadosTest() {
		assertNotNull(s1);
		assertNotNull(s2);
		assertNotNull(s3);
	}
	
	@Test
	public void soldadoPuedeAtacar() {
		Unidad c1 = new Caballero(new Posicion(6, 6));
		assertFalse(s1.puedeAtacar(c1)); // 8.485
		Unidad a1 = new Arquero(new Posicion(0.5, 0.2));
		assertTrue(s1.puedeAtacar(a1)); // 26.870
		assertTrue(s2.puedeAtacar(s1)); // 2
	}
	
	@Test
	public void atacar() {
		s2.atacar(s3);
		assertEquals(80, s3.getSalud());
		s2.atacar(s3);
		assertEquals(60, s3.getSalud());
		s2.atacar(s3);
		assertEquals(40, s3.getSalud());
		s2.atacar(s3);
		assertEquals(20, s3.getSalud());
		s2.atacar(s3); // Soldado esta cansado en vez de atacar va a reponer energias
		assertEquals(20, s3.getSalud());
		s2.atacar(s1); // Una vez descansado puede seguir atacando
		assertEquals(80, s1.getSalud());
	}
}
