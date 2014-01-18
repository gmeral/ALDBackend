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

@Path("museum/artist")
public class ArtistEndPoints {
	
	
	/* ---------------- CREATE -----------------------*/
	@POST
	@Path("/add")
	@Consumes("application/json")
	public Response addArtist(Artist ar){
		MuseumDao dao = new MuseumDao();
		return dao.persistArtist(ar);
	}
	
	/* ---------------- UPDATE -----------------------*/
	@POST
	@Path("/update")
	@Consumes("application/json")
	public Response updateArtist(Artist ar){
		MuseumDao dao = new MuseumDao();
		return dao.updateArtist(ar);
	}
	
	/* ---------------- DELETE -----------------------*/
	@POST
	@Path("/delete")
	@Consumes("application/json")
	public Response deleteArtist(Artist ar) {
		MuseumDao dao = new MuseumDao();
		return dao.deleteArtist(ar);
	}

	/* ---------------- GET -----------------------*/
	@GET
	@Path("get/all")
	@Produces("application/json")
	public List<Artist> getAllArtists() {
		MuseumDao dao = new MuseumDao();
		return dao.getAllArtistsQuery();		
	}
	
	@GET
	@Path("get/{id}")
	@Produces("application/json")
	public Artist getArtistById(@PathParam("id")int id) {
		MuseumDao dao = new MuseumDao();
		return dao.getArtistByIdQuery(id);
	}
	public List<Artist> getRepresentedArtists() {return null;}
}
