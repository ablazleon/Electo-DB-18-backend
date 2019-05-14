package es.upm.dit.isst.persistance.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.dit.isst.persistence.dao.VotosDAO;
import es.upm.dit.isst.persistence.dao.VotosDAOImplementation;
import es.upm.dit.isst.persistence.model.Votos;


class VotosDAOImplementationTest {


	/**
	 * Comprueba que al crearse varios Ps, si se accede con readAll() estos Ps son los mismo que 
	 * los objeto P iniciales.
	 * 
	 */
	@Test
	void testCreateCirc2016CreatedMatchsCirc2016Read() {
		
		Votos c1 = new Votos();
		c1.setIdVotos(1);
		VotosDAO pdao = VotosDAOImplementation.getInstance();
		pdao.create(c1);
		
		Votos pread = pdao.read(c1.getIdVotos());
		
		assertEquals(pread.getIdVotos(), c1.getIdVotos());
	
		pdao.delete(c1);
	}
	
	/**
	 * Comprueba que al crearse varios Ps, si se accede con readAll() estos Ps son los mismo que 
	 * los objeto P iniciales.
	 * 
	 */
	@Test
	void testReadAll() {	
		
		Votos c1 = new Votos();
		c1.setIdVotos(1);
		Votos c2 = new Votos();
		c2.setIdVotos(2);
		
		VotosDAO tdao = VotosDAOImplementation.getInstance();
		
		assertFalse(tdao.readAll().contains(c1), "There is no initial c1");
		assertFalse(tdao.readAll().contains(c2), "There is no initial c2");
		
		tdao.create(c1);
		tdao.create(c2);
		
		for(Votos p : tdao.readAll()) {
			System.out.println(p.getIdVotos());
			if(p.getIdVotos() == c1.getIdVotos()) {
				assertTrue(p.getIdVotos() == c1.getIdVotos(), "There is tfg1");
			}
			if(p.getIdVotos() == c2.getIdVotos()) {
				assertTrue(p.getIdVotos() == c2.getIdVotos(), "There is tfg1");
				}
			}	
			tdao.delete(c1);
			tdao.delete(c2);
		}

}

	


