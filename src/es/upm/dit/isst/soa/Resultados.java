package es.upm.dit.isst.soa;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


public class Resultados {
	
	private String partidoVoto = "";
	private int votos = 0;
	
	public Resultados(String partido, int votos) {
		this.partidoVoto = partido;
		this.votos = votos;
	}
	
	public String getPartidoVoto() {
		return partidoVoto;
	}
	
	public void setPartidoVoto(String partidoVoto) {
		this.partidoVoto = partidoVoto;
	}



	public int getVotos() {
		return votos;
	}



	public void setVotos(int votos) {
		this.votos = votos;
	}

	
}


