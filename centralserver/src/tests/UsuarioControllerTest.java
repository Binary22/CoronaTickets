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
			icontroller.altaUsuario("santiacq1", "santiago", "acquarone", "santiacquarone1@gmail.com", fechanac);
		} catch (UsuarioConMismoNickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UsuarioConMismoMailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(icontroller.getUsuario().getNickname(), "santiacq1");
		assertEquals(icontroller.getUsuario().getNombre(), "santiago");
		assertEquals(icontroller.getUsuario().getApellido(), "acquarone");
		assertEquals(icontroller.getUsuario().getEmail(), "santiacquarone1@gmail.com");
		assertEquals(icontroller.getUsuario().getFechaNacimiento(), fechanac);
	}
	
	@Test
	void testAltaUsuarioWeb() {
		LocalDate fechanac = LocalDate.of(2000, 03, 29);
		try {
			icontroller.altaUsuarioWeb("santiacq2", "santiago", "acquarone", "santiacquarone2@gmail.com", fechanac, "passw0rd", "1.jpeg");
		} catch (UsuarioConMismoNickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UsuarioConMismoMailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(icontroller.getUsuario().getNickname(), "santiacq2");
		assertEquals(icontroller.getUsuario().getNombre(), "santiago");
		assertEquals(icontroller.getUsuario().getApellido(), "acquarone");
		assertEquals(icontroller.getUsuario().getEmail(), "santiacquarone2@gmail.com");
		assertEquals(icontroller.getUsuario().getFechaNacimiento(), fechanac);
	}

	@Test
	void testAltaArtista() {
		LocalDate fechanac = LocalDate.of(2000, 03, 29);
		try {
			icontroller.altaUsuario("santiacq7", "santiago", "acquarone", "santiacquarone7@gmail.com", fechanac);
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
	void testAltaArtistaWeb() {
		LocalDate fechanac = LocalDate.of(2000, 03, 29);
		try {
			icontroller.altaArtistaWeb("santiacq9", "santiago", "acquarone", "santiacquarone9@gmail.com", fechanac,"el number 1", "...", "acqua.com", "passw0rd", "4.jpeg");
		} catch (UsuarioConMismoNickException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UsuarioConMismoMailException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		assertEquals(icontroller.getArtista().getDescripcion(), "el number 1");
		assertEquals(icontroller.getArtista().getBiografia(), "...");
		assertEquals(icontroller.getArtista().getWebsite(), "acqua.com");
	}
	
	@Test
	void testAltaArtistaWebMismoNick() {
		LocalDate fechanac = LocalDate.of(2000, 03, 29);
		try {
			icontroller.altaArtistaWeb("santiacq", "santiago", "acquarone", "santiacquarone356@gmail.com", fechanac,"el number 1", "...", "acqua.com", "passw0rd", "4.jpeg");
		} catch (UsuarioConMismoNickException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UsuarioConMismoMailException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		assertThrows(UsuarioConMismoNickException.class, () -> icontroller.altaArtistaWeb("santiacq", "santiago", "acquarone", "santiacquarone356@gmail.com", fechanac,"el number 1", "...", "acqua.com", "passw0rd", "4.jpeg"));
	}
	
	@Test
	void testAltaArtistaWebMismoMail() {
		LocalDate fechanac = LocalDate.of(2000, 03, 29);
		try {
			icontroller.altaArtistaWeb("santiacq9", "santiago", "acquarone", "santiacquarone@gmail.com", fechanac,"el number 1", "...", "acqua.com", "passw0rd", "4.jpeg");
		} catch (UsuarioConMismoNickException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UsuarioConMismoMailException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		assertThrows(UsuarioConMismoMailException.class, () -> icontroller.altaUsuario("santiacquito", "santiago", "acquarone", "santiacquarone@gmail.com", fechanac));
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
			icontroller.altaUsuario("santiacq3", "santiago", "acquarone", "santiacquarone3@gmail.com", fechanac);
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
		assertTrue(hu.getUsuarios().containsKey("santiacq3"));
		assertTrue(hu.getUsuario("santiacq3").esArtista() == true);
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

	@Test
	void testUpdateUsuario() {
		LocalDate fechanac = LocalDate.of(2000, 03, 29);
		icontroller.updateUsuario("santiacq","Santiaguito", "Acquarone", "santiacquarone@gmail.com", fechanac);
	
		assertEquals(icontroller.getNickname(), "santiacq");
		assertEquals(icontroller.getNombre(), "Santiaguito");
		assertEquals(icontroller.getApellido(), "Acquarone");
		assertEquals(icontroller.getEmail(), "santiacquarone@gmail.com");
		assertEquals(icontroller.getFechaNacimiento(), fechanac);
		
	}
	
	
	@Test
	void testConfirmarUpdateUsuario() {
		hu = HandlerUsuarios.getInstancia();
		LocalDate fechanac = LocalDate.of(2000, 03, 29);
		icontroller.updateUsuario("santiacq", "santiago", "acquarone", "santiacquarone@gmail.com", fechanac);
		icontroller.confirmarUpdateUsuario();
		
		assertTrue(hu.getUsuarios().containsKey("santiacq"));
		assertTrue(hu.getUsuario("santiacq").esArtista() == false);
	}
	
	@Test
	void testAltaUsuarioWebMismoNick() {
		LocalDate fechanac = LocalDate.of(2000, 03, 29);
		try {
			icontroller.altaUsuarioWeb("santiacq2", "santiago", "acquarone", "santiacquarone2@gmail.com", fechanac, "passw0rd", "1.jpeg");
		} catch (UsuarioConMismoNickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UsuarioConMismoMailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertThrows(UsuarioConMismoNickException.class, () -> 	icontroller.altaUsuarioWeb("santiacq", "santiago", "acquarone", "santiacquarone2@gmail.com", fechanac, "passw0rd", "1.jpeg"));

	}
	
	@Test
	void testAltaUsuarioWebMismoMail() {
		LocalDate fechanac = LocalDate.of(2000, 03, 29);
		try {
			icontroller.altaUsuarioWeb("santiacq", "santiago", "acquarone", "santiacquarone@gmail.com", fechanac, "passw0rd", "1.jpeg");
		} catch (UsuarioConMismoNickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UsuarioConMismoMailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertThrows(UsuarioConMismoMailException.class, () -> 	icontroller.altaUsuarioWeb("santiacq2", "santiago", "acquarone", "santiacquarone@gmail.com", fechanac, "passw0rd", "1.jpeg"));

	}
	
	@Test
	void testConfirmarUpdateArtista() {
		hu = HandlerUsuarios.getInstancia();
		LocalDate fechanac = LocalDate.of(2000, 03, 29);
		icontroller.updateUsuario("santiacq", "santiago", "acquarone", "santiacquarone@gmail.com", fechanac);
		icontroller.updateArtista("desc nueva", "bio nueva", "acqua.com");
		icontroller.confirmarUpdateUsuario();
		
		assertTrue(hu.getUsuarios().containsKey("santiacq"));
		assertTrue(hu.getUsuario("santiacq").esArtista() == true);
		assertEquals(icontroller.getArtista().getDescripcion(), "desc nueva");
		assertEquals(icontroller.getArtista().getWebsite(), "acqua.com");
	}
	

	
	/*

	@Test
	void testMostrarDatos() {
		fail("Not yet implemented");
	}


	


	*/
	
}
