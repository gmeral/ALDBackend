package org.rest.service.endpoints;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
	public Response addArtwork(Artwork aw){return null;}
	
	/* ---------------- UPDATE -----------------------*/
	public Response updateArtwork(Artwork aw){return null;}
	
	/* ---------------- GET -----------------------*/
	@GET
	@Path("/get/all")
	@Produces("application/json")
	public List<Artwork> getAllArtworks(){
		MuseumDao dao = new MuseumDao();
		return dao.getAllArtworksQuery();
	}
	@Path("/get/byArtist")
	@Consumes("application/json")
	@Produces("application/json")
	public List<Artwork> getArtworksByArtist(Artist ar){
		MuseumDao dao = new MuseumDao();
		return dao.getArtworksByArtistQuery(ar);
	}
	
	public List<Artwork> getArtworksByTechnique(TypesAndTechniques.Technique tech){return null;}
	public List<Artwork> getArtworksBySupport(TypesAndTechniques.Technique support){return null;}
}