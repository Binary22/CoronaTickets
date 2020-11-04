package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import logica.Espectaculo;
import logica.HandlerEspectaculos;
import logica.HandlerUsuarios;

class HandlerEspectaculosTest {

	private static HandlerEspectaculos he;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		he = HandlerEspectaculos.getInstance();
	}

	@Test
	void testListarEspectaculosAceptados() {
		Espectaculo e1 = new Espectaculo("harry", LocalTime.now(), "", 1, 2,"", LocalDate.now(), 2);
		e1.setYaFueValuado(true);
		e1.setAceptado(true);
		Espectaculo e2 = new Espectaculo("emma", LocalTime.now(), "", 1, 2,"", LocalDate.now(), 2);
		e2.setYaFueValuado(true);
		e2.setAceptado(true);
		he.addEspectaculo(e1);
		he.addEspectaculo(e2);
		Map<String, Espectaculo> especs = he.listarEspectaculosAceptados();
		assertTrue(especs.keySet().contains(e1.getNombre()));
		assertTrue(especs.keySet().contains(e2.getNombre()));

		

	}

	@Test
	void testBuscarEspectaculos() {
		Espectaculo e1 = new Espectaculo("harry", LocalTime.now(), "", 1, 2,"", LocalDate.now(), 2);
		he.addEspectaculo(e1);
		assertTrue(he.buscarEspectaculos("harry").contains(e1));
	}

	

}
