package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import datatypes.DtEspectaculo;
import datatypes.DtFuncion;
import datatypes.DtRegistro;
import datatypes.DtUsuario;
import logica.Espectaculo;
import logica.EspectaculoController;
import logica.Funcion;
import logica.HandlerEspectaculos;
import logica.IEspectaculo;
import excepciones.*;

class EspectaculoControllerTest {
	
	EspectaculoController ie = new EspectaculoController();
	HandlerEspectaculos he = HandlerEspectaculos.getInstance();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//presentacion.Principal.cargarDatos();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testElegirEspectaculo() {
		ie.elegirEspectaculo("Los Village Volvieron");
		assertTrue(ie.getEspectaculo().getNombre().equals("Los Village Volvieron"));
	}
	@Test
	void testElegirEspectaculoNoExiste() {
		ie.elegirEspectaculo("fake");
		assertTrue(ie.getEspectaculo() == null);
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
			e.printStackTrace();
		}
		assertTrue(ie.listarFuncionesEspectaculo("Los Village Volvieron").contains("myfuncion"));
		
	};
	
	@Test
	void testConfirmarAltaFuncionRepetido() {
		ie.elegirEspectaculo("Los Village Volvieron");
		ArrayList<String> artistas = new ArrayList<String>();
		artistas.add("vpeople");
		artistas.add("lospimpi");
		try {
		ie.altaFuncion("myfuncion", LocalDate.of(2020, 10, 10), LocalTime.now(),artistas, LocalDate.now());
		ie.ConfirmarAltaFuncion();
		} catch(Exception e) {
			e.printStackTrace();
		}
		assertThrows(NombreFuncionexisteException.class, () -> {ie.altaFuncion("myfuncion", LocalDate.of(2020, 10, 10), LocalTime.now(),artistas, LocalDate.now());});

	}
	
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
		ArrayList<DtEspectaculo> dtes = ie.mostrarEspectaculosPlataforma("Instagram Live");
		boolean exito = false;
		for (DtEspectaculo dt : dtes) {
			if (dt.getNombre().equals(dte.getNombre())) {
				exito = true;
			}
		}
		assertTrue(exito);
	}

	@Test
	void testMostrarFuncionesEspectaculo() {
		Espectaculo e = he.getEspectaculo("Los Village Volvieron");
		Funcion f = e.getFuncion("Los Village Volvieron - 1");
		DtFuncion dtf = new DtFuncion(f);
		ArrayList<DtFuncion> dtfs = ie.mostrarFuncionesEspectaculo("Los Village Volvieron");
		boolean succ = false;
		for (DtFuncion dt : dtfs) {
			if (dt.getNombre().equals(dtf.getNombre())) {
				succ = true;
			}
		}
		assertTrue(succ);
	}

	@Test
	void testListarFuncionesEspectaculo() {
		assertTrue(ie.listarFuncionesEspectaculo("Los Village Volvieron").contains("Los Village Volvieron - 1"));
	}
	

	@Test
	void testMostarFuncion() {
		ie.elegirEspectaculo("Los Village Volvieron");
		DtFuncion dtf = ie.mostarFuncion("Los Village Volvieron - 1");
		System.out.print(dtf.getNombre());
		assertTrue(dtf.getNombre().equals("Los Village Volvieron - 1"));
	}
	

	@Test
	void testMostrarEspectadores() {
		ArrayList<String> espec = ie.mostrarEspectadores();
		assertTrue(espec.contains("vpeople"));
	}
	
	@Test
	void testListarArtistas() {
		ArrayList<String> megustaelarte = ie.listarArtistas();
		assertTrue(megustaelarte.contains("vpeople"));
		assertFalse(megustaelarte.contains("waston"));
	}
	
	@Test
	void testListarUsuarios() {
		boolean succ = false;
		try {
		DtUsuario[] dtus = ie.listarUsuarios();
		for (DtUsuario dt : dtus) {
			if (dt.getNickname().equals("waston")) succ = true;
		}
		} catch(Exception e) {
			e.printStackTrace();
		}
		assertTrue(succ);
	}
	
	@Test
	void testAltaEspectaculo() {
		try {
			ie.altaEspectaculo("Facebook Watch", "vpeople", "Los Village Volvieron", "Test", LocalTime.of(1, 30), 5, 10, "url", 500, LocalDate.of(2020, 10, 10));
		} catch (NombreEspectaculoExisteException e) {
			e.printStackTrace();
		}
		assertThrows(NombreEspectaculoExisteException.class, () -> ie.altaEspectaculo("Instagram Live", "vpeople", "Los Village Volvieron", "Test", LocalTime.of(1, 30), 5, 10, "url", 500, LocalDate.of(2020, 10, 10)));
	}

	@Test
	void testIngresarNombreFuncion() {
		ie.ingresarNombreFuncion("Los Village Volvieron");
	}
		
	@Test
	void testIngresarNombreEspectador() {
		ie.ingresarNombreEspectador("waston");
	}
	
	@Test
	void testObtenerRegistrosPrevios() {
		ie.ingresarNombreFuncion("Los Village Volvieron - 1");
		ie.ingresarNombreEspectador("waston");
		ArrayList<DtRegistro> dtrs = ie.obtenerRegistrosPrevios();
	}
	
	
	@Test
	void testConfirmarRegistro() {
		ie.ingresarNombreFuncion("Los Village Volvieron - 1");
		ie.ingresarNombreEspectador("waston");
		ie.confirmarRegistro("Los Village Volvieron");
	};
	
	@Test
	void testFuncionAlcanzoLimiteReg() {
		Funcion f = he.getEspectaculo("Los Village Volvieron").getFuncion("los Village Volvieron - 1");
		ie.ingresarNombreFuncion("Los Village Volvieron - 1");
		assertFalse(ie.funcionAlcanzoLimiteReg("Los Village Volvieron"));	
	}
	
	@Test
	void testExisteRegistroEspecAFun() {
		ie.ingresarNombreFuncion("Los Village Volvieron - 1");
		ie.ingresarNombreEspectador("waston");
		assertTrue(ie.existeRegistroEspecAFun());
		ie.ingresarNombreFuncion("Los Village Volvieron - 1");
		ie.ingresarNombreEspectador("costas");
		assertFalse(ie.existeRegistroEspecAFun());
	}
	
	@Test
	void testElegirFuncion() {
		ie.elegirFuncion("Los Village Volvieron - 1");
		assertTrue(ie.getNomfuncion().equals("Los Village Volvieron - 1"));
	}
	
	@Test
	void testCanjearRegistrosNoSonTres() {
		ie.ingresarNombreEspectador("waston");
		ie.ingresarNombreFuncion("Los Village Volvieron - 1");
		ie.confirmarRegistro("Los Village Volvieron");
		ie.ingresarNombreEspectador("waston");
		ie.ingresarNombreFuncion("Los Village Volvieron - 2");
		ie.confirmarRegistro("Los Village Volvieron");
		ie.ingresarNombreEspectador("waston");
		DtRegistro[] dtr = new DtRegistro[2];
		ArrayList<DtRegistro> dtre = ie.obtenerRegistrosPrevios();
		for (int i = 0; i<2; i++) {
			dtr[i] = dtre.get(i);
		}
		try {
		ie.canjearRegistros(dtr);
		} catch (noSeleccionoTres e) {
			e.printStackTrace();
		}
		
		assertThrows(noSeleccionoTres.class , () -> ie.canjearRegistros(dtr));
		
	}
	


	
	@Test
	void testConfirmarCanje() {
		ie.ingresarNombreEspectador("waston");
		ie.ingresarNombreFuncion("Los Village Volvieron - 1");
		ie.confirmarRegistro("Los Village Volvieron");
		ie.ingresarNombreEspectador("waston");
		ie.ingresarNombreFuncion("Los Village Volvieron - 2");
		ie.confirmarRegistro("Los Village Volvieron");
		ie.ingresarNombreEspectador("waston");
		ie.ingresarNombreFuncion("Los Village Volvieron - 3");
		ie.confirmarRegistro("Los Village Volvieron");
		DtRegistro[] dtr = new DtRegistro[3];
		ArrayList<DtRegistro> dtre = ie.obtenerRegistrosPrevios();
		for (int i = 0; i<3; i++) {
			dtr[i] = dtre.get(i);
		}
		try {
		ie.canjearRegistros(dtr);
		} catch (noSeleccionoTres e) {
			e.printStackTrace();
		}
		ie.ingresarNombreFuncion("Memphis Blues World - A");
		ie.ingresarNombreEspectador("waston");
		ie.confirmarRegistro("Memphis Blues World");
	}
	
	@Test
	void testGetSetEspectaculo() {
		ie.setNomPlataforma("Facebook Watch");
		assertTrue(ie.getNomPlataforma().equals("Facebook Watch"));
		
		ie.setNickArtista("vpeople");
		assertTrue(ie.getNickArtista().equals("vpeople"));
		
		ie.setNomespec("Memphis Blues World");
		assertTrue(ie.getNomespec().equals("Memphis Blues World"));
		
		ie.setDescripcion("desc");
		assertTrue(ie.getDescripcion().equals("desc"));
		
		ie.setNomfuncion("Memphis Blues World - A");
		assertTrue(ie.getNomfuncion().equals("Memphis Blues World - A"));
		
		ie.setUrl("url");
		assertTrue(ie.getUrl().equals("url"));
		
		ie.setMinEspect(50);
		assertTrue(ie.getMinEspect() == 50);
		
		ie.setMaxEspect(500);
		assertTrue(ie.getMaxEspect()== 500);
		
		ie.setCosto(Float.valueOf("100"));
		assertTrue(ie.getCosto() == 100);
		
		ie.setHorainicio(LocalTime.MIDNIGHT);
		assertTrue(ie.getHorainicio().equals(LocalTime.MIDNIGHT));
		
		ie.setFechaAlta(LocalDate.of(2020, 10, 10));
		assertTrue(ie.getFechaAlta().equals(LocalDate.of(2020, 10, 10)));
		
	}
	

	/*
	

	

	@Test
	void testElegirNuevaFuncion() {
		fail("Not yet implemented");
	}

	@Test
	void testElegirNuevoEspectador() {
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
