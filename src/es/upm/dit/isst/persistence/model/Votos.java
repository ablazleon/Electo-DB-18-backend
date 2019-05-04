package es.upm.dit.isst.persistence.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistance.GeneratedValue;
import javax.persistance.GenerationType;


@Entity
public class Votos implements Serializable{
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idVotos;
	
	private int votos;
	private Date fecha;
	
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Partido getPart() {
		return part;
	}

	public void setPart(Partido part) {
		this.part = part;
	}

	private int escD;
	private int escS;
	private String provincia;
	
	@ManyToOne
	private Partido part;

}
