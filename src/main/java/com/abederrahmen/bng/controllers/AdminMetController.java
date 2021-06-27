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
import com.abederrahmen.bng.models.AdminMet;
import com.abederrahmen.bng.repository.AdminMetRepository;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/adminMet")
public class AdminMetController {
	
		@Autowired
		private AdminMetRepository adminMetRepository;
	 
	 	// get all adminMetier
		@GetMapping("/adminMet")
		public List<AdminMet> getAllAdminMet(){
			return adminMetRepository.findAll();
		}		
		
		// create adminMetier rest api
		@PostMapping("/adminMet")
		public AdminMet createAdminMet(@RequestBody AdminMet adminMet) {
			return adminMetRepository.save(adminMet);
		}
		
		// get adminMetier by id rest api
		@GetMapping("/adminMet/{id}")
		public ResponseEntity<AdminMet> getAdminMetById(@PathVariable Long id) {
			AdminMet adminMet = adminMetRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("AdminMet not exist with id :" + id));
			return ResponseEntity.ok(adminMet);
		}
		
		// update adminMetier rest api
		@PutMapping("/adminMet/{id}")
		public ResponseEntity<AdminMet> updateAdminMet(@PathVariable Long id, @RequestBody AdminMet adminMetDetails){
			AdminMet adminMet = adminMetRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("AdminMet not exist with id :" + id));
			
			adminMet.setUsername(adminMetDetails.getUsername());
			adminMet.setMatricule(adminMetDetails.getMatricule());
			adminMet.setEmail(adminMetDetails.getEmail());
			adminMet.setPassword(adminMetDetails.getPassword());
			adminMet.setRoles(adminMetDetails.getRoles());
			
			AdminMet updatedAdminMet = adminMetRepository.save(adminMet);
			return ResponseEntity.ok(updatedAdminMet);
		}
		
		// delete adminMetier rest api
		@DeleteMapping("/adminMet/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteAdmin(@PathVariable Long id){
			AdminMet adminMet = adminMetRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("AdminMet not exist with id :" + id));
			
			adminMetRepository.delete(adminMet);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
}
