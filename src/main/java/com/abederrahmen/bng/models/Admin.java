package com.abederrahmen.bng.models;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;




@Entity
@Table(name = "admin", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})

public class Admin{
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank
	    @Size(min = 3 ,max = 40)
	    private String username;
	    
	    @NotBlank
	    @Size(max = 15)
	    private String matricule;
	    
	    @NaturalId
	    @NotBlank
	    @Size(max = 40)
	    @Email
	    private String email;

	    @NotBlank
	    @Size(max = 100)
	    private String password;

	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(name = "user_roles",
	            joinColumns = @JoinColumn(name = "user_id"),
	            inverseJoinColumns = @JoinColumn(name = "role_id"))
	    private Set<Role> roles = new HashSet<>();
	    
	    
	    
	    public Admin() {
	    	
	    }

		public Admin(String username, String matricule, String email, String password) {
			this.username = username;
			this.matricule = matricule;
			this.email = email;
			this.password = password;	
		}



		public Long getId() {
			return id;
		}



		public void setId(Long id) {
			this.id = id;
		}



		public String getUsername() {
			return username;
		}



		public void setUsername(String username) {
			this.username = username;
		}
		


		public String getMatricule() {
			return matricule;
		}



		public void setMatricule(String matricule) {
			this.matricule = matricule;
		}



		public String getEmail() {
			return email;
		}



		public void setEmail(String email) {
			this.email = email;
		}



		public String getPassword() {
			return password;
		}



		public void setPassword(String password) {
			this.password = password;
		}



		public Set<Role> getRoles() {
			return roles;
		}



		public void setRoles(Set<Role> roles) {
			this.roles = roles;
		}
	    
	    
	    
}
