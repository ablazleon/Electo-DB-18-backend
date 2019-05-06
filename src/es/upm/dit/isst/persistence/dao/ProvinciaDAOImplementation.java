package es.upm.dit.isst.persistence.dao;

import java.util.Collection;

import org.hibernate.Session;

import es.upm.dit.isst.persistence.model.Provincia;

public class ProvinciaDAOImplementation implements ProvinciaDAO {
	private static  ProvinciaDAOImplementation instancia = null;
	
	private ProvinciaDAOImplementation() {}
	
	public static ProvinciaDAOImplementation getInstance() {
	  if( null == instancia ) 
	    instancia = new ProvinciaDAOImplementation();
	  return instancia;
	  
	}

	@Override
	public void create(Provincia provincia) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  // operaciones
		  session.save(provincia);
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
		
	}

	@Override
	public Provincia read(String idNombre) {
		Provincia provincia = null;
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  // operaciones
		  provincia = session.get(Provincia.class, idNombre);
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
		return provincia;
	}

	@Override
	public void update(Provincia provincia) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  // operaciones
		  session.saveOrUpdate(provincia);
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
		
	}

	@Override
	public void delete(Provincia provincia) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  // operaciones
		  session.delete(provincia);
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
	}
	
	@Override
	public Collection<Provincia> readAll() {
		Collection<Provincia> partidos = null;
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  // operaciones
		  partidos = session.createQuery("from Provincia").list();
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
		return partidos;
	}
}
