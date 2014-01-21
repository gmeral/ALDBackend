package org.rest.service.endpoints;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.rest.service.dao.ArtworkDao;
import org.rest.service.dao.MuseumDao;
import org.rest.service.entities.Artwork;
import org.rest.service.entities.TypesAndTechniques;

@Path("/museum/artwork")
public class ArtworkEndPoints {

	static {
		MuseumDao dao = new MuseumDao();
		try {
			dao.seedData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* ---------------- CREATE -----------------------*/
	@POST
	@Path("/")
	@Consumes("application/json")
	public Response addArtwork(Artwork aw){
		ArtworkDao dao = new ArtworkDao();
		return dao.persistEntity(aw);
	}

	/* ---------------- OPTIONS -----------------------*/

	@OPTIONS
	@Path("/")
	public void addArtworkOptions(){
	}

	@OPTIONS
	@Path("/{id}")
	public void updateArtworkOptions(){
	}

	/* ---------------- UPDATE -----------------------*/
	@PUT
	@Path("/")
	@Consumes("application/json")
	public Response updateArtwork(Artwork aw){
		ArtworkDao dao = new ArtworkDao();
		return dao.updateEntity(aw);
	}
	
	/* ---------------- DELETE -----------------------*/
	@DELETE
	@Path("/{id}")
	public Response deleteArtwork(@PathParam("id")int id) {
		ArtworkDao dao = new ArtworkDao();
		return dao.deleteEntity(id);
	}

	/* ---------------- GET -----------------------*/
	@GET
	@Path("/get/all")
	@Produces("application/json")
	public List<Artwork> getAllArtworks(){
		ArtworkDao dao = new ArtworkDao();
		return dao.getAllArtworksQuery();
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Artwork getArtworkById(@PathParam("id") int id){
		ArtworkDao dao = new ArtworkDao();
		return (Artwork) dao.getEntityById(id);
	}
	
	@GET
	@Path("/get/byArtist/{artistName}")
	@Produces("application/json")
	public List<Artwork> getArtworksByArtist(@PathParam("artistName") String name){
		ArtworkDao dao = new ArtworkDao();
		return dao.getArtworksByArtistQuery(name);
	}

	@GET
	@Path("/get/byTechnique/{technique}")
	@Produces("application/json")
	public List<Artwork> getArtworksByTechnique(@PathParam("technique")TypesAndTechniques.Technique tech){
		ArtworkDao dao = new ArtworkDao();
		return dao.getArtworksByTechniqueQuery(tech);
	}
	
	@GET
	@Path("/get/byType/{type}")
	@Produces("application/json")
	public List<Artwork> getArtworksByTechnique(@PathParam("type")TypesAndTechniques.ArtWorkType type){
		MuseumDao dao = new MuseumDao();
		return dao.getArtworksByTypeQuery(type);
	}

	@GET
	@Path("/get/bySupport/{support}")
	@Produces("application/json")
	public List<Artwork> getArtworksBySupport(@PathParam("support")TypesAndTechniques.Support support){
		ArtworkDao dao = new ArtworkDao();
		return dao.getArtworksBySupportQuery(support);
	}
}