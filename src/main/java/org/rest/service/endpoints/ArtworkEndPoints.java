package org.rest.service.endpoints;

import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.rest.service.entities.Artist;
import org.rest.service.entities.Artwork;
import org.rest.service.entities.TypesAndTechniques;

@Path("/museum/artwork")
public class ArtworkEndPoints {
	//etablir l'interface
	
	
	/* ---------------- CREATE -----------------------*/
	public Response addArtwork(Artwork aw){return null;}
	
	/* ---------------- UPDATE -----------------------*/
	public Response updateArtwork(Artwork aw){return null;}
	
	/* ---------------- GET -----------------------*/
	public List<Artwork> getArtworksByArtist(Artist ar){return null;}
	public List<Artwork> getArtworksByTechnique(TypesAndTechniques.Technique tech){return null;}
	public List<Artwork> getArtworksBySupport(TypesAndTechniques.Technique support){return null;}
}