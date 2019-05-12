package es.upm.dit.isst.persistence.dao;

import java.util.Collection;
import java.util.List;

import es.upm.dit.isst.persistence.model.Provincia;

public interface ProvinciaDAO {
	
	public void create(Provincia partido);
	
	public Provincia read(String idNombre);

	public void update(Provincia partido);

	public void delete(Provincia partido);
	
	public List<Provincia> readAllSinNacional();
	
	public List<Provincia> readAll();
}
