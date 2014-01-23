package org.rest.service.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.ws.rs.core.Response;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DefaultDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.rest.service.entities.ArtCollection;
import org.rest.service.entities.Artist;
import org.rest.service.entities.Artwork;
import org.rest.service.entities.Comment;
import org.rest.service.entities.Dimensions;
import org.rest.service.entities.TypesAndTechniques;
import org.rest.service.filters.JpaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MuseumDao {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	private EntityManager em;

	public EntityManager getEntityManager() {
		return em;
	}

	public MuseumDao() {
		em = JpaUtil.getEntityManager();
	}

	
	public void seedData() throws Exception {

		EntityTransaction tx = em.getTransaction();
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
		Artwork aw1 = new Artwork(dim, TypesAndTechniques.Technique.AQUARELLE, TypesAndTechniques.ArtWorkType.PAINTING, TypesAndTechniques.Support.ARGILE, "Eh oui j'ai une description", "Et meme un titre", tags, cDate, comList);
		Artwork aw2 = new Artwork(dim, TypesAndTechniques.Technique.AQUARELLE, TypesAndTechniques.ArtWorkType.PAINTING, TypesAndTechniques.Support.ARGILE, "Un splendide truc au milieu de l'eau", "Liberty Island", tags, cDate, comList);
		Artwork aw3 = new Artwork(dim, TypesAndTechniques.Technique.AQUARELLE, TypesAndTechniques.ArtWorkType.PAINTING, TypesAndTechniques.Support.ARGILE, "Un arbre au milieu d'autres arbres, c'est chouette", "Arbre dans forêt", tags, cDate, comList);
		aw1.setPhotos("http://www.bubblews.com/assets/images/news/1030462292_1387305050.gif,http://hdwallres.com/wp-content/uploads/2013/10/art-image-wallpaper.jpg,http://us.123rf.com/400wm/400/400/sommai/sommai1111/sommai111100015/11108757-naive-fond-grunge-d-39-art.jpg,http://sola.org/wp-content/uploads/2013/10/Activities-Art-Image.jpg");
		Artist a1 = new Artist("Tom Savage");
		Artist a2 = new Artist("Jack Sparow");
		Artist a3 = new Artist("Eric Bouya");
		a1.setCity("Bordeaux");
		a2.setCity("Paris");
		a3.setCity("Lille");
		a1.setNationality("Français");
		a2.setNationality("Français");
		a3.setNationality("Français");
		a1.setDescription("Une description");
		a2.setDescription("Une description");
		a3.setDescription("Une autre description");
		a1.setPhoto("http://www.jonathan-menet.fr/blog/wp-content/uploads/2013/07/faces-artiste-Vince-Low-7.jpg");
		a2.setPhoto("http://www.jonathan-menet.fr/blog/wp-content/uploads/2013/07/faces-artiste-Vince-Low-7.jpg");
		a3.setPhoto("http://www.jonathan-menet.fr/blog/wp-content/uploads/2013/07/faces-artiste-Vince-Low-7.jpg");
		a1.setBirthDate(new Date());
		a2.setBirthDate(new Date());
		a3.setBirthDate(new Date());
		a1.setType(TypesAndTechniques.ArtWorkType.PAINTING);
		a2.setType(TypesAndTechniques.ArtWorkType.DRAWING);
		a3.setType(TypesAndTechniques.ArtWorkType.PHOTO);
//		aw1.addArtist(a1);
//		aw2.addArtist(a2);
//		aw3.addArtist(a3);
		try {
			tx.begin();
			em.persist(aw1);
			em.persist(aw2);
			em.persist(aw3);
			em.persist(a1);
			em.persist(a2);
			em.persist(a3);

		}catch (RuntimeException re) {
			LOG.error("DtestArtWorkWithTitle failed", re);
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
