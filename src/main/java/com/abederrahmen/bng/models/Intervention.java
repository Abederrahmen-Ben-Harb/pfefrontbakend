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
import javax.persistence.Table;



@Entity
@Table(name = "intervention")
public class Intervention {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "description")
	private String description ;
	
	
	@Column(name="user_id")
	private Long user_id;
	
	
	public Long getUser() {
		return user_id;
	}

	public void setUser(long user_id) {
		this.user_id = user_id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Intervention(long id, String description, String image, Long user_id) {
		super();
		this.id = id;
		this.description = description;
		this.user_id = user_id;
	}

	public Intervention() {
		
	}
	
}
