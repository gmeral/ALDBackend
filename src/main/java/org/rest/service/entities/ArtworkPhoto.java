package org.rest.service.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class ArtworkPhoto implements MuseumEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.DATE)
	private Date shotDate;
	private String shotLocation;
	private String imageFilePath; 
	
	public static final String UNDEFINED_STRING = "Undefined";
	
	public ArtworkPhoto(){
		shotDate = new Date();
		shotLocation = UNDEFINED_STRING;
		imageFilePath = UNDEFINED_STRING;
	}

	public Date getShotDate() {
		return shotDate;
	}

	public void setShotDate(Date shotDate) {
		this.shotDate = shotDate;
	}

	public String getShotLocation() {
		return shotLocation;
	}

	public void setShotLocation(String shotLocation) {
		this.shotLocation = shotLocation;
	}

	public String getImageFilePath() {
		return imageFilePath;
	}

	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}
}
