package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import datatypes.DtEspectaculo;
import logica.Espectaculo;
import logica.EspectaculoController;
import logica.HandlerEspectaculos;
import logica.IEspectaculo;

class EspectaculoControllerTest {
	
	IEspectaculo ie = new EspectaculoController();
	HandlerEspectaculos he = HandlerEspectaculos.getInstance();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		presentacion.Principal.cargarDatos();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testElegirEspectaculo() {
		ie.elegirEspectaculo("Los Village Volvieron");
	}

	@Test
	void testConfirmarAltaFuncion() {
		ie.elegirEspectaculo("Los Village Volvieron");
		ArrayList<String> artistas = new ArrayList<String>();
		artistas.add("vpeople");
		artistas.add("lospimpi");
		try {
		ie.altaFuncion("myfuncion", LocalDate.of(2020, 10, 10), LocalTime.now(),artistas, LocalDate.now());
		ie.ConfirmarAltaFuncion();
		} catch(Exception e) {
			fail(e.getMessage());
		}
		assertTrue(ie.listarFuncionesEspectaculo("Los Village Volvieron").contains("myfuncion"));
		
	};
	
	@Test
	void testListarPlataformas() {
		assertTrue(ie.listarPlataformas().contains("Facebook Watch"));
		
	}

	
	@Test
	void testListarEspectaculosPlataforma() {
		assertTrue(ie.listarEspectaculosPlataforma("Instagram Live").contains("Los Village Volvieron"));
	}

	
	@Test
	void testMostrarEspectaculosPlataforma() {
		Espectaculo e = he.getEspectaculo("Los Village Volvieron");
		DtEspectaculo dte = new DtEspectaculo(e);
		ie.mostrarEspectaculosPlataforma("Instagram Live").contains(dte);
	}

	/*
	@Test
	void testMostrarFuncionesEspectaculo() {
		fail("Not yet implemented");
	}

	@Test
	void testListarFuncionesEspectaculo() {
		fail("Not yet implemented");
	}

	@Test
	void testMostarFuncion() {
		fail("Not yet implemented");
	}

	@Test
	void testMostrarEspectadores() {
		fail("Not yet implemented");
	}

	@Test
	void testIngresarDatosRegistro() {
		fail("Not yet implemented");
	}

	@Test
	void testObtenerRegistrosPrevios() {
		fail("Not yet implemented");
	}

	@Test
	void testCanjearRegistros() {
		fail("Not yet implemented");
	}

	@Test
	void testExisteRegistroEspecAFun() {
		fail("Not yet implemented");
	}

	@Test
	void testFuncionAlcanzoLimiteReg() {
		fail("Not yet implemented");
	}

	@Test
	void testElegirNuevaFuncion() {
		fail("Not yet implemented");
	}

	@Test
	void testElegirNuevoEspectador() {
		fail("Not yet implemented");
	}

	@Test
	void testConfirmarRegistro() {
		fail("Not yet implemented");
	}

	@Test
	void testListarArtistas() {
		fail("Not yet implemented");
	}

	@Test
	void testListarUsuarios() {
		fail("Not yet implemented");
	}

	@Test
	void testAltaEspectaculo() {
		fail("Not yet implemented");
	}

	@Test
	void testConfirmarAltaEspectaculo() {
		fail("Not yet implemented");
	}

	@Test
	void testElegirFuncion() {
		fail("Not yet implemented");
	}
	
	*/
}
