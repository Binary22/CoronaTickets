package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import excepciones.UsuarioConMismoMailException;
import excepciones.UsuarioConMismoNickException;
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
		try {
			icontroller.altaUsuario("santiacq", "santiago", "acquarone", "santiacquarone@gmail.com", fechanac);
		} catch (UsuarioConMismoNickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UsuarioConMismoMailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(icontroller.getUsuario().getNickname(), "santiacq");
		assertEquals(icontroller.getUsuario().getNombre(), "santiago");
		assertEquals(icontroller.getUsuario().getApellido(), "acquarone");
		assertEquals(icontroller.getUsuario().getEmail(), "santiacquarone@gmail.com");
		assertEquals(icontroller.getUsuario().getFechaNacimiento(), fechanac);
	}

	@Test
	void testAltaArtista() {
		LocalDate fechanac = LocalDate.of(2000, 03, 29);
		try {
			icontroller.altaUsuario("santiacq", "santiago", "acquarone", "santiacquarone@gmail.com", fechanac);
		} catch (UsuarioConMismoNickException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UsuarioConMismoMailException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			icontroller.altaArtista("el number 1", "...", "acqua.com");
		} catch (UsuarioConMismoNickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(icontroller.getArtista().getDescripcion(), "el number 1");
		assertEquals(icontroller.getArtista().getBiografia(), "...");
		assertEquals(icontroller.getArtista().getWebsite(), "acqua.com");
	}

	@Test
	void testConfirmarAltaUsuarioArtista() {
		LocalDate fechanac = LocalDate.of(2000, 03, 29);
		try {
			icontroller.altaUsuario("santiacq", "santiago", "acquarone", "santiacquarone@gmail.com", fechanac);
		} catch (UsuarioConMismoNickException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UsuarioConMismoMailException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			icontroller.altaArtista("el number 1", "...", "acqua.com");
		} catch (UsuarioConMismoNickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		icontroller.confirmarAltaUsuario();
	}
	
	@Test
	void testConfirmarAltaUsuarioUsuario() {
		LocalDate fechanac = LocalDate.of(2000, 03, 29);
		try {
			icontroller.altaUsuario("santiacq", "santiago", "acquarone", "santiacquarone@gmail.com", fechanac);
		} catch (UsuarioConMismoNickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UsuarioConMismoMailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		icontroller.confirmarAltaUsuario();
	}

	/*
	@Test
	void testMostrarUsuarios() {
		fail("Not yet implemented");
	}

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
