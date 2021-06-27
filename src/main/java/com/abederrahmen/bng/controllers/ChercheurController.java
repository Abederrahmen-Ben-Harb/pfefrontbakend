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
import com.abederrahmen.bng.models.Chercheur;
import com.abederrahmen.bng.repository.ChercheurRepository;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/chercheurs")
public class ChercheurController {
	
			@Autowired
			private ChercheurRepository chercheurRepository;
	
			// get all chercheurs
			@GetMapping("/chercheurs")
			public List<Chercheur> getAllAdmin(){
				return chercheurRepository.findAll();
			}		
			
			// create chercheur rest api
			@PostMapping("/chercheurs")
			public Chercheur createChercheur(@RequestBody Chercheur chercheur) {
				return chercheurRepository.save(chercheur);
			}
			
			// get chercheur by id rest api
			@GetMapping("/chercheurs/{id}")
			public ResponseEntity<Chercheur> getChercheurById(@PathVariable Long id) {
				Chercheur chercheur = chercheurRepository.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("Chercheur not exist with id :" + id));
				return ResponseEntity.ok(chercheur);
			}
			
			// update chercheur rest api
			@PutMapping("/chercheurs/{id}")
			public ResponseEntity<Chercheur> updateChercheur(@PathVariable Long id, @RequestBody Chercheur chercheurDetails){
				Chercheur chercheur = chercheurRepository.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("Chercheur not exist with id :" + id));
				
				chercheur.setUsername(chercheurDetails.getUsername());
				chercheur.setMatricule(chercheurDetails.getMatricule());
				chercheur.setEmail(chercheurDetails.getEmail());
				chercheur.setPassword(chercheurDetails.getPassword());
				chercheur.setRoles(chercheurDetails.getRoles());
				
				Chercheur updatedChercheur = chercheurRepository.save(chercheur);
				return ResponseEntity.ok(updatedChercheur);
			}
			
			// delete chercheur rest api
			@DeleteMapping("/chercheurs/{id}")
			public ResponseEntity<Map<String, Boolean>> deleteChercheur(@PathVariable Long id){
				Chercheur chercheur = chercheurRepository.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("Chercheur not exist with id :" + id));
				
				chercheurRepository.delete(chercheur);
				Map<String, Boolean> response = new HashMap<>();
				response.put("deleted", Boolean.TRUE);
				return ResponseEntity.ok(response);
			}
}
