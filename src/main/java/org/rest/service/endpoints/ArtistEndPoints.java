package org.rest.service.endpoints;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.rest.service.dao.MuseumDao;
import org.rest.service.entities.Artist;

@Path("museum/artist")
public class ArtistEndPoints {
	public List<Artist> getRepresentedArtists() {return null;}

	@GET
	@Path("get/all")
	@Produces("application/json")
	public List<Artist> getAllArtists() {
		MuseumDao dao = new MuseumDao();
		return dao.getAllArtistsQuery();		
	}
}
