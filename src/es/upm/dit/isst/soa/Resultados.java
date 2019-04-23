package es.upm.dit.isst.soa;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("resultados")
public class Resultados {
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public String getResultados(@DefaultValue("2016") @QueryParam("año") String año ){
		

		return "Results of '"+año+"' ";
	}
}
