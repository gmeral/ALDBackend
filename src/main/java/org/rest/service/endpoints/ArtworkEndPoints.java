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
import org.rest.service.entities.Comment;
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

	@OPTIONS
	@Path("/addComment/{id}")
	public void addCommentOptions(){
	}

	/* ---------------- UPDATE -----------------------*/
	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	public Response updateArtwork(Artwork aw){
		ArtworkDao dao = new ArtworkDao();
		return dao.updateEntity(aw);
	}
	
	@PUT 
	@Path("/addComment/{id}") 
	@Consumes("application/json")
	public Response addComment(Comment c, @PathParam("id") int id){
		ArtworkDao dao = new ArtworkDao();
		return dao.addCommentQuery(id, c);
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
	@Path("/get/byTag/{tag}")
	@Produces("application/json")
	public List<Artwork> getArtworksByTag(@PathParam("tag") String tag){
		ArtworkDao dao = new ArtworkDao();
		return dao.getArtworksByTagQuery(tag);
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
	public List<Artwork> getArtworksByType(@PathParam("type")TypesAndTechniques.ArtWorkType type){
		ArtworkDao dao = new ArtworkDao();
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