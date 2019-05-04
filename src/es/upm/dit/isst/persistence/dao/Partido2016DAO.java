package es.upm.dit.isst.persistence.dao;

import java.util.List;

import es.upm.dit.isst.persistence.model.Partido2016;

public interface Partido2016DAO {

	public void create(Partido2016 p);
	
	public Partido2016 read(String idPartido);
	
	public void update(Partido2016 p);
	
	public void delete(Partido2016 p);
	
	public List<Partido2016> readAll();
	
}
