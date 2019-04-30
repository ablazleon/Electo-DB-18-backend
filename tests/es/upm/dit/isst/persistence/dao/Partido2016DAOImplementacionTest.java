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

	@Test
	void testCreatePartido2016CreatedMatchsPartido2016Read() {
		
		Partido2016 p1 = new Partido2016();
		p1.setIdPartido(1);
		Partido2016DAO pdao = Partido2016DAOImplementation.getInstance();
		pdao.create(p1);
		
		Partido2016 pread = pdao.read(p1.getIdPartido());
		
		assertEquals(pread.getIdPartido(), p1.getIdPartido());
		assertEquals(pread.getVotes(), p1.getVotes());
	
		pdao.delete(p1);
	}

	@Test
	void testReadAll() {
		fail("Not yet implemented");
	}

}
