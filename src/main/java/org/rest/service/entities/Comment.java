package org.rest.service.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String author;
	@Temporal(TemporalType.DATE)
	private Date postDate;
	private String content;
	
	public static final String UNDEFINED_STRING = "Undefined";
	
	
	public Comment(String aut, String contentParam, Date date) {
		author = aut;
		content = contentParam;
		postDate = date;
	}
	public Comment() {
		this(UNDEFINED_STRING, UNDEFINED_STRING, new Date());
	}
}
