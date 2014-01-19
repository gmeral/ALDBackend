package org.rest.service.endpoints;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.rest.service.dao.ArtistDao;
import org.rest.service.entities.Artist;

@Path("museum/artist")
public class ArtistEndPoints {
	
	
	/* ---------------- CREATE -----------------------*/
	@POST
	@Path("/add")
	@Consumes("application/json")
	public Response addArtist(Artist ar){
		ArtistDao dao = new ArtistDao();
		return dao.persistEntity(ar);
	}
	
	/* ---------------- UPDATE -----------------------*/
	@POST
	@Path("/update")
	@Consumes("application/json")
	public Response updateArtist(Artist ar){
		ArtistDao dao = new ArtistDao();
		return dao.updateEntity(ar);
	}
	
	/* ---------------- DELETE -----------------------*/
	@POST
	@Path("/delete")
	@Consumes("application/json")
	public Response deleteArtist(Artist ar) {
		ArtistDao dao = new ArtistDao();
		return dao.deleteEntity(ar);
	}

	/* ---------------- GET -----------------------*/
	@GET
	@Path("get/all")
	@Produces("application/json")
	public List<Artist> getAllArtists() {
		ArtistDao dao = new ArtistDao();
		return dao.getAllArtistsQuery();		
	}
	
	@GET
	@Path("get/{id}")
	@Produces("application/json")
	public Artist getArtistById(@PathParam("id")int id) {
		ArtistDao dao = new ArtistDao();
		return (Artist)dao.getEntityById(id);
	}
	public List<Artist> getRepresentedArtists() {return null;}
}
