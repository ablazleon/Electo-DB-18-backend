package es.upm.dit.isst.logic;

public class DataCSVElectionResource {
	
	private int votes;
	
	private int dhontSeats;
	
	public DataCSVElectionResource(int votes, int dhontSeats) {
		super();
		this.votes = votes;
		this.dhontSeats = dhontSeats;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public int getDhontSeats() {
		return dhontSeats;
	}

	public void setDhontSeats(int dhontSeats) {
		this.dhontSeats = dhontSeats;
	}
	
	
}