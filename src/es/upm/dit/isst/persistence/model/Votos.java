package es.upm.dit.isst.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
//import javax.persistance.GeneratedValue;
//import javax.persistance.GenerationType;


@Entity
public class Votos implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idVotos;
	
	private int votos;
	private int fecha;
	
	@ManyToOne
	private Provincia prov;
	
	@ManyToOne
	private Partido part;
	
	private int escD;
	private int escS;
	private int escP;
	
	public Votos() {
		
	}

	public long getIdVotos() {
		return idVotos;
	}

	public void setIdVotos(long idVotos) {
		this.idVotos = idVotos;
	}

	public int getVotos() {
		return votos;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}

	public int getFecha() {
		return fecha;
	}

	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

	public Provincia getProv() {
		return prov;
	}

	public void setProv(Provincia prov) {
		this.prov = prov;
	}

	public Partido getPart() {
		return part;
	}

	public void setPart(Partido part) {
		this.part = part;
	}

	public int getEscD() {
		return escD;
	}

	public void setEscD(int escD) {
		this.escD = escD;
	}

	public int getEscS() {
		return escS;
	}

	public void setEscS(int escS) {
		this.escS = escS;
	}
	
	public int getEscP() {
		return escP;
	}

	public void setEscP(int escP) {
		this.escP = escP;
	}


	
	
	

}
