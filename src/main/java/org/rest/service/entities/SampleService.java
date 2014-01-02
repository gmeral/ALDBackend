package org.rest.service.entities;


import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatDtdDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.rest.service.filters.JpaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Path("/sampleservice")
public class SampleService {

	private static final Logger LOG = LoggerFactory.getLogger(SampleService.class);



	static { 
		Album album1 = new Album("Elephunk",new Date(), "HipHop");
		Calendar cal = Calendar.getInstance();
		cal.set(2003, 06, 24);
		album1.setDate(cal.getTime());

		Album album2 = new Album("Demon Days", new Date(), "HipHop" );
		cal.set(2005, 12, 6);
		album2.setDate(cal.getTime());

		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try{
			tx.begin();
			LOG.info("persist album1");
			em.persist(album1);
			LOG.info("persist album2");
			em.persist(album2);
		}catch(RuntimeException re) {
			LOG.error("static persistence in Sampleservice failed", re);
		}finally {
			tx.commit();
		}
	}

	@GET
	@Path("/albums")
	@Produces("application/xml")
	public List<Album> listAlbums() {
		LOG.info("get Albums XML");
		return getAllAlbumsQuery();
	}

	@GET
	@Path("/album/{albumId}")
	@Produces("application/xml")
	public Album getAlbum(@PathParam("albumId") String albumId) {
		LOG.info("get Album XML");
		return getAlbumByIdQuery(albumId);
	}

	@GET
	@Path("json/albums")
	@Produces("application/json")
	public List<Album> listAlbumsJSON() {
		LOG.info("get Albums JSON");
		return getAllAlbumsQuery();
	}

	@GET
	@Path("json/album/{albumId}")
	@Produces("application/json")
	public Album getAlbumJSON(@PathParam("albumId") String albumId) {
		LOG.info("get Album JSON");
		return getAlbumByIdQuery(albumId);
	}

	@POST
	@Path("/json/postalbum/")
	@Consumes("application/json")
	public Response persistAlbum(Album album){
		LOG.info("persistAlbum");
		EntityManager em= JpaUtil.getEntityManager();
		EntityTransaction tx=em.getTransaction();
		try{
			tx.begin();
			em.persist(album);
			LOG.debug("Add a new album ");
			return Response.ok(album).build();
		} catch (RuntimeException re) {
			LOG.error("add album failed", re);
			return Response.status(400).entity("Album create failed!").build();
		}finally{
			tx.commit();
			try {
				dumpDataBase();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public List<Album> getAllAlbumsQuery(){
		EntityManager em = JpaUtil.getEntityManager();
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

	public Album getAlbumByIdQuery(String id){ 
		EntityManager em = JpaUtil.getEntityManager();
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
	
	public void dumpDataBase() throws Exception {
		Class driverClass = Class.forName("org.h2.Driver");
		Connection jdbcConnection = DriverManager.getConnection("jdbc:h2:mem://localhost:9101/dbunit", "sa", "");
		IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);
		connection.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());
		// full database export
		IDataSet fullDataSet = connection.createDataSet();
		FlatXmlDataSet.write(fullDataSet, new FileOutputStream("target/"+"albumDB"+".xml"));
		FlatDtdDataSet.write(connection.createDataSet(), new FileOutputStream("target/"+"test.dtd"));
	}

}
