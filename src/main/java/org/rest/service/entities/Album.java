package org.rest.service.entities;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Access(AccessType.FIELD)
@XmlRootElement(name = "Album")
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int albumId;
	@Column(name="TITLE")
	private String title;
	@Temporal(TemporalType.DATE)
	private Date rdate;
	@Column(name="GENRE")
	private String genre;



	public Album(String title, Date rdate, String genre) {
		this.title = title;
		this.rdate = rdate;
		this.genre = genre;
	}

	public Album() {
		this.title = "default";
		this.rdate = new Date();
		this.genre = "default";
	}


	@XmlElement
	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	@XmlElement
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@XmlElement
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement(name = "date",type=Date.class)
	public Date getDate() {
		return rdate;
	}

	public void setDate(Date rdate) {
		this.rdate = rdate;
	}
}
