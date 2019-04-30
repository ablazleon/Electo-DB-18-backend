package es.upm.dit.isst.persistence.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.dit.isst.persistence.model.Circunscripcion2016;

class Circunscripcion2016DAOImplementationTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Comprueba que al crearse varios Ps, si se accede con readAll() estos Ps son los mismo que 
	 * los objeto P iniciales.
	 * 
	 */
	@Test
	void testCreateCirc2016CreatedMatchsCirc2016Read() {
		
		Circunscripcion2016 c1 = new Circunscripcion2016();
		c1.setIdCirc(1);
		Circunscripcion2016DAO pdao = Circunscripcion2016DAOImplementation.getInstance();
		pdao.create(c1);
		
		Circunscripcion2016 pread = pdao.read(c1.getIdCirc());
		
		assertEquals(pread.getIdCirc(), c1.getIdCirc());
		assertEquals(pread.getIdPartidoMasVotado(), c1.getIdPartidoMasVotado());
	
		pdao.delete(c1);
	}

	/**
	 * Comprueba que al crearse varios Ps, si se accede con readAll() estos Ps son los mismo que 
	 * los objeto P iniciales.
	 * 
	 */
	@Test
	void testReadAll() {	
		
		Circunscripcion2016 c1 = new Circunscripcion2016();
		c1.setIdCirc(1);
		Circunscripcion2016 c2 = new Circunscripcion2016();
		c2.setIdCirc(2);
		
		Circunscripcion2016DAO tdao = Circunscripcion2016DAOImplementation.getInstance();
		
		assertFalse(tdao.readAll().contains(c1), "There is no initial c1");
		assertFalse(tdao.readAll().contains(c2), "There is no initial c2");
		
		tdao.create(c1);
		tdao.create(c2);
		
		for(Circunscripcion2016 p : tdao.readAll()) {
			System.out.println(p.getIdCirc());
			if(p.getIdCirc() == c1.getIdCirc()) {
				assertTrue(p.getIdCirc() == c1.getIdCirc(), "There is tfg1");
			}
			if(p.getIdCirc() == c2.getIdCirc()) {
				assertTrue(p.getIdCirc() == c2.getIdCirc(), "There is tfg1");
			}
		}	
		tdao.delete(c1);
		tdao.delete(c2);
	}

}
