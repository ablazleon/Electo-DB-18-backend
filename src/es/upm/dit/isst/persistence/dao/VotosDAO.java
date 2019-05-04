package es.upm.dit.isst.persistence.dao;

import java.util.Collection;

import es.upm.dit.isst.persistence.model.Votos;

public interface VotosDAO {

	public void create(Votos votos);

	public Votos read(int idVotos );

	public void update(Votos votos);

	public void delete(Votos votos);

	public Collection<Votos> readAll();
	
}
