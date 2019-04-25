package es.upm.dit.isst.soa;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("resultados")
public class ResultadosResource {
	
	private static Resultados resultado;
	
	public ResultadosResource(){
		
	}
	
	static {
		 resultado = new Resultados("PSOE", 4500000);
	}
	
	//public String getResultados(@DefaultValue("2016") @QueryParam("anno") String anno ){
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public Resultados getResultados(@DefaultValue("PSOE") @QueryParam("partido") String partido ){
		//return "Results of '"+anno+"' ";
		return resultado;
	}
}
