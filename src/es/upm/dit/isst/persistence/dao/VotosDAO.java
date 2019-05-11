package es.upm.dit.isst.persistence.dao;

import java.util.Collection;
import java.util.List;

import es.upm.dit.isst.persistence.model.Votos;

public interface VotosDAO {

	public void create(Votos votos);

	public Votos read(long idVotos );

	public void update(Votos votos);

	public void delete(Votos votos);
	
	public List<Votos> filtroPorAnnoYProvincia(int anno, String prov);
	
	public List<Votos> filtroPorAnno(int anno);

	public List<Votos> readAll();
	
	public void CalculaD(List<Votos> votosList);
	
	public void CalculaS(List<Votos> votosList);

	
}
