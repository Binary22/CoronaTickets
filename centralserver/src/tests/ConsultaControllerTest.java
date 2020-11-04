package tests;



import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;




import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import logica.Artista;
import logica.ConsultaController;
import logica.Espectaculo;
import logica.Funcion;
import logica.HandlerEspectaculos;
import logica.HandlerPlataforma;
import logica.HandlerUsuarios;
import logica.Plataforma;
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
		Usuario u1 = new Usuario("ax", "b", "c", "d", LocalDate.now());
		Usuario u2 = new Usuario("ex", "f", "g", "h", LocalDate.now());
		hu.agregarUsuario(u1);
		hu.agregarUsuario(u2);
		//assertEquals(icontroller.listarUsuarios().size(), 2);
		assertTrue(icontroller.listarUsuarios().contains("ax"));
		assertTrue(icontroller.listarUsuarios().contains("ex"));
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
		Espectaculo e = new Espectaculo("b", LocalTime.now(), "b", 10, 200, "c", LocalDate.now(), 5);
		he.addEspectaculo(e);
		//ArrayList<String> a = new ArrayList<String>
		Funcion f = new Funcion("f", LocalDate.now(), LocalTime.now(), LocalDate.now(), null, e);
		icontroller.elegirFuncion("b", "f");
	}

/*	@Test
	void testListarPaquetes() {
		fail("Not yet implemented");
	}

	@Test
	void testSeleccionarPaquete() {
		fail("Not yet implemented");
	} */

	@Test
	void testListarPlataformas() {
		Plataforma p1 = new Plataforma("a", "b", "c");
		Plataforma p2 = new Plataforma("d", "e", "f");
		hp.agregarPlataforma(p1);
		hp.agregarPlataforma(p2);
		assertTrue(icontroller.listarPlataformas().contains("a"));
		assertTrue(icontroller.listarPlataformas().contains("d"));
	}

	@Test
	void testListarEspectaculosPlataforma() {
		Plataforma p3 = new Plataforma("r", "b", "c");
		hp.agregarPlataforma(p3);
		Espectaculo e = new Espectaculo("f", LocalTime.now(), "b", 10, 200, "c", LocalDate.now(), 5);
		p3.addEspectaculo(e);
		assertTrue(icontroller.listarEspectaculosPlataforma("r").contains("f"));
	}

	@Test
	void testListarFuncionesEspect() {
		Espectaculo e = new Espectaculo("f", LocalTime.now(), "b", 10, 200, "c", LocalDate.now(), 5);
		he.addEspectaculo(e);
		Funcion f = new Funcion("x", LocalDate.now(), LocalTime.now(), LocalDate.now(), null, e);
		e.agregarFuncion(f);
		assertTrue(icontroller.listarFuncionesEspect("f").contains("x"));
	}

	@Test
	void testMostrarDatos() {
		
		Usuario u1 = new Usuario("aa", "b", "c", "d", LocalDate.now());
		hu.agregarUsuario(u1);
		assertEquals(icontroller.mostrarDatos("aa").getApellido(), "c");
		assertEquals(icontroller.mostrarDatos("aa").getNombre(), "b");
	}

	/*@Test
	void testListarEspectaculosQueOrganiza() {
		fail("Not yet implemented");
	} */
/* TODAVIA NO HAGO ESTOS TESTS PORQUE NO ESTA HECHO
	@Test
	void testListarFuncionesQueSeRegistro() {
		fail("Not yet implemented");
	}

	@Test
	void testListarFuncionesDtQueSeRegistro() {
		fail("Not yet implemented");
	}

/*	@Test
	void testMostrarPaquete() {
		fail("Not yet implemented");
	} */

	@Test
	void testMostrarEspectaculo() {
		Espectaculo e = new Espectaculo("fff", LocalTime.now(), "b", 10, 200, "c", LocalDate.now(), 5);
		he.addEspectaculo(e);
		icontroller.elegirEspectaculo("fff");
		assertEquals(icontroller.mostrarEspectaculo().getNombre(),  "fff");
		
	}

	@Test
	void testMostrarFuncion() {
		Espectaculo e = new Espectaculo("q", LocalTime.now(), "b", 10, 200, "c", LocalDate.now(), 5);
		he.addEspectaculo(e);
		Funcion f = new Funcion("z", LocalDate.now(), LocalTime.now(), LocalDate.now(), null, e);
		e.agregarFuncion(f);
		icontroller.elegirFuncion("q", "z");
		assertEquals(icontroller.mostrarFuncion().getNombre(), "z");
	}

	@Test
	void testEsArtista() {
		Usuario u1 = new Usuario("aa", "b", "c", "d", LocalDate.now());
		hu.agregarUsuario(u1);
		Usuario u2 = new Artista("aaaaa", "b", "c", "d", LocalDate.now(), "a", "a", "a");
		hu.agregarUsuario(u2);
		assertTrue(!icontroller.esArtista("aa"));
		assertTrue(icontroller.esArtista("aaaaa"));
	}

	@Test
	void testMostrarDatosArtista() {
		Usuario u2 = new Artista("w", "b", "c", "d", LocalDate.now(), "a", "a", "a");
		hu.agregarUsuario(u2);
		assertEquals(icontroller.mostrarDatosArtista("w").getDescripcion(), "a");
	}

	@Test
	void testGetFuncion() {
		Espectaculo e = new Espectaculo("q", LocalTime.now(), "b", 10, 200, "c", LocalDate.now(), 5);
		he.addEspectaculo(e);
		Funcion f = new Funcion("z", LocalDate.now(), LocalTime.now(), LocalDate.now(), null, e);
		e.agregarFuncion(f);
		icontroller.elegirFuncion("q", "z");
		assertEquals(icontroller.getFuncion().getNombre(), "z");
	}

}
