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

	@SuppressWarnings("unchecked")
	public  List<Artwork> getArtworksByArtistQuery(String name){
		EntityTransaction  tx = em.getTransaction();

		List<Artwork> list;
		try{
			tx.begin();
			Query q = em.createQuery("SELECT DISTINCT aw FROM Artwork aw, IN (aw.artists) a WHERE a.name = :name");
			LOG.debug("Artist name parameter received : " + name);
			q.setParameter("name", name);
			list = q.getResultList();
			LOG.debug("get Artworks by artist successfull, result size: "+ list.size());
		} catch (RuntimeException re) {
			LOG.error("get Artworks by artist failed", re);
			throw re;
		}finally{
			tx.commit();
		}
		return list;
	}
	
	public  Artwork getArtworkByIdQuery(String idParam){
		EntityTransaction  tx = em.getTransaction();

		Artwork artwork;
		int id = Integer.parseInt(idParam);

		try{
			tx.begin();
			//Query q = em.createQuery("SELECT DISTINCT aw FROM Artwork aw, IN (aw.id) i WHERE i = :id");
			artwork = em.find(Artwork.class, id);

			LOG.debug("Artist id parameter received : " + id);
			//q.setParameter("id", id);
			//artwork = (Artwork)q.getSingleResult();
			LOG.debug("get Artworks by id successfull, result");
		} catch (RuntimeException re) {
			LOG.error("get Artworks by id failed", re);
			throw re;
		}finally{
			tx.commit();
		}
		return artwork;
	}
	
	public  List<Artwork> getArtworksByTagQuery(String tag){
		EntityTransaction  tx = em.getTransaction();

		List<Artwork> list;
		try{
			tx.begin();
			Query q = em.createQuery("SELECT DISTINCT aw FROM Artwork aw, IN (aw.tags) t WHERE t = :tag");
			LOG.debug("Artist name parameter received : " + tag);
			q.setParameter("tag", tag);
			list = q.getResultList();
			LOG.debug("get Artworks by tag successfull, result size: "+ list.size());
		} catch (RuntimeException re) {
			LOG.error("get Artworks by tag failed", re);
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
	
	public Artist getArtistByIdQuery(int id){
		EntityTransaction  tx = em.getTransaction();

		Artist artist;

		try{
			tx.begin();
			//Query q = em.createQuery("SELECT DISTINCT aw FROM Artwork aw, IN (aw.id) i WHERE i = :id");
			artist = em.find(Artist.class, id);

			LOG.debug("Artwork id parameter received : " + id);
			//q.setParameter("id", id);
			//artwork = (Artwork)q.getSingleResult();
			LOG.debug("get Artworks by id successfull, result");
		} catch (RuntimeException re) {
			LOG.error("get Artworks by id failed", re);
			throw re;
		}finally{
			tx.commit();
		}
		return artist;
	}
	
	public Response persistArtist(Artist aw) {
		EntityTransaction  tx = em.getTransaction();
		try{
			tx.begin();
			em.persist(aw);
			LOG.debug("add Artist successfull : " + aw.getName());
			return Response.ok(aw).build();
		} catch (RuntimeException re) {
			LOG.error("add Artist failed", re);
			return Response.status(400).entity("Artist create failed!").build();
		}finally{
			tx.commit();
		}
	}
	
	public Response updateArtist(Artist aw) {
		EntityTransaction  tx = em.getTransaction();
		try{
			tx.begin();
			em.merge(aw);
			LOG.debug("update Artist successfull : " + aw.getName());
			return Response.ok(aw).build();
		} catch (RuntimeException re) {
			LOG.error("update Artist failed", re);
			return Response.status(400).entity("Artist create failed!").build();
		}finally{
			tx.commit();
		}
	}
	
	public Response deleteArtist(Artist aw) {
		EntityTransaction  tx = em.getTransaction();
		try{
			tx.begin();
			em.remove(aw);
			LOG.debug("update Artist successfull : " + aw.getName());
			return Response.ok(aw).build();
		} catch (RuntimeException re) {
			LOG.error("update Artist failed", re);
			return Response.status(400).entity("Artist create failed!").build();
		}finally{
			tx.commit();
		}
	}

	public Response persistArtwork(Artwork aw) {
		EntityTransaction  tx = em.getTransaction();
		try{
			tx.begin();
			em.persist(aw);
			LOG.debug("add Artwork successfull : " + aw.getTitle());
			return Response.ok(aw).build();
		} catch (RuntimeException re) {
			LOG.error("get all Artists failed", re);
			return Response.status(400).entity("Artwork create failed!").build();
		}finally{
			tx.commit();
		}
	}

	public Response updateArtwork(Artwork aw) {
		EntityTransaction  tx = em.getTransaction();
		try{
			tx.begin();
			em.merge(aw);
			LOG.debug("update Artwork successfull : " + aw.getTitle());
			return Response.ok(aw).build();
		} catch (RuntimeException re) {
			LOG.error("update artwork failed", re);
			return Response.status(400).entity("Artwork create failed!").build();
		}finally{
			tx.commit();
		}
	}

	public  List<Artwork> getArtworksByTechniqueQuery(TypesAndTechniques.Technique tech){
		EntityTransaction  tx = em.getTransaction();

		List<Artwork> list;
		try{
			tx.begin();
			Query q = em.createQuery("SELECT DISTINCT aw FROM Artwork aw WHERE aw.technique = :technique");
			LOG.debug("Technique parameter received : " + tech);
			q.setParameter("technique", tech);
			list = q.getResultList();
			LOG.debug("get Artworks by technique successfull, result size: "+ list.size());
		} catch (RuntimeException re) {
			LOG.error("get Artworks by technique failed", re);
			throw re;
		}finally{
			tx.commit();
		}
		return list;
	}

	public  List<Artwork> getArtworksByTypeQuery(TypesAndTechniques.ArtWorkType type){
		EntityTransaction  tx = em.getTransaction();

		List<Artwork> list;
		try{
			tx.begin();
			Query q = em.createQuery("SELECT DISTINCT aw FROM Artwork aw WHERE aw.type = :type");
			LOG.debug("Type parameter received : " + type);
			q.setParameter("type", type);
			list = q.getResultList();
			LOG.debug("get Artworks by type successfull, result size: "+ list.size());
		} catch (RuntimeException re) {
			LOG.error("get Artworks by type failed", re);
			throw re;
		}finally{
			tx.commit();
		}
		return list;
	}
	
	public  List<Artwork> getArtworksBySupportQuery(TypesAndTechniques.Support sup){
		EntityTransaction  tx = em.getTransaction();

		List<Artwork> list;
		try{
			tx.begin();
			Query q = em.createQuery("SELECT DISTINCT aw FROM Artwork aw WHERE aw.support= :support");
			LOG.debug("Technique parameter received : " + sup);
			q.setParameter("technique", sup);
			list = q.getResultList();
			LOG.debug("get Artworks by support successfull, result size: "+ list.size());
		} catch (RuntimeException re) {
			LOG.error("get Artworks by support failed", re);
			throw re;
		}finally{
			tx.commit();
		}
		return list;
	}
	
	public Response deleteArtwork(Artwork aw) {
		EntityTransaction  tx = em.getTransaction();
		try{
			tx.begin();
			em.remove(aw);
			LOG.debug("delete Artwork successfull : " + aw.getTitle());
			return Response.ok(aw).build();
		} catch (RuntimeException re) {
			LOG.error("delete Artwork failed", re);
			return Response.status(400).entity("Artwork delete failed!").build();
		}finally{
			tx.commit();
		}
	}
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
		List<Artwork> awList = getArtworksByArtistQuery(artistName);
		Set<Artwork> awSet = new HashSet<Artwork>(awList);
		return createCollectionQuery(awSet);
	}
	
	public ArtCollection createCollectionByTechniqueQuery(TypesAndTechniques.Technique tech) {
		List<Artwork> awList = getArtworksByTechniqueQuery(tech);
		Set<Artwork> awSet = new HashSet<Artwork>(awList);
		return createCollectionQuery(awSet);
	}
	
	public ArtCollection createCollectionByTagQuery(String tag) {
		List<Artwork> awList = getArtworksByTagQuery(tag);
		Set<Artwork> awSet = new HashSet<Artwork>(awList);
		return createCollectionQuery(awSet);
	}

	/* ---------------- UPDATE -----------------------*/
	public Response updateCollectionQuery(ArtCollection ac) {
		EntityTransaction  tx = em.getTransaction();
		try{
			tx.begin();
			em.merge(ac);
			LOG.debug("update Collection successfull " );
			return Response.ok(ac).build();
		} catch (RuntimeException re) {
			LOG.error("update Collection failed", re);
			return Response.status(400).entity("Collection create failed!").build();
		}finally{
			tx.commit();
		}
	}

	/* ---------------- DELETE -----------------------*/
	public Response deleteCollectionQuery(ArtCollection ac) {
		EntityTransaction  tx = em.getTransaction();
		try{
			tx.begin();
			em.remove(ac);
			LOG.debug("delete Collection successfull " );
			return Response.ok(ac).build();
		} catch (RuntimeException re) {
			LOG.error("delete Collection failed", re);
			return Response.status(400).entity("Collection deletefailed!").build();
		}finally{
			tx.commit();
		}
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
		aw1.addArtist(a1);
		aw2.addArtist(a2);
		aw3.addArtist(a3);
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
