package org.rest.service.endpoints;

import java.util.List;

import javax.ws.rs.Path;

import org.rest.service.entities.Artist;
import org.rest.service.entities.Artwork;
import org.rest.service.entities.ArtworkPhoto;

@Path("museum/photo")
public class PhotoEndPoints {
	public List<ArtworkPhoto> getPhotosByArtist(Artist ar) {return null;}
	public List<ArtworkPhoto> getPhotosByTag(Artwork ar, List<String> tags) {return null;}
}
