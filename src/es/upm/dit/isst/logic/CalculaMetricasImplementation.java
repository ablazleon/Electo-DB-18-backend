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

import es.upm.dit.isst.persistence.dao.*;
import es.upm.dit.isst.persistence.model.*;

public class CalculaMetricasImplementation implements CalculaMetricas{

	private Map<String, DataCSVElectionResource> csvStore = new HashMap<String, DataCSVElectionResource>();
	
	@Override
	public void readProvincias() {
		File file = new File("C:\\Users\\ablaz\\git\\Electo-DB-18-backend3\\Provincia.csv");
		ProvinciaDAO prodao = ProvinciaDAOImplementation.getInstance();
		
//		System.out.println("Working Directory = " +
//	              System.getProperty("user.dir"));
//		String filePath =  System.getProperty("user.dir");
//		
//		String fileName = filePath + "src/2016.csv";
//		System.out.println(Files.exists(Paths.get(fileName)));
		try {
			Reader in = new FileReader(file);
			CSVParser partyResults = CSVFormat.EXCEL
					.withHeader("idProvincia", "escanos").withDelimiter(';')
					.parse(in);
			for (CSVRecord pr : partyResults) {
				
				String provR = pr.get("idProvincia");
				int escanosR = Integer.parseInt(pr.get("escanos"));
				
				Provincia provincia = new Provincia();
				provincia.setIdNombre(provR);
				provincia.setEscanos(escanosR);
				
				prodao.create(provincia);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void readPartidos() {
		File file = new File("C:\\Users\\ablaz\\git\\Electo-DB-18-backend3\\Partidos.csv");
		PartidoDAO pardao = PartidoDAOImplementation.getInstance();
		
//		System.out.println("Working Directory = " +
//	              System.getProperty("user.dir"));
//		String filePath =  System.getProperty("user.dir");
//		
//		String fileName = filePath + "src/2016.csv";
//		System.out.println(Files.exists(Paths.get(fileName)));
		try {
			Reader in = new FileReader(file);
			CSVParser partyResults = CSVFormat.EXCEL
					.withHeader("idPartidos", "color").withDelimiter(';')
					.parse(in);
			for (CSVRecord pr : partyResults) {
				
				String partR = pr.get("idPartidos");
				String colorR =pr.get("color");
				
				Partido partido = new Partido();
				partido.setIdNombre(partR);
				partido.setColor(colorR);
				
				pardao.create(partido);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void readVotos() {
		File file = new File("C:\\Users\\ablaz\\git\\Electo-DB-18-backend3\\Votos.csv");
		PartidoDAO pardao = PartidoDAOImplementation.getInstance();
		ProvinciaDAO prodao = ProvinciaDAOImplementation.getInstance();
		VotosDAO votdao = VotosDAOImplementation.getInstance();
		
//		System.out.println("Working Directory = " +
//	              System.getProperty("user.dir"));
//		String filePath =  System.getProperty("user.dir");
//		
//		String fileName = filePath + "src/2016.csv";
//		System.out.println(Files.exists(Paths.get(fileName)));
		try {
			Reader in = new FileReader(file);
			CSVParser partyResults = CSVFormat.EXCEL
					.withHeader("idVoto","votos", "fecha", "prov", "part").withDelimiter(';')
					.parse(in);
			for (CSVRecord pr : partyResults) {
				
				int votosR = Integer.parseInt(pr.get("votos"));
				int fechaR = Integer.parseInt(pr.get("fecha"));
				String provR = pr.get("prov");
				String partR = pr.get("part");
				
				Votos votos = new Votos();
				
				votos.setVotos(votosR);
				votos.setFecha(fechaR);
				
				votos.setProv(prodao.read(provR));
				votos.setPart(pardao.read(partR));
				
				votdao.create(votos);
						
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}