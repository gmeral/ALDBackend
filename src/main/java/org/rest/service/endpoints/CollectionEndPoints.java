package org.rest.service.endpoints;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.rest.service.dao.MuseumDao;
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
		MuseumDao dao = new MuseumDao();
		return dao.createCollectionQuery(artworks);
	}

	/* ---------------- CREATE DEFAULTS-----------------------*/
	@GET
	@Path("/create/byArtist/{artistName}")
	@Produces("application/json")
	public ArtCollection createCollectionByArtist(@PathParam("artistName")String artistName) {
		MuseumDao dao = new MuseumDao();
		return dao.createCollectionByArtistQuery(artistName);
	}
	
	@GET
	@Path("/create/byTechnique/{technique}")
	@Produces("application/json")
	public ArtCollection createCollectionByTechnique(@PathParam("technique")TypesAndTechniques.Technique tech) {
		MuseumDao dao = new MuseumDao();
		return dao.createCollectionByTechniqueQuery(tech);
	}
	
	@GET
	@Path("/create/byTag/{tag}")
	@Produces("application/json")
	public ArtCollection createCollectionByTag(@PathParam("tag")String tag) {
		MuseumDao dao = new MuseumDao();
		return dao.createCollectionByTagQuery(tag);
	}

	/* ---------------- UPDATE -----------------------*/
	@POST
	@Path("/update")
	@Consumes("application/json")
	public Response updateCollection(ArtCollection ac) {
		MuseumDao dao = new MuseumDao();
		return dao.updateCollectionQuery(ac);
	}

	/* ---------------- DELETE -----------------------*/
	@POST
	@Path("/delete")
	@Consumes("application/json")
	public Response deleteCollection(ArtCollection ac) {
		MuseumDao dao = new MuseumDao();
		return dao.deleteCollectionQuery(ac);
	}

}
