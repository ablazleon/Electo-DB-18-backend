package es.upm.dit.isst.presentation;

public class mapa {
	private String provincia;
	private String color;
	private String partido;
	private int votos;
	
	public mapa() {
			
	}
	
	public mapa(String provincia, String color, String partido, int votos) {
		this.provincia = provincia;
		this.color = color;
		this.partido = partido;
		this.votos = votos;
		
		
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
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
}
