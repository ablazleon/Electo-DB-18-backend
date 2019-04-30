package es.upm.dit.isst.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.persistence.model.Partido2016;


public class Partido2016DAOImplementation implements Partido2016DAO{
	private static Partido2016DAOImplementation instance;
	private Partido2016DAOImplementation() {};
	
	
	public static Partido2016DAOImplementation getInstance() {
		if(null== instance) {
			instance = new Partido2016DAOImplementation();
		}
		return instance;
	}
	
	//Para cada operación CRUD se sigue el siguiente patrón:
	// 1. Se abre una sesión de hibernate
	// 2. Hacerlas operaciones protegidas con try catch
	// 3. Se incluyen las operaciones dentro de las transacciones
	// 4. Se cierra la sesión.
	
	@Override
	public void create(Partido2016 p) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(p);
			session.getTransaction().commit();
		} catch (Exception e) {
			// manejar excepciones
		} finally {
			session.close();
		}
		
	}

	@Override
	public Partido2016 read(int idPartido) {
		Partido2016 c = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			c = session.get(Partido2016.class, idPartido);
			session.getTransaction().commit();
		} catch (Exception e) {
			// manejar excepciones
		} finally {
			session.close();
		}
		return c;
	}

	@Override
	public void update(Partido2016 c) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(c);
			session.getTransaction().commit();
		} catch (Exception e) {
			// manejar excepciones
		} finally {
			session.close();
		}
		
	}

	@Override
	public void delete(Partido2016 c) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(c);
			session.getTransaction().commit();
		} catch (Exception e) {
			// manejar excepciones
		} finally {
			session.close();
		}
		
	}

	

	@Override
	public List<Partido2016> readAll() {
		List<Partido2016> cs = new ArrayList<>();
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			cs.addAll(
					session.createQuery("from Partido2016").list()
					);
			session.getTransaction().commit();
		} catch (Exception e) {
			// manejar excepciones
		} finally {
			session.close();
		}
		return cs;
	}

}
