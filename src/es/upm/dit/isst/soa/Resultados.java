package es.upm.dit.isst.soa;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("resultados")
public class Resultados {
	@GET 
	@Produces({"text/html"})
	public String getResultados(@DefaultValue("2016") @QueryParam("a�o") String a�o ){
		

		return "Results of '"+a�o+"' ";
	}
}
