package es.upm.dit.isst.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Circunscripcion2016 implements Serializable{
	
	@Id
	private int idCirc;
	
	private int idPartidoMasVotado;

	public int getIdCirc() {
		return idCirc;
	}

	public void setIdCirc(int idCirc) {
		this.idCirc = idCirc;
	}

	public int getIdPartidoMasVotado() {
		return idPartidoMasVotado;
	}

	public void setIdPartidoMasVotado(int idPartidoMasVotado) {
		this.idPartidoMasVotado = idPartidoMasVotado;
	}
	
	
}
