package org.rest.service.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityTransaction;
import javax.ws.rs.core.Response;

import org.rest.service.entities.ArtCollection;
import org.rest.service.entities.Artwork;
import org.rest.service.entities.TypesAndTechniques;

public class ArtCollectionDao extends AbstractMuseumDao {
	
	/* ---------------- CREATE CUSTOM -----------------------*/

	public ArtCollection createCollectionQuery(Set<Artwork> artworks) {
		EntityTransaction  tx = em.getTransaction();
		ArtCollection newCollection = new ArtCollection(artworks);
		try{
			tx.begin();
			em.persist(newCollection);
			LOG.debug("create Collection successfull, collection size : " + newCollection.getArtworks().size());
		} catch (RuntimeException re) {
			LOG.error("create Collection failed", re);
		}finally{
			tx.commit();
		}
		return newCollection;
	}
	
	/* ---------------- CREATE DEFAULTS-----------------------*/

	public ArtCollection createCollectionByArtistQuery(String artistName) {
		ArtworkDao dao = new ArtworkDao();
		List<Artwork> awList = dao.getArtworksByArtistQuery(artistName);
		Set<Artwork> awSet = new HashSet<Artwork>(awList);
		return createCollectionQuery(awSet);
	}
	public ArtCollection createCollectionByTechniqueQuery(TypesAndTechniques.Technique tech) {
		ArtworkDao dao = new ArtworkDao();
		List<Artwork> awList = dao.getArtworksByTechniqueQuery(tech);
		Set<Artwork> awSet = new HashSet<Artwork>(awList);
		return createCollectionQuery(awSet);
	}
	
	public ArtCollection createCollectionByTagQuery(String tag) {
		ArtworkDao dao = new ArtworkDao();
		List<Artwork> awList = dao.getArtworksByTagQuery(tag);
		Set<Artwork> awSet = new HashSet<Artwork>(awList);
		return createCollectionQuery(awSet);
	}
}
