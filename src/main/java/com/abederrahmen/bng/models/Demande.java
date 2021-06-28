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
	private String cin;
	
	@Column(name = "localisation")
	private String localisation;
	
	@Column(name = "tel")
	private String numTel;
	

	@Column(name = "city")
	private String city ;
	

	 @Column(name = "quantite")
	 private Double quantite;
	 
	 
	@Column(name = "dateRetour")
	private Date dateRetour;
	
	
	@Column(name = "etat")
	private String etat;
	
	
	
	@Column(name = "plante_id")
	private Long plante_id;
	
	
	@Column(name = "user_id")
	private Long user_id;
	
	
	


	public Long getUser() {
		return user_id;
	}


	public void setUser(Long user_id) {
		this.user_id = user_id;
	}


	public Long getPlante() {
		return plante_id;
	}


	public void setPlante(Long plante_id) {
		this.plante_id = plante_id;
	}


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


	public Double getQuantite() {
		return quantite;
	}


	public void setQuantite(Double quantite) {
		this.quantite = quantite;
	}


	public Date getDateRetour() {
		return dateRetour;
	}


	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}


	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	
	


	public Demande(long id, String nom, @Size(max = 8) @NotBlank String cin, String localisation, String numTel,
			String city, @NotBlank @Size(max = 15) Double quantite, Date dateRetour, String etat,Long plante_id, Long user_id) {
		super();
		this.id = id;
		this.nom = nom;
		this.cin = cin;
		this.localisation = localisation;
		this.numTel = numTel;
		this.city = city;
		this.quantite = quantite;
		this.dateRetour = dateRetour;
		this.etat = etat;
		this.plante_id = plante_id;
		this.user_id = user_id;
	}


	public Demande() {
		
	}
	
}
