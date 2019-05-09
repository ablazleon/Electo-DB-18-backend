package es.upm.dit.isst.presentation;

public class votos {
	private String partido;
	private int votos;
	private int escanos;
	private String color;
	
	public votos() {
		
	}

	public votos(String partido, int votos, int escanos, String color) {
		this.partido = partido;
		this.votos = votos;
		this.escanos = escanos;
		this.color = color;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
