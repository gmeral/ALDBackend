package org.rest.service.endpoints;

import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.rest.service.entities.ArtCollection;
import org.rest.service.entities.Artist;
import org.rest.service.entities.Artwork;
import org.rest.service.entities.TypesAndTechniques;

@Path("museum/collection")
public class CollectionEndPoints {
	
	/* ---------------- CREATE -----------------------*/
	public Response createCollection(List<Artwork> artworks) {return null;}
	
	/* ---------------- CREATE DEFAULTS-----------------------*/
	public Response createCollectionByArtist(Artist ar) {return null;}
	public Response createCollectionByTechnique(TypesAndTechniques.Technique tech) {return null;}
	public Response createCollectionByTag(String tag) {return null;}
	
	/* ---------------- UPDATE -----------------------*/
	public Response updateCollection(ArtCollection at) {return null;}
	
	/* ---------------- DELETE -----------------------*/
	public Response deleteCollection(ArtCollection ac) {return null;}
	
}
