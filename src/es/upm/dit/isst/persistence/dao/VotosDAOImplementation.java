package es.upm.dit.isst.persistence.dao;

import java.util.Collection;

import org.hibernate.Session;

import es.upm.dit.isst.persistence.dao.VotosDAO;
import es.upm.dit.isst.persistence.model.Votos;


public class VotosDAOImplementation implements VotosDAO {

	private static  VotosDAOImplementation instancia = null;
	
	private VotosDAOImplementation() {}
	
	public static VotosDAOImplementation getInstance() {
	  if( null == instancia ) 
	    instancia = new VotosDAOImplementation();
	  return instancia;
	  
	}

	@Override
	public void create(Votos votos) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  // operaciones
		  session.save(votos);
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
		
	}

	@Override
	public Votos read(int idVotos) {
		Votos votos = null;
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  // operaciones
		  votos = session.get(Votos.class, idVotos);
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
		return votos;
	}

	@Override
	public void update(Votos votos) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  // operaciones
		  session.saveOrUpdate(votos);
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
		
	}

	@Override
	public void delete(Votos votos) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  // operaciones
		  session.delete(votos);
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
	}

	@Override
	public Collection<Votos> readAll() {
		Collection<Votos> votosList = null;
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  // operaciones
		  votosList = session.createQuery("from Votos").list();
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
		return votosList;
	}

}
