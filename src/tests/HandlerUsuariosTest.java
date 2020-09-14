package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import logica.HandlerUsuarios;

class HandlerUsuariosTest {
	
	private static HandlerUsuarios hu;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		presentacion.Principal.cargarDatos();
		hu = HandlerUsuarios.getInstancia();
	}

	@Test
	void testGetNombresArtista() {
		ArrayList<String> l = hu.getNombresArtista();
		assertTrue(l.contains("lachiqui"));
	}
	
	@Test
	void testGetNombresArtistas() {
		ArrayList<String> l = hu.getNombresArtistas();
		assertTrue(l.contains("vpeople"));
	}
	
	
	
	@Test
	void testExisteUsuario() {
		fail("Not yet implemented");
	}

	@Test
	void testAgregarUsuario() {
		fail("Not yet implemented");
	}

	@Test
	void testEsArtista_() {
		fail("Not yet implemented");
	}

	@Test
	void testListarFuncionesQueSeRegistro() {
		fail("Not yet implemented");
	}

	@Test
	void testListarFuncionesDtQueSeRegistro() {
		fail("Not yet implemented");
	}

	@Test
	void testExisteMail() {
		fail("Not yet implemented");
	}

}
