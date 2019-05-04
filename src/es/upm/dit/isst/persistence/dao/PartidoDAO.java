package es.upm.dit.isst.persistence.dao;

import java.util.Collection;

import es.upm.dit.isst.persistence.model.Partido;

public interface PartidoDAO {

	public void create(Partido partido);
	
	public Partido read(String idNombre);

	public void update(Partido partido);

	public void delete(Partido partido);

	public Collection<Partido> readAll();
	
}
