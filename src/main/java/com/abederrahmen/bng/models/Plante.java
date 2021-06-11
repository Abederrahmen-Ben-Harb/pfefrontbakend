package com.abederrahmen.bng.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "plantes")
public class Plante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String nomPlante;

	@Column(name = "description")
	private String description ;
	

	@Column(name = "type")
	private Long type;


	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNomPlante() {
		return nomPlante;
	}


	public void setNomPlante(String nomPlante) {
		this.nomPlante = nomPlante;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Long getType() {
		return type;
	}


	public void setType(Long type) {
		this.type = type;
	}


	public Plante(long id, String nomPlante, String description, Long type) {
		super();
		this.id = id;
		this.nomPlante = nomPlante;
		this.description = description;
		this.type = type;
	}


	public Plante() {
		
	}
}
