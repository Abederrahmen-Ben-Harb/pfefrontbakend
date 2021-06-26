package com.abederrahmen.bng.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abederrahmen.bng.exception.ResourceNotFoundException;
import com.abederrahmen.bng.models.ContactUser;
import com.abederrahmen.bng.repository.ContactUserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/contactUser")
public class ContactUserController {
	
	
	@Autowired
 	ContactUserRepository contactUserRepository;
 
 	// get all contactUser
	@GetMapping("/contactUser")
	public List<ContactUser> getAllContactStaff(){
		return contactUserRepository.findAll();
	}		
	
	// create contactUser rest api
	@PostMapping("/contactUser")
	public ContactUser createContactUserRepository(@RequestBody ContactUser contactUser) {
		return contactUserRepository.save(contactUser);
	}
	
	// get contactUser by id rest api
	@GetMapping("/contactUser/{id}")
	public ResponseEntity<ContactUser> getContactUserById(@PathVariable Long id) {
		ContactUser contactUser = contactUserRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ContactUser not exist with id :" + id));
		return ResponseEntity.ok(contactUser);
	}
	
	// update contactUser rest api
	@PutMapping("/contactUser/{id}")
	public ResponseEntity<ContactUser> updateContactUser(@PathVariable Long id, @RequestBody ContactUser contactUserDetails){
		ContactUser contactUser = contactUserRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ContactUser not exist with id :" + id));
		
		contactUser.setEmetteur(contactUserDetails.getEmetteur());
		contactUser.setUser(contactUserDetails.getUser());
		contactUser.setMessage(contactUserDetails.getMessage());
		
		ContactUser updatedContactUser = contactUserRepository.save(contactUser);
		return ResponseEntity.ok(updatedContactUser);
	}
	
	// delete contactUser rest api
	@DeleteMapping("/contactStaff/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteContactUser(@PathVariable Long id){
		ContactUser contactUser = contactUserRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ContactUser not exist with id :" + id));
		
		contactUserRepository.delete(contactUser);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
