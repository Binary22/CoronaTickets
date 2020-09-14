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
			icontroller.altaUsuario("santiacq3", "santiago", "acquarone", "santiacquarone@gmail.com", fechanac);
		} catch (UsuarioConMismoNickException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UsuarioConMismoMailException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		icontroller.altaArtista("el number 1", "...", "acqua.com");
		assertEquals(icontroller.getArtista().getDescripcion(), "el number 1");
		assertEquals(icontroller.getArtista().getBiografia(), "...");
		assertEquals(icontroller.getArtista().getWebsite(), "acqua.com");
	}
	
	@Test
	void testAltaUsuarioMismoMail() {
		LocalDate fechanac = LocalDate.of(2000, 03, 29);
		try {
		icontroller.altaUsuario("santiacqua", "santiago", "acquarone", "santiacquarone@gmail.com", fechanac);
		} catch(UsuarioConMismoMailException e1) {
			e1.printStackTrace();
		} catch(UsuarioConMismoNickException e2) {
			e2.printStackTrace();
		}
		assertThrows(UsuarioConMismoMailException.class, () -> icontroller.altaUsuario("santiacqua", "santiago", "acquarone", "santiacquarone@gmail.com", fechanac));
		}
	
	@Test
	void testAltaUsuarioMismoNick() {
		LocalDate fechanac = LocalDate.of(2000, 03, 29);
		try {
		icontroller.altaUsuario("santiacq", "santiago", "acquarone", "santiacquarone@gmail.com", fechanac);
		} catch(UsuarioConMismoMailException e1) {
			e1.printStackTrace();
		} catch(UsuarioConMismoNickException e2) {
			e2.printStackTrace();
		}
		assertThrows(UsuarioConMismoNickException.class, () -> icontroller.altaUsuario("santiacq", "santiago", "acquarone", "santiacquarone@gmail.com", fechanac));
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
		
		assertTrue(hu.getUsuarios().containsKey("santiacq"));
		assertTrue(hu.getUsuario("santiacq").esArtista() == false);
	}
	
	@Test
	void testSettersGetters() {
		icontroller.setApellido("Gonzalez");
		icontroller.setNombre("Joaquin");
		icontroller.setEmail("jotaseis@gmail.com");
		icontroller.setFechaNacimiento(LocalDate.of(1997, 04, 19));
		assertTrue(icontroller.getApellido().equals("Gonzalez"));
		assertTrue(icontroller.getNombre().equals("Joaquin"));
		assertTrue(icontroller.getEmail().equals("jotaseis@gmail.com"));
		assertTrue(icontroller.getFechaNacimiento().equals(LocalDate.of(1997, 04, 19)));
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
