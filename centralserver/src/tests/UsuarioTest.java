package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import excepciones.UsuarioPaqueteComprado;
import logica.Compra;
import logica.Espectaculo;
import logica.Funcion;
import logica.Paquete;
import logica.Registro;
import logica.Usuario;
import logica.Vale;

class UsuarioTest {
	
	

	@Test
	void testGetRegistrosPreviosWeb() {
		Usuario user = new Usuario("peter", "a", "b", "c", LocalDate.of(1999, 12, 14), "g","");
		Espectaculo espect = new Espectaculo("hola", LocalTime.MIDNIGHT, "", 2, 10,"", LocalDate.of(2020, 11, 17), 3);
		Funcion fun = new Funcion("hola", LocalDate.now(), LocalTime.MIDNIGHT, LocalDate.of(2020, 12, 23), null, espect);
		Registro reg = new Registro(LocalDate.now(), false, user, fun, 23);
		user.addFuncion(reg);
		assertEquals(user.getRegistrosPreviosWeb().get(0), reg);
	}

	@Test
	void testValesACanjear() {
		Usuario user = new Usuario("maifol", "a", "b", "c", LocalDate.of(1999, 12, 14), "g","");
		Espectaculo espect = new Espectaculo("ja", LocalTime.MIDNIGHT, "", 2, 10,"", LocalDate.of(2020, 11, 17), 3);
		Vale val = new Vale();
		Paquete paq = new Paquete("bands", LocalDate.of(2020, 9, 16), LocalDate.of(2020, 12, 6), 15, "", LocalDate.of(2020, 9, 16));
		val.setUsado(false);
		val.setEspectaculo(espect);
		val.setPaquete(paq);
		user.getVales().add(val);
		assertTrue(user.valesACanjear("ja").contains(val));
	}

	@Test
	void testAgregarcompra() {
		Usuario user = new Usuario("harry", "a", "b", "c", LocalDate.of(1999, 12, 14), "g","");
		Espectaculo espect = new Espectaculo("jaja", LocalTime.MIDNIGHT, "", 2, 10,"", LocalDate.of(2020, 11, 17), 3);		
		Paquete paq = new Paquete("bands", LocalDate.of(2020, 9, 16), LocalDate.of(2020, 12, 6), 15, "", LocalDate.of(2020, 9, 16));
		paq.getEspectaculos().put(espect.getNombre(), espect);
		Compra comp = new Compra(LocalDate.of(2020, 10, 2), paq);
		try {
			user.agregarcompra(comp);
		} catch (UsuarioPaqueteComprado e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
			e.printStackTrace();
		}
		assertThrows(UsuarioPaqueteComprado.class, ()->user.agregarcompra(comp));
		
	}

}
