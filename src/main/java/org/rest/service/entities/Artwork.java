package org.rest.service.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Artwork {
	private int id;
	private TypesAndTechniques.ArtWorkType type;
	private Dimensions dimensions;
	private List<ArtworkPhoto> photos;
	private TypesAndTechniques.Technique technique;
	private TypesAndTechniques.Support support;
	private Set<Artist> artists;
	private String title;
	private Date creationDate;
	private String description;
	private List<Comment> comments;
	private Set<String> tags;
	private boolean isExposed;
}
