package es.upm.dit.isst.persistence.model;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Partido implements Serializable{

	@Id
	private String idNombre;
	
	private String color;
	
	//@OneToMany(mappedBy="part", fetch=FetchType.LAZY)
	//private List<Votos> votosPart;

	public Partido () {
		
	}
	
	public String getIdNombre() {
		return idNombre;
	}

	public void setIdNombre(String idNombre) {
		this.idNombre = idNombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}	
}
