package org.rest.service.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ArtworkPhoto {
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
}
