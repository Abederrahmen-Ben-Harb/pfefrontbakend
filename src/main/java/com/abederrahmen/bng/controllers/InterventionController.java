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

import com.abederrahmen.bng.models.Intervention;
import com.abederrahmen.bng.repository.InterventionRepository;

import com.abederrahmen.bng.exception.ResourceNotFoundException;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/interventions")
public class InterventionController {
	
	
	@Autowired
	private InterventionRepository interventionRepository;
	
	// get all interventions
	@GetMapping("/interventions")
	public List<Intervention> getAllIntervention(){
		return interventionRepository.findAll();
	}
	
	// create intervention rest api
	@PostMapping("/interventions")
	public Intervention createIntervention(@RequestBody Intervention intervention) {
		return interventionRepository.save(intervention);
		}
	
	// get intervention by id rest api
	@GetMapping("/interventions/{id}")
	public ResponseEntity<Intervention> getInterventionById(@PathVariable Long id) {
		Intervention intervention = interventionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Intervention not exist with id :" + id));
		return ResponseEntity.ok(intervention);
	}
	
	
	// update intervention rest api
	@PutMapping("/interventions/{id}")
	public ResponseEntity<Intervention> updateIntervention(@PathVariable Long id, @RequestBody Intervention interventionDetails){
		Intervention intervention = interventionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Intervention not exist with id :" + id));
		
		intervention.setDescription(interventionDetails.getDescription());
		intervention.setUser(interventionDetails.getUser());
		
		Intervention updateIntervention = interventionRepository.save(intervention);
		return ResponseEntity.ok(updateIntervention);
	}
	
	// delete intervention rest api
		@DeleteMapping("/interventions/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteInterventionr(@PathVariable Long id){
			Intervention intervention = interventionRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Intervention not exist with id :" + id));
			
			interventionRepository.delete(intervention);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
}
