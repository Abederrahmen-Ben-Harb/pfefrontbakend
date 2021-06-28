package com.abederrahmen.bng.models;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "contactUser")
public class ContactUser {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Column(name = "emetteur")
	private String emetteur;
	
	
	@Column(name="user_id")
	private Long user_id;
	
	
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


	public Long getUser() {
		return user_id;
	}


	public void setUser(Long user_id) {
		this.user_id = user_id;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public ContactUser(long id, @NotBlank String emetteur, @NotBlank Long user_id, String message) {
		super();
		this.id = id;
		this.emetteur = emetteur;
		this.user_id = user_id;
		this.message = message;
	}
	
	public ContactUser() {
		
	}
	
	
}
