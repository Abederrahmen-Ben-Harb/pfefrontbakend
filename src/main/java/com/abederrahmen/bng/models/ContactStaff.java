package com.abederrahmen.bng.models;



import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "contactStaff")
public class ContactStaff {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Column(name = "emetteur")
	private String emetteur;
	
	
	
	@Column(name = "recepteur")
	private String recepteur;
	
	
	@Column(name = "message")
	private String message;
	
	
	


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getEmetteur() {
		return emetteur;
	}


	public void setEmetteur(String emetteur) {
		this.emetteur = emetteur;
	}


	public String getRecepteur() {
		return recepteur;
	}


	public void setRecepteur(String recepteur) {
		this.recepteur = recepteur;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public ContactStaff(long id, String emetteur, String recepteur, String message) {
		super();
		this.id = id;
		this.emetteur = emetteur;
		this.recepteur = recepteur;
		this.message = message;
	}
	
	
	public ContactStaff () {
		
	}
	
	
	
}
