package com.abederrahmen.bng.models;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "visite")
public class Visite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "date")
	private Date date;

	@Column(name = "description")
	private String description ;
	
	
	@Column(name = "etat")
	private Boolean etat ;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public Boolean getEtat() {
		return etat;
	}
	
	
	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

	public Visite(long id, Date date, String description, Boolean etat) {
		super();
		this.id = id;
		this.date = date;
		this.description = description;
		this.etat = etat;
	}

	public Visite() {
		
	}
}
