package com.abederrahmen.bng.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private String description;
	
	
	@Column(name = "image")
	private String image;
	
	
	@Column(name = "type_id")
	private Long type_id;


	
	public long getId() {
		return id;
	}


	public String getDescription() {
		return description;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public void setDescription(String description) {
		this.description = description;
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
	
	

	public Long getType() {
		return type_id;
	}


	public void setType(Long type_id) {
		this.type_id = type_id;
	}


	public Plante(long id, String nomPlante, String description, String image, Long type_id) {
		super();
		this.id = id;
		this.nomPlante = nomPlante;
		this.description = description;
		this.image = image;
		this.type_id = type_id;
	}


	public Plante() {
		
	}
}
