package es.upm.dit.isst.presentation;

public class DatoPrueba {
	private mapa[] mapa;
	private votos[] votos;
	
	public DatoPrueba() {
		
	}
	
	public DatoPrueba (mapa[] mapa, votos[] votos) {
		this.mapa = mapa;
		this.votos = votos;
	}

	public mapa[] getMapa() {
		return mapa;
	}

	public void setMapa(mapa[] mapa) {
		this.mapa = mapa;
	}

	public votos[] getVotos() {
		return votos;
	}

	public void setVotos(votos[] votos) {
		this.votos = votos;
	}

}
