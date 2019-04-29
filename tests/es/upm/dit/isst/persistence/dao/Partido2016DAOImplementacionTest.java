package es.upm.dit.isst.persistence.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.dit.isst.webLab.dao.ProfessorDAO;
import es.upm.dit.isst.webLab.dao.ProfessorDAOImplementation;
import es.upm.dit.isst.webLab.model.Professor;

class Partido2016DAOImplementacionTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCreate() {
		
		Professor p1 = new Professor();
		p1.setEmail("ejemplopa@alumnos.upm.es");
		ProfessorDAO tdao = ProfessorDAOImplementation.getInstance();
		tdao.create(p1);
		
		Professor pread = tdao.read(p1.getEmail());
		
		assertEquals(pread.getEmail(), p1.getEmail());
		assertEquals(pread.getName(), p1.getName());
	
		tdao.delete(p1);
	}

	@Test
	void testReadAll() {
		fail("Not yet implemented");
	}

}
