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

	@Test
	public void fillDB() {
		Dimensions dim = new Dimensions(20,20,30);
		Set<String> tags = new HashSet<String>();
		tags.add("AFRIQUE");
		Artwork aw = new Artwork(dim, TypesAndTechniques.Technique.GOUACHE, TypesAndTechniques.ArtWorkType.PAINTING, TypesAndTechniques.Support.CARTON);
		aw.setTitle("Afrique, terre de la Terre");
		aw.setDescription("Portrait, femme aux cheveux de terre, gouache sur carton.");
		aw.setPhotos("http://www.oliance.com/huan/images/i_afriq01.jpg");
		aw.setTags(tags);

		Set<String> tags2 = new HashSet<String>();
		tags2.add("TURBAN");
		Artwork aw2 = new Artwork(dim, TypesAndTechniques.Technique.PEINTURE_HUILE, TypesAndTechniques.ArtWorkType.PAINTING, TypesAndTechniques.Support.TOILE_DE_LIN);
		aw2.setTitle("La Jeune Fille à la perle");
		aw2.setDescription("La Jeune Fille à la perle ou La Jeune Fille au turban (Meisje met de parel) est un tableau de Johannes Vermeer peint vers 1665, exposé au Mauritshuis de La Haye (huile sur toile, 45 × 40 cm). On l'appelle aussi la « Joconde du Nord ».");
		aw2.setPhotos("http://upload.wikimedia.org/wikipedia/commons/thumb/6/66/Johannes_Vermeer_%281632-1675%29_-_The_Girl_With_The_Pearl_Earring_%281665%29.jpg/280px-Johannes_Vermeer_%281632-1675%29_-_The_Girl_With_The_Pearl_Earring_%281665%29.jpg");
		aw2.setTags(tags2);
		
		Set<String> tags3 = new HashSet<String>();
		tags3.add("TECHNIQUEIMPROBABLE");
		Artwork aw3 = new Artwork(dim, TypesAndTechniques.Technique.CHALUMEAU, TypesAndTechniques.ArtWorkType.DRAWING, TypesAndTechniques.Support.PAPIER);
		aw3.setTitle("Road by night");
		aw3.setDescription("Paul Chojnowski mouille divers endroits de feuilles de papier avec de l’eau puis les il les brûle avec un chalumeau pour noircir certaines zones.");
		aw3.setPhotos("http://www.laboiteverte.fr/wp-content/uploads/2011/06/peinture-feu-eau-02.jpg");
		aw3.setTags(tags3);
		
		Set<String> tags4 = new HashSet<String>();
		tags4.add("EAU");
		Artwork aw4 = new Artwork(dim, TypesAndTechniques.Technique.PEINTURE_EAU, TypesAndTechniques.ArtWorkType.PAINTING, TypesAndTechniques.Support.PAPIER);
		aw4.setTitle("Douche");
		aw4.setDescription("peinture réaliste");
		aw4.setPhotos("http://www.laboiteverte.fr/wp-content/uploads/2011/01/peinture-realiste-eau-01.jpg");
		aw4.setTags(tags4);
		
		Set<String> tags5 = new HashSet<String>();
		tags5.add("CIRQUE");
		Artwork aw5 = new Artwork(dim, null, TypesAndTechniques.ArtWorkType.PHOTO, TypesAndTechniques.Support.PAPIER);
		aw5.setTitle("Elephant du cirque");
		aw5.setDescription("Quel équilibre !");
		aw5.setPhotos("http://golem13.fr/wp-content/uploads/2013/07/Thomas-Subtil-04.jpg");
		aw5.setTags(tags5);
		
		Set<String> tags6 = new HashSet<String>();
		tags6.add("MIAM");
		Artwork aw6 = new Artwork(dim, null, TypesAndTechniques.ArtWorkType.SCULPTURE, TypesAndTechniques.Support.BANANE);
		aw6.setTitle("Rocker");
		aw6.setDescription("Créations d’un japonais qui sculpte ses bananes.");
		aw6.setPhotos("http://www.tuxboard.com/photos/2011/04/Sculpture-banane-rocker.jpg");
		aw6.setTags(tags6);

		Artist a1 = new Artist("FREDERIC HUAN");
		Artist a2 = new Artist("Johannes Vermeer");
		Artist a3 = new Artist("Paul Chojnowski");
		Artist a4 = new Artist("Astrid Linne");
		Artist a5 = new Artist("Thomas Subtil");
		Artist a6 = new Artist("Un Japonais");
		
		a1.setNationality("Français");
		a1.setPhoto("http://acs-horizons.fr/uploads/images/fredhuan.jpg");
		
		a2.setNationality("Neerlandaise");
		a2.setBirthDate(new Date(1632, 10, 31));
		a2.setPhoto("http://upload.wikimedia.org/wikipedia/commons/thumb/4/46/Cropped_version_of_Jan_Vermeer_van_Delft_002.jpg/220px-Cropped_version_of_Jan_Vermeer_van_Delft_002.jpg");
		
		a3.setNationality("Americain");
		a3.setPhoto("http://oneotafilmfestival.com/wp-content/uploads/Burt_Chojnowski.jpg");
		
		a4.setPhoto("http://se.stallviken.com/image/cache/data/productpics/Astrid_Tank_Grey/Astrid_Tank_Grey-750x750.jpg");
		
		a5.setPhoto("http://s.ipernity.com/T/L/z.gif");
		a5.setNationality("Française");
		a5.setCity("Paris");
		
		a6.setPhoto("http://photos.tuxboard.com/wp-content/uploads/2009/11/japonais-Sal9000-et-son-jeu.jpg");
		
		
		aw.setArtistName(a1.getName());
		aw2.setArtistName(a2.getName());
		aw3.setArtistName(a3.getName());
		aw4.setArtistName(a4.getName());
		aw5.setArtistName(a5.getName());
		aw6.setArtistName(a6.getName());
		try {
			tx.begin();
			em.persist(a1);
			em.persist(a2);
			em.persist(a3);
			em.persist(a4);
			em.persist(a5);
			em.persist(a6);
			em.persist(aw);
			em.persist(aw2);
			em.persist(aw3);
			em.persist(aw4);
			em.persist(aw5);
			em.persist(aw6);

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
		FlatDtdDataSet.write(connection.createDataSet(), new FileOutputStream("target/dbExport/"+  "test.dtd"));
	}



}
