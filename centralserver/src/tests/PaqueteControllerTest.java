package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import excepciones.PaqueteConMismoNombreException;
import logica.HandlerPaquetes;
import logica.Paquete;
import logica.PaqueteController;

class PaqueteControllerTest {
	
	PaqueteController ipaq = new PaqueteController();

	@Test
	void testCrearPaqueteWeb() {
		try {
			ipaq.crearPaqueteWeb("Paquete de Pandas", "", LocalDate.of(2020, 12, 1), LocalDate.of(2020, 12, 10), 15, LocalDate.of(2020, 11, 10), "");
		} catch (PaqueteConMismoNombreException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
			e.printStackTrace();
		}
		assertTrue(ipaq.getPaquete().getNombre().equals("Paquete de Pandas"));
	}
	
	@Test
	void testCrearPaqueteWebRepetido() {
		try {
			Paquete paq = new Paquete("bandas2",LocalDate.of(2020, 12, 1),  LocalDate.of(2020, 12, 10), 15, "", LocalDate.of(2020, 11, 10), "");
			HandlerPaquetes hpaq = HandlerPaquetes.getInstance();
			hpaq.agregarPaquete(paq);
			ipaq.crearPaqueteWeb("bandas2", "", LocalDate.of(2020, 12, 1), LocalDate.of(2020, 12, 10), 15, LocalDate.of(2020, 11, 10), "");

		} catch (PaqueteConMismoNombreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertThrows(PaqueteConMismoNombreException.class, ()->ipaq.crearPaqueteWeb("bandas2", "", LocalDate.of(2020, 12, 1), LocalDate.of(2020, 12, 10), 15, LocalDate.of(2020, 11, 10), ""));
		
	}

}
