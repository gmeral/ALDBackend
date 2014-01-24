package org.rest.service.dao;

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
                Query q = em.createQuery("SELECT DISTINCT aw FROM Artwork aw WHERE aw.artistName = :name");
                LOG.debug("Artist name parameter received : " + name);
                q.setParameter("name", name);
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
	
	public  List<Artwork> getArtworksByTagQuery(String tag){
		EntityTransaction  tx = em.getTransaction();

		List<Artwork> list;
		try{
			tx.begin();
			Query q = em.createQuery("SELECT DISTINCT aw FROM Artwork aw, IN (aw.tags) t WHERE t = :tag");
			LOG.debug("Artist name parameter received : " + tag);
			q.setParameter("tag", tag);
			list = q.getResultList();
			LOG.debug("get Artworks by tag successfull, result size: "+ list.size());
		} catch (RuntimeException re) {
			LOG.error("get Artworks by tag failed", re);
			throw re;
		}finally{
			tx.commit();
		}
		return list;
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
			q.setParameter("technique", sup);
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
	
	public Response addCommentQuery(int id, Comment c) {
		Artwork updatee = (Artwork)this.getEntityById(id);
		updatee.addComment(c);
		return this.updateEntity(updatee);
	}
}
