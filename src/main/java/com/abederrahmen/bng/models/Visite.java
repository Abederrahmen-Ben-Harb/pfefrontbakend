package com.abederrahmen.bng.models;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
	private String etat ;
	
	
	@Column(name="user_id")
	private Long user_id;
	

	public Long getUser() {
		return user_id;
	}

	public void setUser(Long user_id) {
		this.user_id = user_id;
	}

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
	
	
	public String getEtat() {
		return etat;
	}
	
	
	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Visite(long id, Date date, String description, String etat, Long user_id) {
		super();
		this.id = id;
		this.date = date;
		this.description = description;
		this.etat = etat;
		this.user_id = user_id;
	}

	public Visite() {
		
	}
}
