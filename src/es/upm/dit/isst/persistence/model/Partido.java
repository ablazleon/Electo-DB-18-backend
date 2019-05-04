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
	
	@OneToMany(mappedBy="part", fetch=FetchType.EAGER)
	private List<Votos> votosPart;

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

	public List<Votos> getVotosPart() {
		return votosPart;
	}

	public void setVotosPart(List<Votos> votosPart) {
		this.votosPart = votosPart;
	}
	
	
	
}
