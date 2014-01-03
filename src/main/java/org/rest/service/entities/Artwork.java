package org.rest.service.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Artwork {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description;
	private boolean isExposed;
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	@ElementCollection
	private Set<String> tags;
	@Embedded
	private Dimensions dimensions;
	@Enumerated(EnumType.STRING)
	private TypesAndTechniques.Technique technique;
	@Enumerated(EnumType.STRING)
	private TypesAndTechniques.Support support;
	@Enumerated(EnumType.STRING)
	private TypesAndTechniques.ArtWorkType type;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ARTWORK_ID")
	private List<ArtworkPhoto> photos;
	@ManyToMany(mappedBy="artworks")
	private Set<Artist> artists;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ARTWORK_ID")
	private List<Comment> comments;


	
	public Artwork() {
		dimensions = new Dimensions();
		description = "undescribed";
		artists = new HashSet<Artist>();
	}
	
	public Artwork(Dimensions dim) {
		artists = new HashSet<Artist>();
		dimensions = dim;
	}
	public Artwork(Dimensions dim, String titleParam) {
		this(dim);
		title = titleParam;
	}
	
	public Artwork(Dimensions dim, TypesAndTechniques.Technique tech, TypesAndTechniques.ArtWorkType awType, TypesAndTechniques.Support supp) {
		this(dim);
		technique = tech;
		support = supp;
		type = awType;
	}
	
	public Artwork(Dimensions dim, TypesAndTechniques.Technique tech, TypesAndTechniques.ArtWorkType awType, TypesAndTechniques.Support supp, String desc) {
		this(dim);
		technique = tech;
		support = supp;
		type = awType;
		description = desc;
	}
	
	public Artwork(Dimensions dim, TypesAndTechniques.Technique tech, TypesAndTechniques.ArtWorkType awType, TypesAndTechniques.Support supp, String desc, String titleParam) {
		this(dim,tech,awType,supp, desc);
		title = titleParam;
	}
	
	public Artwork(Dimensions dim, TypesAndTechniques.Technique tech, TypesAndTechniques.ArtWorkType awType, TypesAndTechniques.Support supp, String desc, String titleParam, Set<String> initTags) {
		this(dim,tech,awType,supp, desc, titleParam);
		tags = initTags;
	}
	
	public Artwork(Dimensions dim, TypesAndTechniques.Technique tech, TypesAndTechniques.ArtWorkType awType, TypesAndTechniques.Support supp, String desc, String titleParam, Set<String> initTags, Date date) {
		this(dim,tech,awType,supp, desc, titleParam, initTags);
		creationDate = date;
	}
	
	public Artwork(Dimensions dim, TypesAndTechniques.Technique tech, TypesAndTechniques.ArtWorkType awType, TypesAndTechniques.Support supp, String desc, String titleParam, Set<String> initTags, Date date, List<Comment> comList) {
		this(dim,tech,awType,supp, desc, titleParam, initTags, date);
		comments = comList;
	}
	
	public void addArtist(Artist a) {
		artists.add(a);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Dimensions getDimensions() {
		return dimensions;
	}

	public void setDimensions(Dimensions dimensions) {
		this.dimensions = dimensions;
	}
	
	
}
