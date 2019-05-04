package es.upm.dit.isst.logic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculaMetricasImplementationTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testReadVotesAndDHontSeats2016() {
		CalculaMetricasImplementation cmi = new CalculaMetricasImplementation();
		cmi.readVotesAndDHontSeats();
	}

}
