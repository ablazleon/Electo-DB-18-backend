package es.upm.dit.isst.persistence.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Provincia {
	
	@Id
	private String idNombre;
	
	private int escanos;
	
	//@OneToMany(mappedBy="prov", fetch=FetchType.LAZY)
	//private List<Votos> votosPart;
	
	public Provincia() {
		
	}
	
	public Provincia(String nombre, int esc) {
		this.idNombre = nombre;
		this.escanos = esc;
	}

	public String getIdNombre() {
		return idNombre;
	}

	public void setIdNombre(String idNombre) {
		this.idNombre = idNombre;
	}

	public int getEscanos() {
		return escanos;
	}

	public void setEscanos(int escanos) {
		this.escanos = escanos;
	}
}
