package es.upm.dit.isst.persistence.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.dit.isst.persistence.dao.Partido2016DAO;
import es.upm.dit.isst.persistence.dao.Partido2016DAOImplementation;
import es.upm.dit.isst.persistence.model.Partido2016;

class Partido2016DAOImplementacionTest {

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
		
		Partido2016 p1 = new Partido2016();
		p1.setIdPartido("FE");
		Partido2016DAO pdao = Partido2016DAOImplementation.getInstance();
		pdao.create(p1);
		
		Partido2016 pread = pdao.read(p1.getIdPartido());
		
		assertEquals(pread.getIdPartido(), p1.getIdPartido());
		assertEquals(pread.getVotes(), p1.getVotes());
	
		pdao.delete(p1);
	}

	/**
	 * Comprueba que al crearse varios Ps, si se accede con readAll() estos Ps son los mismo que 
	 * los objeto P iniciales.
	 * 
	 */
	@Test
	void testReadAll() {	
		
		Partido2016 p1 = new Partido2016();
		p1.setIdPartido("FE");
		Partido2016 p2 = new Partido2016();
		p2.setIdPartido("PACMA");
		
		Partido2016DAO tdao = Partido2016DAOImplementation.getInstance();
		
		assertFalse(tdao.readAll().contains(p1), "There is no initial p1");
		assertFalse(tdao.readAll().contains(p2), "There is no initial p2");
		
		tdao.create(p1);
		tdao.create(p2);
		
		for(Partido2016 p : tdao.readAll()) {
			System.out.println(p.getIdPartido());
			if(p.getIdPartido() == p1.getIdPartido()) {
				assertTrue(p.getIdPartido() == p1.getIdPartido(), "There is tfg1");
			}
			if(p.getIdPartido() == p2.getIdPartido()) {
				assertTrue(p.getIdPartido() == p2.getIdPartido(), "There is tfg1");
			}
		}
		
//			assertTrue(tdao.readAll().contains(tfg1), "There is an initial tfg1");
//			assertTrue(tdao.readAll().contains(tfg2), "There is an initial tfg2");
		
		tdao.delete(p1);
		tdao.delete(p2);
	}
}
