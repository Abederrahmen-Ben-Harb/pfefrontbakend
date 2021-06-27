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
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name="USERE_ID", referencedColumnName="ID")
    })
	private User user;
	
	
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


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public ContactUser(long id, @NotBlank String emetteur, @NotBlank User user, String message) {
		super();
		this.id = id;
		this.emetteur = emetteur;
		this.user = user;
		this.message = message;
	}
	
	public ContactUser() {
		
	}
	
	
}
