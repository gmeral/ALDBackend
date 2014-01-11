package org.rest.service.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DefaultDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.rest.service.entities.Artist;
import org.rest.service.entities.Artwork;
import org.rest.service.entities.Dimensions;
import org.rest.service.filters.JpaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MuseumDao {
	private static final Logger LOG = LoggerFactory.getLogger(AlbumDao.class);
	private EntityManager em;

	public EntityManager getEntityManager() {
		return em;
	}

	public MuseumDao() {
		em = JpaUtil.getEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	public  List<Artwork> getArtworksByArtistQuery(Artist ar){
		EntityTransaction  tx = em.getTransaction();

		List<Artwork> list;
		try{
			tx.begin();
			Query q = em.createQuery("SELECT DISTINCT aw FROM Artwork aw, IN (aw.artists) a WHERE a.name = :name");
			q.setParameter("name", ar.getName());
			list = q.getResultList();
			
			LOG.debug("get Artworks by artist successfull, result size: "+ list.size());
		} catch (RuntimeException re) {
			LOG.error("get Artworks by artist successfull failed", re);
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
	
	public void seedData() throws Exception {
		
		EntityTransaction tx = em.getTransaction();
		Dimensions dim = new Dimensions(15,20,30);
		Artwork aw1 = new Artwork(dim, "Chat");
		Artwork aw2 = new Artwork(dim, "Chien");
		Artist a1 = new Artist("catLover");
		Artist a2 = new Artist("dogLover");
		aw1.addArtist(a1);
		aw1.addArtist(a2);
		aw2.addArtist(a1);
		aw2.addArtist(a2);
		a1.addArtwork(aw1);
		a1.addArtwork(aw2);
		a2.addArtwork(aw1);
		a2.addArtwork(aw2);
		try {
			tx.begin();
			em.persist(aw1);
			em.persist(aw2);
			em.persist(a1);
			em.persist(a2);
		}catch (RuntimeException re) {
			LOG.error("AtestTwoArtistsTwoArtworks failed", re);
			throw re;
		}finally{
			tx.commit();
		}
//		tx.begin();
//		Connection connection = em.unwrap(java.sql.Connection.class);
//		try {
//			IDatabaseConnection dbUnitCon = new DatabaseConnection(connection);
//			dbUnitCon.getConfig()
//			.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());
//			IDataSet dataset;
//			FlatXmlDataSetBuilder flatXmlDataSetBuilder = new FlatXmlDataSetBuilder();
//			flatXmlDataSetBuilder.setColumnSensing(true);
//			InputStream in =Thread.currentThread()
//					.getContextClassLoader()
//					.getResourceAsStream("data/dataset.xml");
//			if(in !=null){
//				LOG.warn("DataSet found");
//				dataset = flatXmlDataSetBuilder.build(in);
//			} else {
//				LOG.warn("DataSet not found");
//				dataset= new DefaultDataSet();
//			}
//			DatabaseOperation.REFRESH.execute(dbUnitCon, dataset);
//		} finally {
//			tx.commit();
//		}
	}
}
