package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import logica.HandlerPaquetes;

class HandlerPaquetesTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void getPaquetesDeEspectaculosTest() {
		HandlerPaquetes handlerP = HandlerPaquetes.getInstance();
		assertFalse(handlerP.getPaquetesDeEspectaculo("Bien de Familia").isEmpty());
		assertFalse(handlerP.getPaquetesDeEspectaculoWeb("Bien de Familia").isEmpty());
		
	}
	
	@Test
	void buscarPaquetesTest() {
		HandlerPaquetes handlerP = HandlerPaquetes.getInstance();
		assertFalse(handlerP.buscarPaquetes("latino").isEmpty());
	}

}
