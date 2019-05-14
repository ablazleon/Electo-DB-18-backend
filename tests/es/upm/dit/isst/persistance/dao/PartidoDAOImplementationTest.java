package es.upm.dit.isst.persistance.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.dit.isst.persistence.dao.PartidoDAO;
import es.upm.dit.isst.persistence.dao.PartidoDAOImplementation;
import es.upm.dit.isst.persistence.model.Partido;


class PartidoDAOImplementationTest {


	/**
	 * Comprueba que al crearse varios Ps, si se accede con readAll() estos Ps son los mismo que 
	 * los objeto P iniciales.
	 * 
	 */
	@Test
	void testCreatePartidoCreatedMatchsPartidoRead() {
		
		Partido c1 = new Partido();
		c1.setIdNombre("Tabarnia");
		PartidoDAO pdao = PartidoDAOImplementation.getInstance();
		pdao.create(c1);
		
		Partido pread = pdao.read(c1.getIdNombre());
		
		assertEquals(pread.getIdNombre(), c1.getIdNombre());
	
		pdao.delete(c1);
	}
	
	/**
	 * Comprueba que al crearse varios Ps, si se accede con readAll() estos Ps son los mismo que 
	 * los objeto P iniciales.
	 * 
	 */
	@Test
	void testReadAll() {	
		
		Partido c1 = new Partido();
		c1.setIdNombre("VOX");
		Partido c2 = new Partido();
		c2.setIdNombre("FE");
		
		PartidoDAO tdao = PartidoDAOImplementation.getInstance();
		
		assertFalse(tdao.readAll().contains(c1), "There is no initial c1");
		assertFalse(tdao.readAll().contains(c2), "There is no initial c2");
		
		tdao.create(c1);
		tdao.create(c2);
		
		for(Partido p : tdao.readAll()) {
			System.out.println(p.getIdNombre());
			if(p.getIdNombre() == c1.getIdNombre()) {
				assertTrue(p.getIdNombre() == c1.getIdNombre(), "There is tfg1");
			}
			if(p.getIdNombre() == c2.getIdNombre()) {
				assertTrue(p.getIdNombre() == c2.getIdNombre(), "There is tfg1");
				}
			}	
			tdao.delete(c1);
			tdao.delete(c2);
		}

}
