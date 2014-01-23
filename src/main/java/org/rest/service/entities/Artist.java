package org.rest.service.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;

import java.util.Date;

@Entity
@XmlRootElement
public class Artist implements MuseumEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String city;
	private String nationality;
	private String photo;
	private String description;
	@Enumerated(EnumType.STRING)
	private TypesAndTechniques.ArtWorkType workType;
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	//@OneToMany(mappedBy="artists")
	//private Set<Artwork> artworks;
	
	public static final String UNDEFINED_NAME_STRING = "UNNAMED";
	
	public Artist(){
		name = UNDEFINED_NAME_STRING;
		//artworks = new HashSet<Artwork>();
	}
	
	public Artist(String nameParam){
		this();
		name = nameParam;
	}
	
	public Artist(String nameParam, Set<Artwork> artworksSet){
		this(nameParam);
		//artworks = artworksSet;
	}

//	public void addArtwork(Artwork aw) {
//		//artworks.add(aw);
//	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

//	@XmlElementWrapper
//	public Set<Artwork> getArtworks() {
//		return artworks;
//	}
//
//	public void setArtworks(Set<Artwork> artworks) {
//		this.artworks = artworks;
//	}
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public TypesAndTechniques.ArtWorkType getType() {
		return workType;
	}

	public void setType(TypesAndTechniques.ArtWorkType workType) {
		this.workType = workType;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
