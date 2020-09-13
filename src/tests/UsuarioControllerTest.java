package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import logica.HandlerUsuarios;
import logica.UsuarioController;

class UsuarioControllerTest {
	
	private static UsuarioController icontroller;
	private static HandlerUsuarios hu;
	
	@BeforeAll
	static void iniciar() {
		// aca no use la fabrica porque sino no tenemos getters y setters para testear
		icontroller = new UsuarioController();
		
	}

	@Test
	void testAltaUsuario() {
		LocalDate fechanac = LocalDate.of(2000, 03, 29);
		icontroller.altaUsuario("santiacq", "santiago", "acquarone", "santiacquarone@gmail.com", fechanac);
		assertEquals(icontroller.getUsuario().getNickname(), "santiacq");
		assertEquals(icontroller.getUsuario().getNombre(), "santiago");
		assertEquals(icontroller.getUsuario().getApellido(), "acquarone");
		assertEquals(icontroller.getUsuario().getEmail(), "santiacquarone@gmail.com");
		assertEquals(icontroller.getUsuario().getFechaNacimiento(), fechanac);
	}

	@Test
	void testAltaArtista() {
		LocalDate fechanac = LocalDate.of(2000, 03, 29);
		icontroller.altaUsuario("santiacq", "santiago", "acquarone", "santiacquarone@gmail.com", fechanac);
		icontroller.altaArtista("el number 1", "...", "acqua.com");
		assertEquals(icontroller.getArtista().getDescripcion(), "el number 1");
		assertEquals(icontroller.getArtista().getBiografia(), "...");
		assertEquals(icontroller.getArtista().getWebsite(), "acqua.com");
	}

	@Test
	void testConfirmarAltaUsuarioArtista() {
		LocalDate fechanac = LocalDate.of(2000, 03, 29);
		icontroller.altaUsuario("santiacq", "santiago", "acquarone", "santiacquarone@gmail.com", fechanac);
		icontroller.altaArtista("el number 1", "...", "acqua.com");
		icontroller.confirmarAltaUsuario();
		
		hu = HandlerUsuarios.getInstancia();
		assertTrue(hu.getUsuarios().containsKey("santiacq"));
		assertTrue(hu.getUsuario("santiacq").esArtista() == true);
	}
	
	@Test
	void testConfirmarAltaUsuarioUsuario() {
		hu = HandlerUsuarios.getInstancia();
		LocalDate fechanac = LocalDate.of(2000, 03, 29);
		icontroller.altaUsuario("santiacq", "santiago", "acquarone", "santiacquarone@gmail.com", fechanac);
		icontroller.confirmarAltaUsuario();
		
		assertTrue(hu.getUsuarios().containsKey("santiacq"));
		assertTrue(hu.getUsuario("santiacq").esArtista() == false);
	}

	
	/*

	@Test
	void testMostrarDatos() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateUsuario() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateArtista() {
		fail("Not yet implemented");
	}

	@Test
	void testConfirmarUpdateUsuario() {
		fail("Not yet implemented");
	}
	*/
	
}
