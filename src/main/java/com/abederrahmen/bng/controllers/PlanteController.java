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


import com.abederrahmen.bng.models.Plante;
import com.abederrahmen.bng.repository.PlanteRepository;
import com.abederrahmen.bng.exception.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class PlanteController {
		
		@Autowired
		private PlanteRepository planteRepository;
	
	// get all plantes
		@GetMapping("/plantes")
		public List<Plante> getAllPlantes(){
			return planteRepository.findAll();
		}	
		
		// add plante rest api
		@PostMapping("/plantes")
		public Plante addPlante(@RequestBody Plante plante) {
			return planteRepository.save(plante);
		}
		
		// get plante by id rest api
		@GetMapping("/plantes/{id}")
		public ResponseEntity<Plante> getPlanteById(@PathVariable Long id) {
			Plante plante = planteRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Plante not exist with id :" + id));
			return ResponseEntity.ok(plante);
		}
		
		
		// update plante rest api
		@PutMapping("/plantes/{id}")
		public ResponseEntity<Plante> updatePlante(@PathVariable Long id, @RequestBody Plante planteDetails){
			Plante plante = planteRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Plante not exist with id :" + id));
			
			plante.setNomPlante(planteDetails.getNomPlante());
			plante.setDescription(planteDetails.getDescription());
			plante.setImage(planteDetails.getImage());
			plante.setType(planteDetails.getType());
			
			Plante updatePlante = planteRepository.save(plante);
			return ResponseEntity.ok(updatePlante);
		}
		
		// delete plante rest api
		@DeleteMapping("/plantes/{id}")
		public ResponseEntity<Map<String, Boolean>> deletePlante(@PathVariable Long id){
			Plante plante = planteRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Plante not exist with id :" + id));
			
			planteRepository.delete(plante);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
}
	
