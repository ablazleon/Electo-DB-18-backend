package es.upm.dit.isst.presentation;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import es.upm.dit.isst.logic.CalculaMetricasImplementation;

import es.upm.dit.isst.persistence.dao.ProvinciaDAO;
import es.upm.dit.isst.persistence.dao.ProvinciaDAOImplementation;
import es.upm.dit.isst.persistence.model.Provincia;

@Path("resultados")
public class ResultadosResource {
	
	private static Resultados resultado;
	
	public static Provincia prov;
	
	public ResultadosResource(){
		
	}
	
	static {
		 resultado = new Resultados("PSOE", 4500000);
		 prov = new Provincia("Spain", 50);
		 ProvinciaDAO pdao = ProvinciaDAOImplementation.getInstance();
		 //pdao.create(prov);
	}
	
	//public String getResultados(@DefaultValue("2016") @QueryParam("anno") String anno ){
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public Resultados getResultados(@DefaultValue("PSOE") @QueryParam("partido") String partido ){
		
		CalculaMetricasImplementation cmi = new CalculaMetricasImplementation();
		//cmi.readPartidos();
		//cmi.readProvincias();
		cmi.readVotos();
		
		//Circunscripcion2016DAOImplementation.getInstance().readAll();
		//return "Results of '"+anno+"' ";
		return resultado;
	}
}
