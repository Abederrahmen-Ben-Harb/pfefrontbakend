package com.abederrahmen.bng.models;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "demandes")
public class Demande {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String nom;
	
	@Column(name = "cin")
	@Size(max =8)
	@NotBlank
	private String cin;
	
	@Column(name = "localisation")
	private String localisation;
	
	@Column(name = "tel")
	private String numTel;
	

	@Column(name = "city")
	private String city ;
	
	 @NotBlank
	 @Size(max = 15)
	 @Column(name = "quantite")
	 private Double quatite;
	 
	 
	@Column(name = "dateRetour")
	private Date dateRetour;
	
	
	@Column(name = "etat")
	private Boolean etat;
	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public String getLocalisation() {
		return localisation;
	}


	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}


	public String getNumTel() {
		return numTel;
	}


	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public Double getQuatite() {
		return quatite;
	}


	public void setQuatite(Double quatite) {
		this.quatite = quatite;
	}


	public Date getDateRetour() {
		return dateRetour;
	}


	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}


	public Boolean getEtat() {
		return etat;
	}


	public void setEtat(Boolean etat) {
		this.etat = etat;
	}
	
	
	public Demande(long id, String nom, @Size(max = 8) @NotBlank String cin, String localisation, String numTel,
			String city, @NotBlank @Size(max = 15) Double quatite, Date dateRetour, Boolean etat) {
		super();
		this.id = id;
		this.nom = nom;
		this.cin = cin;
		this.localisation = localisation;
		this.numTel = numTel;
		this.city = city;
		this.quatite = quatite;
		this.dateRetour = dateRetour;
		this.etat = etat;
	}


	public Demande() {
		
	}
	
}
