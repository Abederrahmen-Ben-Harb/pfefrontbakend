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
import com.abederrahmen.bng.models.ContactStaff;
import com.abederrahmen.bng.repository.ContactStaffRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/contactStaff")
public class ContactStaffController {
	
	
	@Autowired
 	ContactStaffRepository contactStaffRepository;
 
 	// get all contactStaff
	@GetMapping("/contactStaff")
	public List<ContactStaff> getAllContactStaff(){
		return contactStaffRepository.findAll();
	}		
	
	// create contactStaff rest api
	@PostMapping("/contactStaff")
	public ContactStaff createContactStaffRepository(@RequestBody ContactStaff contactStaff) {
		return contactStaffRepository.save(contactStaff);
	}
	
	// get contactStaff by id rest api
	@GetMapping("/contactStaff/{id}")
	public ResponseEntity<ContactStaff> getContactStaffById(@PathVariable Long id) {
		ContactStaff contactStaff = contactStaffRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ContactStaff not exist with id :" + id));
		return ResponseEntity.ok(contactStaff);
	}
	
	// update contactStaff rest api
	@PutMapping("/contactStaff/{id}")
	public ResponseEntity<ContactStaff> updateContactStaff(@PathVariable Long id, @RequestBody ContactStaff contactStaffDetails){
		ContactStaff contactStaff = contactStaffRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ContactStaff not exist with id :" + id));
		
		contactStaff.setEmetteur(contactStaffDetails.getEmetteur());
		contactStaff.setRecepteur(contactStaffDetails.getRecepteur());
		contactStaff.setMessage(contactStaffDetails.getMessage());
		
		ContactStaff updatedContactStaff = contactStaffRepository.save(contactStaff);
		return ResponseEntity.ok(updatedContactStaff);
	}
	
	// delete contactStaff rest api
	@DeleteMapping("/contactStaff/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteContactStaff(@PathVariable Long id){
		ContactStaff contactStaff = contactStaffRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ContactStaff not exist with id :" + id));
		
		contactStaffRepository.delete(contactStaff);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
