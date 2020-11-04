package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;



import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import logica.Espectaculo;
import logica.HandlerPlataforma;
import logica.Plataforma;
import logica.PlataformaController;

class PlataformaControllerTest {
	
	private static PlataformaController icontroller;
	private static HandlerPlataforma ha;
	
	@BeforeAll
	static void iniciar() {
		// aca no use la fabrica porque sino no tenemos getters y setters para testear
		icontroller = new PlataformaController();
		ha = HandlerPlataforma.getInstance();
	}


	@Test
	void testAltaPlataforma() {
		icontroller.altaPlataforma("Instagram", "red social", "instagram.com");
		assertEquals(icontroller.getDescrip(), "red social");
		assertEquals(icontroller.getUrl(), "instagram.com");
	}

	@Test
	void testConfirmarAltaPlataforma() {
		icontroller.altaPlataforma("Instagram", "red social", "instagram.com");
		icontroller.confirmarAltaPlataforma();
		assertEquals(ha.getPlataforma("Instagram").getDescrip(), "red social");
		assertEquals(ha.getPlataforma("Instagram").getUrl(), "instagram.com");
	}

	@Test
	void testAgregarEspectaculoPlataforma() {
		Espectaculo e = new Espectaculo("fiesta pop", LocalTime.now(), "fiesta estilo pop", 20, 200, "fpop", LocalDate.now(), 200);
		Plataforma p = new Plataforma("yt", "sitio de videos", "yt.com");
		icontroller.agregarEspectaculoPlataforma(p, e);
	}

}
