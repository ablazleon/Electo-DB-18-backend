package es.upm.dit.isst.soa;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.*;

import org.json.JSONArray;
import org.json.JSONObject;

@Path("getTrip")
public class Test {

	@GET 
	@Produces({"text/html"})
	public String getTrip(@DefaultValue("MX") @QueryParam("origen") String origen, 
						  @QueryParam("destino") String destino){
		
		//1) Construir la petición: https://restcountries.eu/rest/v1/alpha?codes=mx
		Client client = ClientBuilder.newClient();
		String infoPais = client.target("https://restcountries.eu/rest/v1/alpha")
				.queryParam("codes", origen)
		        .request()
		        .get(String.class);
		//2) Recuperar el JSON devuelto (es un array en este caso) y procesarlo para obtener la información que se desea
		JSONArray arr = new JSONArray(infoPais);
		//La capital está en la primera posición (0) del array devuelto, en el atributo 'capital'
		String capital = arr.getJSONObject(0).getString("capital");
		//Recuperamos el primer prefijo telefónico que encontremos (array con nombre 'callingCodes')
		String prefijoInternacional = arr.getJSONObject(0).getJSONArray("callingCodes").getString(0);

		//3) Cerrar la conexión
		client.close();

		//5) Preparar la respuesta
		return "El codigo '"+origen+"' pertenece a un pais con capital '"+capital+"' y prefijo telefonico +"+prefijoInternacional;
	}
	
}
