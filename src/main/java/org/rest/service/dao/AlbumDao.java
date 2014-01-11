package org.rest.service.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DefaultDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.h2.mvstore.db.TransactionStore.Transaction;
import org.rest.service.endpoints.AlbumEndPoints;
import org.rest.service.entities.Album;
import org.rest.service.filters.JpaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlbumDao {

	private static final Logger LOG = LoggerFactory.getLogger(AlbumDao.class);
	private EntityManager em;
	
	public EntityManager getEntityManager() {
		return em;
	}

	public AlbumDao() {
		em = JpaUtil.getEntityManager();
	}
	
	public  List<Album> getAllAlbumsQuery(){
		EntityTransaction  tx = em.getTransaction();

		List<Album> list;
		try{
			tx.begin();
			list = em.createQuery("select u from Album u").getResultList();
			LOG.debug("get all ALbums successfull, result size: "+ list.size());
		} catch (RuntimeException re) {
			LOG.error("get all albums failed", re);
			throw re;
		}finally{
			tx.commit();
		}
		return list;
	}

	public  Album getAlbumByIdQuery(String id){ 
		EntityTransaction tx = em.getTransaction();

		Album al;
		int idParam = Integer.parseInt(id);
		try{
			tx.begin();
			al = em.find(Album.class, idParam);
			LOG.debug("get ALbums by id successfull, id: "+ id );
		} catch (RuntimeException re) {
			LOG.error("get album by id failed", re);
			throw re;
		}finally{
			tx.commit();
		}
		return al;
	}
	
	
}
