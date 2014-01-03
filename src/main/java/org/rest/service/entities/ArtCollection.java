package org.rest.service.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class ArtCollection {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="COLLECTION_ID")
	private Set<Artwork> artworks;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ARTWORK_ID")
	private List<Comment> comments;
	@ElementCollection
	private Set<String> tags;
	
	public ArtCollection(){
		artworks = new HashSet<Artwork>();
		comments = new ArrayList<Comment>();
		tags = new HashSet<String>();
	}
	
	public ArtCollection(Set<Artwork> artworkSet, List<Comment> commentList,  Set<String> tagSet) {
		this();
		artworks.addAll(artworkSet);
		comments.addAll(commentList);
		tags.addAll(tagSet);
	}
	
}
