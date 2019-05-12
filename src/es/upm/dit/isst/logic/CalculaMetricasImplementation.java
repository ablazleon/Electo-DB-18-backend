package es.upm.dit.isst.logic;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		File file = new File("/home/isst/git/Electo-DB-18-backend/Provincia.csv");
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
					.withHeader("idProvincia", "escanos").withDelimiter(',')
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
		File file = new File("/home/isst/git/Electo-DB-18-backend/Partidos.csv");
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
					.withHeader("idPartidos", "color").withDelimiter(',')
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
		File file = new File("/home/isst/git/Electo-DB-18-backend/Votos2011.csv");
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
					.withHeader("votos", "fecha", "prov", "part").withDelimiter(',')
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
				
				votos.setEscD(0);
				votos.setEscS(0);
				
				votdao.create(votos);
						
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		file = new File("/home/isst/git/Electo-DB-18-backend/Votos2015.csv");
		
//		System.out.println("Working Directory = " +
//	              System.getProperty("user.dir"));
//		String filePath =  System.getProperty("user.dir");
//		
//		String fileName = filePath + "src/2016.csv";
//		System.out.println(Files.exists(Paths.get(fileName)));
		try {
			Reader in = new FileReader(file);
			CSVParser partyResults = CSVFormat.EXCEL
					.withHeader("votos", "fecha", "prov", "part").withDelimiter(',')
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
				
				votos.setEscD(0);
				votos.setEscS(0);
				
				votdao.create(votos);
						
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		file = new File("/home/isst/git/Electo-DB-18-backend/Votos.csv");
		
//		System.out.println("Working Directory = " +
//	              System.getProperty("user.dir"));
//		String filePath =  System.getProperty("user.dir");
//		
//		String fileName = filePath + "src/2016.csv";
//		System.out.println(Files.exists(Paths.get(fileName)));
		try {
			Reader in = new FileReader(file);
			CSVParser partyResults = CSVFormat.EXCEL
					.withHeader("votos", "fecha", "prov", "part").withDelimiter(',')
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
				
				votos.setEscD(0);
				votos.setEscS(0);
				
				votdao.create(votos);
						
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void rellenaEscanos(int anno) {
		ProvinciaDAO pdao = ProvinciaDAOImplementation.getInstance();
		VotosDAO vdao = VotosDAOImplementation.getInstance();
		List<Provincia> provincias = pdao.readAllSinNacional();
		System.out.println(provincias.size());
		for (Provincia e:provincias){
			// nombre de la provincia
			String nombreProvincia = e.getIdNombre();
			System.out.println(nombreProvincia);
			int nbEscanosTotales = e.getEscanos();
			
			// votos de los partidos de la provincia
			List<Votos> partidosProvincia = vdao.filtroPorAnnoYProvincia(anno, nombreProvincia);
			System.out.println(partidosProvincia.size());
			// blancos y validos de la provincia para calcular los totales
			List<Votos> blancosValidosProvincia = vdao.filtroPorAnnoYProvinciaBlancosValidos(anno, nombreProvincia);
			System.out.println(blancosValidosProvincia.size());
			Votos[] arrayBlancosValidos = new Votos[blancosValidosProvincia.size()];
			arrayBlancosValidos = blancosValidosProvincia.toArray(arrayBlancosValidos);
			
			// umbral de 3% de los votos totales
			double umbralVotos = ((double)arrayBlancosValidos[0].getVotos()+arrayBlancosValidos[1].getVotos())*0.03;			
			
			List<Votos> partidosConEscanos = new ArrayList<Votos>();
			
			// saca partidos con más de 3% de votos totales
			partidosProvincia.forEach(element -> {
				if ((double)element.getVotos()>umbralVotos) 
					partidosConEscanos.add(element);
			});
			
			Votos[] arrayPartidos = new Votos[partidosConEscanos.size()];
			arrayPartidos = partidosConEscanos.toArray(arrayPartidos);
			
			// array que guarda los escanos temporales:
			int[] arrayEscanosTemporales = new int[arrayPartidos.length];
			// array con los votos que quedan despues de cada division
			double[][] arrayVotosCalculoEscanos = new double[nbEscanosTotales+1][arrayPartidos.length];
			
			// bucle para inicializar los valores
			for (int i = 0; i < arrayPartidos.length; i++) {
				arrayEscanosTemporales[i]=0;
				arrayVotosCalculoEscanos[0][i] = (double)arrayPartidos[i].getVotos();
			}
			
			for (int i = 0; i < nbEscanosTotales; i++) {
				// indice del partido con maximos votos
				int indexMax = this.getIndexOfLargest(arrayVotosCalculoEscanos[i]);
				
				// asigna en la siguiente columna el partido con mas votos y le divide entre el valor correspondiente
				arrayVotosCalculoEscanos[i+1][indexMax] = (double)arrayVotosCalculoEscanos[0][indexMax]/((double)arrayEscanosTemporales[indexMax]+2.0);
				
				// copia el resto de partidos en la siguiente columna
				for (int j = 0; j < arrayPartidos.length; j++) {
					if (j == indexMax) continue;
					arrayVotosCalculoEscanos[i+1][j] = arrayVotosCalculoEscanos[i][j];
				}
				arrayEscanosTemporales[indexMax] += 1;
			}
			
			for (int i = 0; i < arrayPartidos.length; i++) {
				arrayPartidos[i].setEscD(arrayEscanosTemporales[i]);
				vdao.update(arrayPartidos[i]);
				System.out.println(arrayPartidos[i].getPart().getIdNombre()+": "+arrayEscanosTemporales[i]);
			}
		}
		
		
	}
	
	public void rellenaEscanosSaint(int anno) {
		ProvinciaDAO pdao = ProvinciaDAOImplementation.getInstance();
		VotosDAO vdao = VotosDAOImplementation.getInstance();
		List<Provincia> provincias = pdao.readAllSinNacional();
		System.out.println(provincias.size());
		for (Provincia e:provincias){
			// nombre de la provincia
			String nombreProvincia = e.getIdNombre();
			System.out.println(nombreProvincia);
			int nbEscanosTotales = e.getEscanos();
			
			// votos de los partidos de la provincia
			List<Votos> partidosProvincia = vdao.filtroPorAnnoYProvincia(anno, nombreProvincia);
			System.out.println(partidosProvincia.size());
			// blancos y validos de la provincia para calcular los totales
			List<Votos> blancosValidosProvincia = vdao.filtroPorAnnoYProvinciaBlancosValidos(anno, nombreProvincia);
			System.out.println(blancosValidosProvincia.size());
			Votos[] arrayBlancosValidos = new Votos[blancosValidosProvincia.size()];
			arrayBlancosValidos = blancosValidosProvincia.toArray(arrayBlancosValidos);
			
			// umbral de 3% de los votos totales
			double umbralVotos = ((double)arrayBlancosValidos[0].getVotos()+arrayBlancosValidos[1].getVotos())*0.03;			
			
			List<Votos> partidosConEscanos = new ArrayList<Votos>();
			
			// saca partidos con más de 3% de votos totales
			partidosProvincia.forEach(element -> {
				if ((double)element.getVotos()>umbralVotos) 
					partidosConEscanos.add(element);
			});
			
			Votos[] arrayPartidos = new Votos[partidosConEscanos.size()];
			arrayPartidos = partidosConEscanos.toArray(arrayPartidos);
			
			// array que guarda los escanos temporales:
			int[] arrayEscanosTemporales = new int[arrayPartidos.length];
			// array con los votos que quedan despues de cada division
			double[][] arrayVotosCalculoEscanos = new double[nbEscanosTotales+1][arrayPartidos.length];
			
			// bucle para inicializar los valores
			for (int i = 0; i < arrayPartidos.length; i++) {
				arrayEscanosTemporales[i]=0;
				arrayVotosCalculoEscanos[0][i] = (double)arrayPartidos[i].getVotos();
			}
			
			for (int i = 0; i < nbEscanosTotales; i++) {
				// indice del partido con maximos votos
				int indexMax = this.getIndexOfLargest(arrayVotosCalculoEscanos[i]);
				
				// asigna en la siguiente columna el partido con mas votos y le divide entre el valor correspondiente
				arrayVotosCalculoEscanos[i+1][indexMax] = (double)arrayVotosCalculoEscanos[0][indexMax]/(((double)arrayEscanosTemporales[indexMax])*2+1.0);
				
				// copia el resto de partidos en la siguiente columna
				for (int j = 0; j < arrayPartidos.length; j++) {
					if (j == indexMax) continue;
					arrayVotosCalculoEscanos[i+1][j] = arrayVotosCalculoEscanos[i][j];
				}
				arrayEscanosTemporales[indexMax] += 1;
			}
			
			for (int i = 0; i < arrayPartidos.length; i++) {
				arrayPartidos[i].setEscS(arrayEscanosTemporales[i]);
				vdao.update(arrayPartidos[i]);
				System.out.println(arrayPartidos[i].getPart().getIdNombre()+": "+arrayEscanosTemporales[i]);
			}
		}
	}
	
	public void rellenaEscanosNacional( int anno) {
		
		VotosDAO vdao = VotosDAOImplementation.getInstance();
		//Lista de todos los partidos presentados a las elecciones de ese anno
		List<Votos> votosN = vdao.readPartidosNacional(anno);
		//Bucle para recorrer estos partidos
		for (Votos e: votosN) {
			//Lista de todos los votos de un partido en cada provincia
			List<Votos> votosPartido = vdao.filtroPorAnnoYPartido(anno, e.getPart().getIdNombre());
			int escTotD = 0;
			int escTotS = 0;
			//Buccle para coger el nº de escaños de ese partido y sumarlos al total
			for(Votos q: votosPartido) {
				escTotD+= q.getEscD();
				escTotS+= q.getEscS();
			}
			e.setEscD(escTotD);
			e.setEscS(escTotS);
			vdao.update(e);
		}
	}
	
	private static int getIndexOfLargest( double[] array )
	{
	  if ( array == null || array.length == 0 ) return -1; 
	  int largest = 0;
	  for ( int i = 1; i < array.length; i++ )
	  {
	      if ( array[i] > array[largest] ) largest = i;
	  }
	  return largest;
	}

}