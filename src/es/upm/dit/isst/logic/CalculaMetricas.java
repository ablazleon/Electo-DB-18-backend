package es.upm.dit.isst.logic;

public interface CalculaMetricas {

	public String[] loadIdParties2016();
	
	public void readVotesAndDHontSeats();
	
	public void findIdPartyMostVotedEachCircuncription();
	
	public void findPropFair();
	
}
