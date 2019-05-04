package es.upm.dit.isst.persistence.dao;

import java.util.Collection;

import org.hibernate.Session;

import es.upm.dit.isst.persistence.dao.PartidoDAO;
import es.upm.dit.isst.persistence.model.Partido;

public class PartidoDAOImplementation implements PartidoDAO {

	private static  PartidoDAOImplementation instancia = null;
	
	private PartidoDAOImplementation() {}
	
	public static PartidoDAOImplementation getInstance() {
	  if( null == instancia ) 
	    instancia = new PartidoDAOImplementation();
	  return instancia;
	  
	}

	@Override
	public void create(Partido partido) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  // operaciones
		  session.save(partido);
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
		
	}

	@Override
	public Partido read(String idNombre) {
		Partido Partido = null;
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  // operaciones
		  Partido = session.get(Partido.class, idNombre);
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
		return Partido;
	}

	@Override
	public void update(Partido partido) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  // operaciones
		  session.saveOrUpdate(partido);
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
		
	}

	@Override
	public void delete(Partido partido) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  // operaciones
		  session.delete(partido);
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
	}
	
	@Override
	public Collection<Partido> readAll() {
		Collection<Partido> partidos = null;
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  // operaciones
		  partidos = session.createQuery("from Partido").list();
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
		return partidos;
	}
	
}
