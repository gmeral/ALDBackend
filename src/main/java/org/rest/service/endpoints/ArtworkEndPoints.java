package org.rest.service.endpoints;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.rest.service.dao.MuseumDao;
import org.rest.service.entities.Artist;
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
	@Path("/add")
	@Consumes("application/json")
	public Response addArtwork(Artwork aw){
		MuseumDao dao = new MuseumDao();
		return dao.persistArtwork(aw);
	}

	/* ---------------- UPDATE -----------------------*/
	@POST
	@Path("/update")
	@Consumes("application/json")
	public Response updateArtwork(Artwork aw){
		MuseumDao dao = new MuseumDao();
		return dao.updateArtwork(aw);
	}
	
	/* ---------------- DELETE -----------------------*/
	@POST
	@Path("/delete")
	@Consumes("application/json")
	public Response deleteArtwork(Artwork ar) {
		MuseumDao dao = new MuseumDao();
		return dao.deleteArtwork(ar);
	}

	/* ---------------- GET -----------------------*/
	@GET
	@Path("/get/all")
	@Produces("application/json")
	public List<Artwork> getAllArtworks(){
		MuseumDao dao = new MuseumDao();
		return dao.getAllArtworksQuery();
	}
	
	@GET
	@Path("/get/{id}")
	@Produces("application/json")
	public Artwork getArtworkById(@PathParam("id") String id){
		MuseumDao dao = new MuseumDao();
		return dao.getArtworkByIdQuery(id);
	}
	
	@GET
	@Path("/get/byArtist/{artistName}")
	@Produces("application/json")
	public List<Artwork> getArtworksByArtist(@PathParam("artistName") String name){
		MuseumDao dao = new MuseumDao();
		return dao.getArtworksByArtistQuery(name);
	}

	@GET
	@Path("/get/byTechnique/{technique}")
	@Produces("application/json")
	public List<Artwork> getArtworksByTechnique(@PathParam("technique")TypesAndTechniques.Technique tech){
		MuseumDao dao = new MuseumDao();
		return dao.getArtworksByTechniqueQuery(tech);
	}

	@GET
	@Path("/get/bySupport/{support}")
	@Produces("application/json")
	public List<Artwork> getArtworksBySupport(@PathParam("support")TypesAndTechniques.Support support){
		MuseumDao dao = new MuseumDao();
		return dao.getArtworksBySupportQuery(support);
	}
}