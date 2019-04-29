package es.upm.dit.isst.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

public class Circunscripcion2016DAOImplementation {
	private static Circunscripcion2016DAOImplementation instance;
	private Circunscripcion2016DAOImplementation() {};
	
	
	public static Circunscripcion2016DAOImplementation getInstance() {
		if(null== instance) {
			instance = new Circunscripcion2016DAOImplementation();
		}
		return instance;
	}
	
//	//Para cada operación CRUD se sigue el siguiente patrón:
//	// 1. Se abre una sesión de hibernate
//	// 2. Hacerlas operaciones protegidas con try catch
//	// 3. Se incluyen las operaciones dentro de las transacciones
//	// 4. Se cierra la sesión.
//	
//	@Override
//	public void createProfessor(Circunscripcion2016 circunscripcion2016) {
//		Session session = SessionFactoryService.get().openSession();
//		try {
//			session.beginTransaction();
//			session.save(circunscripcion2016);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			// manejar excepciones
//		} finally {
//			session.close();
//		}
//		
//	}
//
//	@Override
//	public Professor readProfessor(String email) {
//		Professor professor = null;
//		Session session = SessionFactoryService.get().openSession();
//		try {
//			session.beginTransaction();
//			professor = session.get(Professor.class, email);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			// manejar excepciones
//		} finally {
//			session.close();
//		}
//		return professor;
//	}
//
//	@Override
//	public void updateProfessor(Professor professor) {
//		Session session = SessionFactoryService.get().openSession();
//		try {
//			session.beginTransaction();
//			session.saveOrUpdate(professor);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			// manejar excepciones
//		} finally {
//			session.close();
//		}
//		
//	}
//
//	@Override
//	public void deleteProfessor(Professor professor) {
//		Session session = SessionFactoryService.get().openSession();
//		try {
//			session.beginTransaction();
//			session.delete(professor);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			// manejar excepciones
//		} finally {
//			session.close();
//		}
//		
//	}
//
//	
//
//	@Override
//	public List<Professor> readAllProfessor() {
//		List<Professor> professors = new ArrayList<>();
//		Session session = SessionFactoryService.get().openSession();
//		try {
//			session.beginTransaction();
//			professors.addAll(
//					session.createQuery("from Professor").list()
//					);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			// manejar excepciones
//		} finally {
//			session.close();
//		}
//		return professors;
//	}

	
}
