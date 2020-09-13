package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import logica.ConsultaController;
import logica.Espectaculo;
import logica.HandlerEspectaculos;
import logica.HandlerPlataforma;
import logica.HandlerUsuarios;
import logica.PlataformaController;
import logica.Usuario;

class ConsultaControllerTest {
	
	private static ConsultaController icontroller;
	private static HandlerUsuarios hu;
	private static HandlerEspectaculos he;
	private static HandlerPlataforma hp;
	
	@BeforeAll
	static void iniciar() {
		// aca no use la fabrica porque sino no tenemos getters y setters para testear
		icontroller = new ConsultaController();
		hu = HandlerUsuarios.getInstancia();
		he = HandlerEspectaculos.getInstance();
		hp = HandlerPlataforma.getInstance();
	}


	@Test
	void testListarUsuarios() {
		Usuario u1 = new Usuario("a", "b", "c", "d", LocalDate.now());
		Usuario u2 = new Usuario("e", "f", "g", "h", LocalDate.now());
		hu.agregarUsuario(u1);
		hu.agregarUsuario(u2);
		assertEquals(icontroller.listarUsuarios().size(), 2);
		assertTrue(icontroller.listarUsuarios().contains("a"));
		assertTrue(icontroller.listarUsuarios().contains("e"));
	}

	@Test
	void testElegirEspectaculo() {
		Espectaculo e = new Espectaculo("a", LocalTime.now(), "b", 10, 200, "c", LocalDate.now(), 5);
		he.addEspectaculo(e);
		icontroller.elegirEspectaculo("a");
		assertEquals(icontroller.getEspectaculo(), e);
		
	}

	@Test
	void testElegirFuncion() {
		fail("Not yet implemented");
	}

	@Test
	void testListarPaquetes() {
		fail("Not yet implemented");
	}

	@Test
	void testSeleccionarPaquete() {
		fail("Not yet implemented");
	}

	@Test
	void testListarPlataformas() {
		fail("Not yet implemented");
	}

	@Test
	void testListarEspectaculosPlataforma() {
		fail("Not yet implemented");
	}

	@Test
	void testListarFuncionesEspect() {
		fail("Not yet implemented");
	}

	@Test
	void testMostrarDatos() {
		fail("Not yet implemented");
	}

	@Test
	void testListarEspectaculosQueOrganiza() {
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
	void testMostrarPaquete() {
		fail("Not yet implemented");
	}

	@Test
	void testMostrarEspectaculo() {
		fail("Not yet implemented");
	}

	@Test
	void testMostrarFuncion() {
		fail("Not yet implemented");
	}

	@Test
	void testEsArtista() {
		fail("Not yet implemented");
	}

	@Test
	void testMostrarDatosArtista() {
		fail("Not yet implemented");
	}

	@Test
	void testGetFuncion() {
		fail("Not yet implemented");
	}

}
