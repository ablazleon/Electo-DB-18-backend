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
	void testCreatePartido2016CreatedMatchsPartido2016Read() {
		
		Circunscripcion2016 p1 = new Circunscripcion2016();
		p1.setIdCirc(1);
		Circunscripcion2016DAO pdao = Circunscripcion2016DAOImplementation.getInstance();
		pdao.create(p1);
		
		Circunscripcion2016 pread = pdao.read(p1.getIdCirc());
		
		assertEquals(pread.getIdCirc(), p1.getIdCirc());
		assertEquals(pread.getIdPartidoMasVotado(), p1.getIdPartidoMasVotado());
	
		pdao.delete(p1);
	}

	/**
	 * Comprueba que al crearse varios Ps, si se accede con readAll() estos Ps son los mismo que 
	 * los objeto P iniciales.
	 * 
	 */
	@Test
	void testReadAll() {	
		
		Circunscripcion2016 p1 = new Circunscripcion2016();
		p1.setIdCirc(1);
		Circunscripcion2016 p2 = new Circunscripcion2016();
		p2.setIdCirc(2);
		
		Circunscripcion2016DAO tdao = Circunscripcion2016DAOImplementation.getInstance();
		
		assertFalse(tdao.readAll().contains(p1), "There is no initial p1");
		assertFalse(tdao.readAll().contains(p2), "There is no initial p2");
		
		tdao.create(p1);
		tdao.create(p2);
		
		for(Circunscripcion2016 p : tdao.readAll()) {
			System.out.println(p.getIdCirc());
			if(p.getIdCirc() == p1.getIdCirc()) {
				assertTrue(p.getIdCirc() == p1.getIdCirc(), "There is tfg1");
			}
			if(p.getIdCirc() == p2.getIdCirc()) {
				assertTrue(p.getIdCirc() == p2.getIdCirc(), "There is tfg1");
			}
		}
		
//			assertTrue(tdao.readAll().contains(tfg1), "There is an initial tfg1");
//			assertTrue(tdao.readAll().contains(tfg2), "There is an initial tfg2");
		
		tdao.delete(p1);
		tdao.delete(p2);
	}

}
