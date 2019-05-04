package es.upm.dit.isst.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Partido2016 implements Serializable {
	
	@Id
	private String idPartido;
	
	private int votes;
	
	private int seatsDHont;
	
	private int seatsSL;
	
	public String getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(String idPartido) {
		this.idPartido = idPartido;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public int getSeatsDHont() {
		return seatsDHont;
	}

	public void setSeatsDHont(int seatsDHont) {
		this.seatsDHont = seatsDHont;
	}

	public int getSeatsSL() {
		return seatsSL;
	}

	public void setSeatsSL(int seatsSL) {
		this.seatsSL = seatsSL;
	}




}
