package es.upm.dit.isst.presentation;


public class Resultados {
	
	private String partidoVoto = "";
	private int votos = 0;
	
	public Resultados() {
		
	}
	
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


