package es.upm.dit.isst.presentation;

public class votos {
	private String partido;
	private int votos;
	private int escanos;
	
	public votos() {
		
	}

	public votos(String partido, int votos, int escanos) {
		this.partido = partido;
		this.votos = votos;
		this.escanos = escanos;
	}

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

	public int getVotos() {
		return votos;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}

	public int getEscanos() {
		return escanos;
	}

	public void setEscanos(int escanos) {
		this.escanos = escanos;
	}
	
}
