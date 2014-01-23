package net.persistence.db;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DefaultDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatDtdDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.rest.service.entities.Artist;
import org.rest.service.entities.Artwork;
import org.rest.service.entities.Comment;
import org.rest.service.entities.Dimensions;
import org.rest.service.entities.TypesAndTechniques;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ManytoManyPersistenceTests {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Museum");
	static EntityManager em;
	static EntityTransaction tx;

	private static final Logger LOG = LoggerFactory.getLogger(ManytoManyPersistenceTests.class);


	@Rule public TestName name = new TestName();


	@AfterClass
	public static void closeEntityManager()throws Exception {
		emf.close();
	}

	@Before
	public void initTransaction() throws Exception {
		em = emf.createEntityManager();
		tx = em.getTransaction();
		seedData();
	}

	protected void seedData() throws Exception {
		tx.begin();
		Connection connection = em.unwrap(java.sql.Connection.class);
		try {
			IDatabaseConnection dbUnitCon = new DatabaseConnection(connection);
			dbUnitCon.getConfig()
			.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());
			IDataSet dataset;
			FlatXmlDataSetBuilder flatXmlDataSetBuilder = new FlatXmlDataSetBuilder();
			flatXmlDataSetBuilder.setColumnSensing(true);
			InputStream in =Thread.currentThread()
					.getContextClassLoader()
					.getResourceAsStream("data/dataset.xml");
			if(in !=null){
				LOG.warn("DataSet found");
				dataset = flatXmlDataSetBuilder.build(in);
			} else {
				LOG.warn("DataSet not found");
				dataset= new DefaultDataSet();
			}
			DatabaseOperation.REFRESH.execute(dbUnitCon, dataset);
		} finally {
			tx.commit();
		}
	}

//	@Test
//	public void AtestTwoArtistsTwoArtworks() {
//		System.out.println("TROLOLOLO");
//		Dimensions dim = new Dimensions(15,20,30);
//		Artwork aw1 = new Artwork(dim, "Chat");
//		Artwork aw2 = new Artwork(dim, "Chien");
//		Artist a1 = new Artist("catLover");
//		Artist a2 = new Artist("dogLover");
//		aw1.addArtist(a1);
//		aw1.addArtist(a2);
//		aw2.addArtist(a1);
//		aw2.addArtist(a2);
//		a1.addArtwork(aw1);
//		a1.addArtwork(aw2);
//		a2.addArtwork(aw1);
//		a2.addArtwork(aw2);
//		try {
//			tx.begin();
//			em.persist(aw1);
//			em.persist(aw2);
//			em.persist(a1);
//			em.persist(a2);
//		}catch (RuntimeException re) {
//			LOG.error("AtestTwoArtistsTwoArtworks failed", re);
//			throw re;
//		}finally{
//			tx.commit();
//		}
//	}

	
	@After
	public void afterTests() throws Exception {
		Class driverClass = Class.forName("org.h2.Driver");
		Connection jdbcConnection = DriverManager.getConnection("jdbc:h2:mem://localhost:9101/dbunit", "sa", "");
		IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);
		connection.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());
		// full database export
		IDataSet fullDataSet = connection.createDataSet();
		FlatXmlDataSet.write(fullDataSet, new FileOutputStream("target/dbExport/" + name.getMethodName()+ ".xml"));
		FlatDtdDataSet.write(connection.createDataSet(), new FileOutputStream("target/dbExport/"+  "test.dtd"));
	}



}
