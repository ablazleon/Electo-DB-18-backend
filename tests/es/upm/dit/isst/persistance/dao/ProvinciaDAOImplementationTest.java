package es.upm.dit.isst.persistance.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.dit.isst.persistence.dao.ProvinciaDAO;
import es.upm.dit.isst.persistence.dao.ProvinciaDAOImplementation;
import es.upm.dit.isst.persistence.model.Provincia;


class ProvinciaDAOImplementationTest {


	/**
	 * Comprueba que al crearse varios Ps, si se accede con readAll() estos Ps son los mismo que 
	 * los objeto P iniciales.
	 * 
	 */
	@Test
	void testCreateProvinciaCreatedMatchsProvinciaRead() {
		
		Provincia c1 = new Provincia();
		c1.setIdNombre("Tabarnia");
		ProvinciaDAO pdao = ProvinciaDAOImplementation.getInstance();
		pdao.create(c1);
		
		Provincia pread = pdao.read(c1.getIdNombre());
		
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
		
		Provincia c1 = new Provincia();
		c1.setIdNombre("Tabarnia");
		Provincia c2 = new Provincia();
		c2.setIdNombre("Madrid");
		
		ProvinciaDAO tdao = ProvinciaDAOImplementation.getInstance();
		
		assertFalse(tdao.readAll().contains(c1), "There is no initial c1");
		assertFalse(tdao.readAll().contains(c2), "There is no initial c2");
		
		tdao.create(c1);
		tdao.create(c2);
		
		for(Provincia p : tdao.readAll()) {
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
