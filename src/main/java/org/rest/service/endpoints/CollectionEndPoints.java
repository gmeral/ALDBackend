package org.rest.service.endpoints;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.rest.service.dao.ArtCollectionDao;
import org.rest.service.entities.ArtCollection;
import org.rest.service.entities.Artwork;
import org.rest.service.entities.TypesAndTechniques;

@Path("museum/collection")
public class CollectionEndPoints {

	/* ---------------- CREATE -----------------------*/
	@POST
	@Path("/create")
	@Consumes("application/json")
	@Produces("application/json")
	public ArtCollection createCollection(Set<Artwork> artworks) {
		ArtCollectionDao dao = new ArtCollectionDao();
		return dao.createCollectionQuery(artworks);
	}

	/* ---------------- CREATE DEFAULTS-----------------------*/
	@GET
	@Path("/create/byArtist/{artistName}")
	@Produces("application/json")
	public ArtCollection createCollectionByArtist(@PathParam("artistName")String artistName) {
		ArtCollectionDao dao = new ArtCollectionDao();
		return dao.createCollectionByArtistQuery(artistName);
	}
	
	@GET
	@Path("/create/byTechnique/{technique}")
	@Produces("application/json")
	public ArtCollection createCollectionByTechnique(@PathParam("technique")TypesAndTechniques.Technique tech) {
		ArtCollectionDao dao = new ArtCollectionDao();
		return dao.createCollectionByTechniqueQuery(tech);
	}
	
	@GET
	@Path("/create/byTag/{tag}")
	@Produces("application/json")
	public ArtCollection createCollectionByTag(@PathParam("tag")String tag) {
		ArtCollectionDao dao = new ArtCollectionDao();
		return dao.createCollectionByTagQuery(tag);
	}

	/* ---------------- UPDATE -----------------------*/
	@PUT
	@Path("/")
	@Consumes("application/json")
	public Response updateCollection(ArtCollection ac) {
		ArtCollectionDao dao = new ArtCollectionDao();
		return dao.updateEntity(ac);
	}

	/* ---------------- DELETE -----------------------*/
	@DELETE
	@Path("/{id}")
	public Response deleteCollection(@PathParam("id") int id) {
		ArtCollectionDao dao = new ArtCollectionDao();
		return dao.deleteEntity(id);
	}

}
