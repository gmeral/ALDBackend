package org.rest.service.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Artist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToMany()
	private Set<Artwork> artworks;
	
	public static final String UNDEFINED_NAME_STRING = "UNNAMED";
	
	public Artist(){
		name = UNDEFINED_NAME_STRING;
		artworks = new HashSet<Artwork>();
	}
	
	public Artist(String nameParam){
		this();
		name = nameParam;
	}
	
	public Artist(String nameParam, Set<Artwork> artworksSet){
		this(nameParam);
		artworks = artworksSet;
	}

	public void addArtwork(Artwork aw) {
		artworks.add(aw);
	}
	
	
}
