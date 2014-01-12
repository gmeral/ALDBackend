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
public class ArtWorkPersistenceTests {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Museum");
	static EntityManager em;
	static EntityTransaction tx;

	private static final Logger LOG = LoggerFactory.getLogger(ArtWorkPersistenceTests.class);


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

	@Test
	public void AtestArtWorkWithDimensions() {
		Dimensions dim = new Dimensions(15,20,30);
		Artwork aw = new Artwork(dim);
		try {
			tx.begin();
			em.persist(aw);
		}catch (RuntimeException re) {
			LOG.error("AtestArtWorkWithDimensions failed", re);
			throw re;
		}finally{
			tx.commit();
		}
	}

	@Test
	public void BtestArtWorkWithEnum() {
		Dimensions dim = new Dimensions(20,20,30);
		Artwork aw = new Artwork(dim, TypesAndTechniques.Technique.AQUARELLE, TypesAndTechniques.ArtWorkType.DRAWING, TypesAndTechniques.Support.ARGILE);
		try {
			tx.begin();
			em.persist(aw);
		}catch (RuntimeException re) {
			LOG.error("BtestArtWorkWithEnum() failed", re);
			throw re;
		}finally{
			tx.commit();
		}
	}

	@Test
	public void CtestArtWorkWithDescription() {
		Dimensions dim = new Dimensions(20,20,30);
		Artwork aw = new Artwork(dim, TypesAndTechniques.Technique.AQUARELLE, TypesAndTechniques.ArtWorkType.DRAWING, TypesAndTechniques.Support.ARGILE, "Eh oui j'ai une description");
		try {
			tx.begin();
			em.persist(aw);
		}catch (RuntimeException re) {
			LOG.error("CtestArtWorkWithDescription failed", re);
			throw re;
		}finally{
			tx.commit();
		}
	}

	@Test
	public void DtestArtWorkWithTitle() {
		Dimensions dim = new Dimensions(20,20,30);
		Artwork aw = new Artwork(dim, TypesAndTechniques.Technique.AQUARELLE, TypesAndTechniques.ArtWorkType.DRAWING, TypesAndTechniques.Support.ARGILE, "Eh oui j'ai une description", "Et meme un titre !");
		try {
			tx.begin();
			em.persist(aw);
		}catch (RuntimeException re) {
			LOG.error("DtestArtWorkWithTitle failed", re);
			throw re;
		}finally{
			tx.commit();
		}
	}

	@Test
	public void EtestArtWorkWithTags() {
		Dimensions dim = new Dimensions(20,20,30);
		Set<String> tags = new HashSet<String>();
		tags.add("AQUARELLE");
		tags.add("WOW");
		tags.add("AWESOME");
		Artwork aw = new Artwork(dim, TypesAndTechniques.Technique.AQUARELLE, TypesAndTechniques.ArtWorkType.PAINTING, TypesAndTechniques.Support.ARGILE, "Eh oui j'ai une description", "Et meme un titre ! Et aussi des tags", tags);
		try {
			tx.begin();
			em.persist(aw);
		}catch (RuntimeException re) {
			LOG.error("DtestArtWorkWithTitle failed", re);
			throw re;
		}finally{
			tx.commit();
		}
	}

	@Test
	public void FtestArtWorkWithDate() {
		Dimensions dim = new Dimensions(20,20,30);
		Set<String> tags = new HashSet<String>();
		tags.add("AQUARELLE");
		tags.add("WOW");
		tags.add("AWESOME");
		Date cDate = new Date();
		Artwork aw = new Artwork(dim, TypesAndTechniques.Technique.AQUARELLE, TypesAndTechniques.ArtWorkType.PAINTING, TypesAndTechniques.Support.ARGILE, "Eh oui j'ai une description", "Et meme un titre ! et une date de creation", tags, cDate);
		try {
			tx.begin();
			em.persist(aw);
		}catch (RuntimeException re) {
			LOG.error("DtestArtWorkWithTitle failed", re);
			throw re;
		}finally{
			tx.commit();
		}
	}

	@Test
	public void GtestArtWorkWithComments() {
		Dimensions dim = new Dimensions(20,20,30);
		Set<String> tags = new HashSet<String>();
		tags.add("AQUARELLE");
		tags.add("WOW");
		tags.add("AWESOME");
		Date cDate = new Date();
		Comment com1 = new Comment("gmeral", "com1 : OneToManyyyyy", new Date());
		Comment com2 = new Comment("pchanson", "com2 : JoinColumnnnn", new Date());
		List<Comment> comList = new ArrayList<Comment>();
		comList.add(com1);
		comList.add(com2);
		Artwork aw = new Artwork(dim, TypesAndTechniques.Technique.AQUARELLE, TypesAndTechniques.ArtWorkType.PAINTING, TypesAndTechniques.Support.ARGILE, "Eh oui j'ai une description", "Et meme un titre ! et des commentaires", tags, cDate, comList);
		try {
			tx.begin();
			em.persist(aw);
		}catch (RuntimeException re) {
			LOG.error("DtestArtWorkWithTitle failed", re);
			throw re;
		}finally{
			tx.commit();
		}
	}

	@Test
	public void HtestArtworkPersistCascade() {
		Dimensions dim = new Dimensions(20,20,30);
		Artwork aw = new Artwork(dim,"thing"); 
		Artist a1 = new Artist("paul");
		Set<Artist> thingContributors = new HashSet<Artist>();
		thingContributors.add(a1);
		aw.setArtists(thingContributors);
		try {
			tx.begin();
			em.persist(aw);
			em.persist(a1);
		}catch (RuntimeException re) {
			LOG.error("DtestArtWorkWithTitle failed", re);
			throw re;
		}finally{
			tx.commit();
		}
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



}
