package es.upm.dit.isst.persistence.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.persistence.dao.VotosDAO;
import es.upm.dit.isst.persistence.model.Votos;


public class VotosDAOImplementation implements VotosDAO {

	private static VotosDAOImplementation instancia = null;
	
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
	public Votos read(long idVotos) {
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
	public List<Votos> filtroPorAnnoYProvincia(int anno, String prov) {
		List<Votos> votosList = null;
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  // operaciones
		  votosList = (List<Votos>)session.createQuery("select v from Votos v where v.fecha = :anno AND v.prov.idNombre = :prov AND v.part.idNombre NOT IN ('Censo', 'null', 'Votantes', 'Nulos', 'Validos', 'Blancos')")
				  .setParameter("prov", prov)
				  .setParameter("anno", anno)
				  .list();
				 
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
		return votosList;
	}
	
	public List<Votos> filtroPorAnnoYProvinciaBlancosValidos(int anno, String prov) {
		List<Votos> votosList = null;
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  // operaciones
		  votosList = (List<Votos>)session.createQuery("select v from Votos v where v.fecha = :anno AND v.prov.idNombre = :prov AND v.part.idNombre IN ('Validos', 'Blancos')")
				  .setParameter("prov", prov)
				  .setParameter("anno", anno)
				  .list();
				 
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
		return votosList;
	}
	
	@Override
	public List<Votos> filtroPorAnno(int anno) {
		List<Votos> votosList = null;
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  // operaciones
		  votosList = (List<Votos>)session.createQuery("select v from Votos v where v.fecha = :anno AND v.part.idNombre NOT IN ('Censo', 'null', 'Votantes', 'Nulos', 'Validos', 'Blancos') ORDER BY v.prov.idNombre, v.votos DESC")
				  .setParameter("anno", anno)
				  .list();
				 
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
		return votosList;
	}
	
	@Override
	public List<Votos> readPartidosNacional(int anno) {
		List<Votos> partidos = null;
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  // operaciones
		  partidos = session.createQuery("select v from Votos v where v.fecha = :anno AND v.prov.idNombre = 'Nacional' AND v.part.idNombre NOT IN ('Censo', 'null', 'Votantes', 'Nulos', 'Validos', 'Blancos')")
				  .setParameter("anno", anno)
				  .list();
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
		return partidos;
	}
	
	@Override
	public List<Votos> filtroPorAnnoYPartido(int anno, String part) {
		List<Votos> partidos = null;
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		try {
		  session.beginTransaction();
		  // operaciones
		  partidos = session.createQuery("select v from Votos v where v.fecha = :anno AND v.part.idNombre = :part ")
				  .setParameter("anno", anno)
				  .setParameter("part", part)
				  .list();
		  session.getTransaction().commit();
		} catch (Exception e) {
		  // manejar excepciones
		} finally {
		  session.close();
		}
		return partidos;
	}

	@Override
	public List<Votos> readAll() {
		List<Votos> votosList = null;
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
