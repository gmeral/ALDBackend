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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Artwork implements MuseumEntity{
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
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinColumn(name="ARTWORK_ID")
	private List<ArtworkPhoto> photos;
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="ARTIST_ARTWORK")
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
	
	public void addComment(Comment c) {
		comments.add(c);
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isExposed() {
		return isExposed;
	}

	public void setExposed(boolean isExposed) {
		this.isExposed = isExposed;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@XmlElementWrapper
	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	public TypesAndTechniques.Technique getTechnique() {
		return technique;
	}

	public void setTechnique(TypesAndTechniques.Technique technique) {
		this.technique = technique;
	}

	public TypesAndTechniques.Support getSupport() {
		return support;
	}

	public void setSupport(TypesAndTechniques.Support support) {
		this.support = support;
	}

	public TypesAndTechniques.ArtWorkType getType() {
		return type;
	}

	public void setType(TypesAndTechniques.ArtWorkType type) {
		this.type = type;
	}

	@XmlElementWrapper
	public List<ArtworkPhoto> getPhotos() {
		return photos;
	}

	public void setPhotos(List<ArtworkPhoto> photos) {
		this.photos = photos;
	}

	@XmlElementWrapper
	public Set<Artist> getArtists() {
		return artists;
	}

	public void setArtists(Set<Artist> artists) {
		this.artists = artists;
	}

	@XmlElementWrapper
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
}
