package es.upm.dit.isst.persistence.dao;



import java.util.List;

import es.upm.dit.isst.persistence.model.Circunscripcion2016;

public interface Circunscripcion2016DAO {
		
	public void create(Circunscripcion2016 circunscripcion2016);
	
	public Circunscripcion2016 read(int idCirc);
	
	public void update(Circunscripcion2016 circunscripcion2016);
	
	public void delete(Circunscripcion2016 circunscripcion2016);
	
	public List<Circunscripcion2016> readAll();
}
