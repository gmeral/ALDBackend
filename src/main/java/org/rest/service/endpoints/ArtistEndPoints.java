package org.rest.service.endpoints;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.eclipse.persistence.annotations.UnionPartitioning;
import org.rest.service.dao.ArtistDao;
import org.rest.service.entities.Artist;

@Path("museum/artist")
public class ArtistEndPoints {
	
	
	/* ---------------- CREATE -----------------------*/
	@POST
	@Path("/")
	@Consumes("application/json")
	public Response addArtist(Artist ar){
		ArtistDao dao = new ArtistDao();
		return dao.persistEntity(ar);
	}

	/* ---------------- OPTIONS -----------------------*/

	@OPTIONS
	@Path("/")
	public void addArtistOptions(){
	}

	@OPTIONS
	@Path("/{id}")
	public void updateArtistOptions(){
	}
	
	/* ---------------- UPDATE -----------------------*/
	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	public Response updateArtist(Artist ar){
		ArtistDao dao = new ArtistDao();
		return dao.updateEntity(ar);
	}
	
	/* ---------------- DELETE -----------------------*/
	@DELETE
	@Path("/{id}")
	public Response deleteArtist(@PathParam("id")int id) {
		ArtistDao dao = new ArtistDao();
		return dao.deleteEntity(id);
	}

	/* ---------------- GET -----------------------*/
	@GET
	@Path("/all")
	@Produces("application/json")
	public List<Artist> getAllArtists() {
		ArtistDao dao = new ArtistDao();
		return dao.getAllArtistsQuery();		
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Artist getArtistById(@PathParam("id")int id) {
		ArtistDao dao = new ArtistDao();
		return (Artist)dao.getEntityById(id);
	}
	
	@GET
	@Path("/byName/{name}")
	@Produces("application/json")
	public Artist getArtistByName(@PathParam("name")String name) {
		ArtistDao dao = new ArtistDao();
		return dao.getArtistByNameQuery(name);
	}
	
	@GET 
	@Path("/listByName/{name}")
	@Produces("application/json")
	public List<Artist> getArtistListByName(@PathParam("name")String name) {
		ArtistDao dao = new ArtistDao();
		return dao.getArtistListByNameQuery(name);
	}

	@GET
	@Path("/byCity/{city}")
	@Produces("application/json")
	public List<Artist> getArtistByCity(@PathParam("city")String city) {
		ArtistDao dao = new ArtistDao();
		return dao.getArtistByCityQuery(city);
	}
	
	@GET
	@Path("/byNationality/{nationality}")
	@Produces("application/json")
	public List<Artist> getArtistByNationality(@PathParam("nationality")String nationality) {
		ArtistDao dao = new ArtistDao();
		return dao.getArtistByNationalityQuery(nationality);
	}
	public List<Artist> getRepresentedArtists() {return null;}
}
