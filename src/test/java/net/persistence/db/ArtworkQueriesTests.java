package net.persistence.db;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
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
import org.rest.service.dao.ArtworkDao;
import org.rest.service.entities.Artist;
import org.rest.service.entities.Artwork;
import org.rest.service.entities.Dimensions;
import org.rest.service.filters.JpaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArtworkQueriesTests {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Museum");
	static EntityManager em;
	static EntityTransaction tx;

	private static final Logger LOG = LoggerFactory.getLogger(ArtworkQueriesTests.class);


	@Rule public TestName name = new TestName();


	@AfterClass
	public static void closeEntityManager()throws Exception {
		emf.close();
	}

	@Before
	public void initTransaction() throws Exception {
		em = emf.createEntityManager();
		tx = em.getTransaction();
		JpaUtil.ENTITY_MANAGERS.set(em);
		seedData();
	}
	
	@After
	public void afterTests() throws Exception {
		Class driverClass = Class.forName("org.h2.Driver");
		Connection jdbcConnection = DriverManager.getConnection("jdbc:h2:mem://localhost:9101/dbunit", "sa", "");
		IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);
		connection.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());
		// full database export
		IDataSet fullDataSet = connection.createDataSet();
		FlatXmlDataSet.write(fullDataSet, new FileOutputStream("target/dbExport/" + name.getMethodName()+ ".xml"));
		FlatDtdDataSet.write(connection.createDataSet(), new FileOutputStream("target/dbExport/"+  "test2.dtd"));
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

	@Test
	public void BtestGetArtworkByTag() {
		Artwork aw1 = new Artwork("WOW");
		Set<String> tags1 = new HashSet<>();
		tags1.add("WOW");
		aw1.setTags(tags1);
		
		Artwork aw2 = new Artwork("AWESOME");
		Set<String> tags2 = new HashSet<>();
		tags2.add("AWESOME");
		aw2.setTags(tags2);
		
		try {
			tx.begin();
			em.persist(aw1);
			em.persist(aw2);
		}catch (RuntimeException re) {
			LOG.error("BtestTwoArtistsTwoArtworks failed", re);
			throw re;
		}finally{
			tx.commit();
		}
		
		ArtworkDao dao = new ArtworkDao();
		System.out.println(dao.getArtworksByTagQuery("WOW"));
	}
}
