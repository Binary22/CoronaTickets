package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import logica.Fabrica;
import logica.IConsulta;

class ConsultaControllerTest {
	
	private static IConsulta icontroller;
	
	@BeforeAll
	static void iniciar() {
		Fabrica f = Fabrica.getInstance();
		IConsulta icontroller = f.getIConsulta();
	}

	@Test
	void testConsultaControllerFuncionEspectaculoPaqueteUsuario() {
		fail("Not yet implemented");
	}

	@Test
	void testConsultaController() {
		fail("Not yet implemented");
	}

	@Test
	void testListarUsuarios() {
		fail("Not yet implemented");
	}

	@Test
	void testElegirEspectaculo() {
		fail("Not yet implemented");
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
