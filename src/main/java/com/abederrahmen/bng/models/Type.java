package com.abederrahmen.bng.models;

import javax.persistence.*;

@Entity
@Table(name = "types")
public class Type {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private EType name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public EType getName() {
		return name;
	}

	public void setName(EType name) {
		this.name = name;
	}
	
	
	
	
	
}
