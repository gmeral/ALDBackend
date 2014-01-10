package org.rest.service.endpoints;

import java.util.List;

import javax.ws.rs.Path;

import org.rest.service.entities.Artist;

@Path("museum/artist")
public class ArtistEndPoints {
	public List<Artist> getRepresentedArtists() {return null;}
}
