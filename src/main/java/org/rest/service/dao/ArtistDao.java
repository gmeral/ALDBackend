package org.rest.service.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.rest.service.entities.Artist;
import org.rest.service.entities.Artwork;
import org.slf4j.LoggerFactory;

public class ArtistDao extends AbstractMuseumDao {
	public ArtistDao() {
		super();
		entityClass = Artist.class;
		LOG = LoggerFactory.getLogger(this.getClass());
	}
	
	public  List<Artist> getAllArtistsQuery() {
		EntityTransaction  tx = em.getTransaction();

		List<Artist> list;
		try{
			tx.begin();
			Query q = em.createQuery("SELECT DISTINCT ar FROM Artist ar");
			list = q.getResultList();

			LOG.debug("get All Artists, result size: "+ list.size());
		} catch (RuntimeException re) {
			LOG.error("get all Artists failed", re);
			throw re;
		}finally{
			tx.commit();
		}
		return list;
	}
	
	public  Artist getArtistByNameQuery(String name) {
		EntityTransaction  tx = em.getTransaction();

		Artist ar;
		try{
			tx.begin();
			Query q = em.createQuery("SELECT DISTINCT ar FROM Artist ar WHERE ar.name := name");
			q.setParameter("name", name);
			ar =(Artist)q.getSingleResult();

			LOG.debug("get Artist by name : " + name);
		} catch (RuntimeException re) {
			LOG.error("get Artist by name failed", re);
			throw re;
		}finally{
			tx.commit();
		}
		return ar;
	}
}
