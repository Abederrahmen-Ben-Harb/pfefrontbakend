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


import com.abederrahmen.bng.models.Visite;
import com.abederrahmen.bng.repository.VisiteRepository;
import com.abederrahmen.bng.exception.ResourceNotFoundException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/visites")
public class VisiteController {
		
		@Autowired
		private VisiteRepository visiteRepository;
	
		// get all visites
		@GetMapping("/visites")
		public List<Visite> getAllVisites(){
			return visiteRepository.findAll();
		}	
		
		// add visite rest api
		@PostMapping("/visites")
		public Visite addVisite(@RequestBody Visite visite) {
			return visiteRepository.save(visite);
		}
		
		// get visite by id rest api
		@GetMapping("/visites/{id}")
		public ResponseEntity<Visite> getVisiteById(@PathVariable Long id) {
			Visite visite = visiteRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Visite not exist with id :" + id));
			return ResponseEntity.ok(visite);
		}
		
		
		// update visite rest api
		@PutMapping("/visites/{id}")
		public ResponseEntity<Visite> updateVisite(@PathVariable Long id, @RequestBody Visite visiteDetails){
			Visite visite = visiteRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Visite not exist with id :" + id));
			
			visite.setDate(visiteDetails.getDate());
			visite.setDescription(visiteDetails.getDescription());
			visite.setEtat(visiteDetails.getEtat());
			
			Visite updateVisite = visiteRepository.save(visite);
			return ResponseEntity.ok(updateVisite);
		}
		
		// delete visite rest api
		@DeleteMapping("/visites/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteVisite(@PathVariable Long id){
			Visite visite = visiteRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Visite not exist with id :" + id));
			
			visiteRepository.delete(visite);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
}
