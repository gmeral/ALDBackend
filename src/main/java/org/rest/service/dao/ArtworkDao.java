package org.rest.service.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.ws.rs.core.Response;

import org.rest.service.entities.Artist;
import org.rest.service.entities.Artwork;
import org.rest.service.entities.Comment;
import org.rest.service.entities.MuseumEntity;
import org.rest.service.entities.TypesAndTechniques;
import org.slf4j.LoggerFactory;

public class ArtworkDao extends AbstractMuseumDao {
	public ArtworkDao() {
		super();
		entityClass = Artwork.class;
		LOG = LoggerFactory.getLogger(this.getClass());
	}
	
	/* Version de getArtworksByArtistQuery avec la relation ManytoMany */

	// public  List<Artwork> getArtworksByArtistQuery(String name){
	// 	EntityTransaction  tx = em.getTransaction();
	// 	List<Artwork> list;
	// 	try{
	// 		tx.begin();
	// 		Query q = em.createQuery("SELECT DISTINCT aw FROM Artwork aw, IN (aw.artists) a WHERE a.name = :name");
	// 		LOG.debug("Artist name parameter received : " + name);
	// 		q.setParameter("name", name);
	// 		list = q.getResultList();
	// 		LOG.debug("get Artworks by artist successfull, result size: "+ list.size());
	// 	} catch (RuntimeException re) {
	// 		LOG.error("get Artworks by artist failed", re);
	// 		throw re;
	// 	}finally{
	// 		tx.commit();
	// 	}
	// 	return list;
	// }

	public  List<Artwork> getArtworksByArtistQuery(String name){
		EntityTransaction  tx = em.getTransaction();
		List<Artwork> list;
		try{
			tx.begin();
			Query q = em.createQuery("SELECT DISTINCT aw FROM Artwork aw WHERE aw.artistName REGEXP :name");
			LOG.debug("Artist name parameter received : " + name);
			q.setParameter("name", ".*" + name + ".*");
			list = q.getResultList();
			LOG.debug("get Artworks by artist successfull, result size: "+ list.size());
		} catch (RuntimeException re) {
			LOG.error("get Artworks by artist failed", re);
			throw re;
		}finally{
			tx.commit();
		}
		return list;
	}
	
	/*Methodologie Objet pour une requête complexe impliquant une collection d'élément basique*/

	public  List<Artwork> getArtworksByTagQuery(String tag){
		ArtworkDao dao = new ArtworkDao();
		List<Artwork> list;
		List<Artwork> resultList = new ArrayList<>();
		list = dao.getAllArtworksQuery();
		for (Artwork aw : list)
			if (aw.getTags().contains(tag))
				resultList.add(aw);
		return resultList;
	}

	public  List<Artwork> getAllArtworksQuery() {
		EntityTransaction  tx = em.getTransaction();

		List<Artwork> list;
		try{
			tx.begin();
			Query q = em.createQuery("SELECT DISTINCT aw FROM Artwork aw");
			list = q.getResultList();

			LOG.debug("get All Artworks, result size: "+ list.size());
		} catch (RuntimeException re) {
			LOG.error("get all Artworks failed", re);
			throw re;
		}finally{
			tx.commit();
		}
		return list;
	}

	public  List<Artwork> getArtworksByTechniqueQuery(TypesAndTechniques.Technique tech){
		EntityTransaction  tx = em.getTransaction();

		List<Artwork> list;
		try{
			tx.begin();
			Query q = em.createQuery("SELECT DISTINCT aw FROM Artwork aw WHERE aw.technique = :technique");
			LOG.debug("Technique parameter received : " + tech);
			q.setParameter("technique", tech);
			list = q.getResultList();
			LOG.debug("get Artworks by technique successfull, result size: "+ list.size());
		} catch (RuntimeException re) {
			LOG.error("get Artworks by technique failed", re);
			throw re;
		}finally{
			tx.commit();
		}
		return list;
	}

	public  List<Artwork> getArtworksBySupportQuery(TypesAndTechniques.Support sup){
		EntityTransaction  tx = em.getTransaction();

		List<Artwork> list;
		try{
			tx.begin();
			Query q = em.createQuery("SELECT DISTINCT aw FROM Artwork aw WHERE aw.support= :support");
			LOG.debug("Technique parameter received : " + sup);
			q.setParameter("support", sup);
			list = q.getResultList();
			LOG.debug("get Artworks by support successfull, result size: "+ list.size());
		} catch (RuntimeException re) {
			LOG.error("get Artworks by support failed", re);
			throw re;
		}finally{
			tx.commit();
		}
		return list;
	}

	public  List<Artwork> getArtworksByTypeQuery(TypesAndTechniques.ArtWorkType type){
		EntityTransaction  tx = em.getTransaction();

		List<Artwork> list;
		try{
			tx.begin();
			Query q = em.createQuery("SELECT DISTINCT aw FROM Artwork aw WHERE aw.type = :type");
			LOG.debug("Type parameter received : " + type);
			q.setParameter("type", type);
			list = q.getResultList();
			LOG.debug("get Artworks by type successfull, result size: "+ list.size());
		} catch (RuntimeException re) {
			LOG.error("get Artworks by type failed", re);
			throw re;
		}finally{
			tx.commit();
		}
		return list;
	}

	public  List<Artwork> getArtworksByNameQuery(String name){
		EntityTransaction  tx = em.getTransaction();

		List<Artwork> list;
		try{
			tx.begin();
			Query q = em.createQuery("SELECT DISTINCT aw FROM Artwork aw WHERE aw.title REGEXP :name");
			LOG.debug("Name parameter received : " + name);
			q.setParameter("name", name);
			list = q.getResultList();
			LOG.debug("get Artworks by name successfull, result size: "+ list.size());
		} catch (RuntimeException re) {
			LOG.error("get Artworks by name failed", re);
			throw re;
		}finally{
			tx.commit();
		}
		return list;
	}

	public Response addCommentQuery(int id, Comment c) {
		Artwork updatee = (Artwork)this.getEntityById(id);
		updatee.addComment(c);
		return this.updateEntity(updatee);
	}

	public  List<Artwork> getRepresentedArtworksQuery() {
		EntityTransaction  tx = em.getTransaction();

		List<Artwork> ar;
		try{
			tx.begin();
			Query q = em.createQuery("SELECT DISTINCT aw FROM Artwork aw WHERE aw.isExposed = true");
			ar =q.getResultList();

			LOG.debug("get Represented Artwork" + ar.size());
		} catch (RuntimeException re) {
			LOG.error("get Represented Artwork failed", re);
			throw re;
		}finally{
			tx.commit();
		}
		return ar;
	}
}
