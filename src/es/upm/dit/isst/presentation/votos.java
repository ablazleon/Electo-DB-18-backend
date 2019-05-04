package es.upm.dit.isst.presentation;

public class votos {
	private String provincia;
	private int votos;
	private int escanos;
	
	public votos() {
		
	}
	
	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
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

	public votos(String provincia, int votos, int escanos) {
		this.provincia = provincia;
		this.votos = votos;
		this.escanos = escanos;
	}
}
