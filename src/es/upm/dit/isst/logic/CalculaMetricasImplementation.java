package es.upm.dit.isst.logic;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CalculaMetricasImplementation implements CalculaMetricas{

	private Map<String, DataCSVElectionResource> csvStore = new HashMap<String, DataCSVElectionResource>();
	
	/**
	 * 1. Parteis are defined
	 * 2. Then, it is read from the csv.
	 */
	@Override
	public String[] loadIdParties2016() {
		String[] idParties= {"PP","PSOE","PODEMOS-IU-EQUO","C's","ERC-CATSI","CDC","EAJ-PNV","EH Bildu","CCa-PNC","PACMA","Recortes Cero-Grupo Verde","UPyD","VOX"};
		return idParties;
	}

	@Override
	public void readVotesAndDHontSeats() {
		File file = new File("C:\\Users\\ablaz\\git\\Electo-DB-18-backend_3\\2016.csv");
//		System.out.println("Working Directory = " +
//	              System.getProperty("user.dir"));
//		String filePath =  System.getProperty("user.dir");
//		
//		String fileName = filePath + "src/2016.csv";
//		System.out.println(Files.exists(Paths.get(fileName)));
		try {
			Reader in = new FileReader(file);
			CSVParser partyResults = CSVFormat.EXCEL
					.withHeader("idComunidad", "idCircunscripcion", "idYear", "idParty", "votes", "percentage", "seatsDhont", "idColor")
					.parse(in);
			for (CSVRecord pr : partyResults) {
				String idParty = pr.get("idParty");
				String idComunidad = pr.get("idComunidad");
				String idCircunscripcion = pr.get("idCircunscripcion");
				if( idComunidad == "0" && idCircunscripcion == "0") System.out.println("Campos que quiero");
					System.out.println("idParty: "+ idParty);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	@Override
	public void findIdPartyMostVotedEachCircuncription() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findPropFair() {
		// TODO Auto-generated method stub
		
	}

}