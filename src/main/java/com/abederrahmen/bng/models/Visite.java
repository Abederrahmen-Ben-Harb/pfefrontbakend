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
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name="USERE_ID", referencedColumnName="ID")
    })
	private User user;
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public Visite(long id, Date date, String description, String etat, User user) {
		super();
		this.id = id;
		this.date = date;
		this.description = description;
		this.etat = etat;
		this.user = user;
	}

	public Visite() {
		
	}
}
