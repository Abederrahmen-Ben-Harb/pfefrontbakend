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

import com.abederrahmen.bng.models.Demande;
import com.abederrahmen.bng.repository.DemandeRepository;

import com.abederrahmen.bng.exception.ResourceNotFoundException;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/demandes")
public class DemandeController {
	
	
	@Autowired
	private DemandeRepository demandeRepository;
	
	// get all demandes
	@GetMapping("/demandes")
	public List<Demande> getAllDemande(){
		return demandeRepository.findAll();
	}
	
	
	// create demande rest api
	@PostMapping("/demandes")
	public Demande createDemande(@RequestBody Demande demande) {
		return demandeRepository.save(demande);
	}
	
	
	// create demande by id rest api
	@PostMapping("/demandes/{id}")
	public Demande createDemandeByID(@RequestBody Demande demande, Long id) {
		return demandeRepository.save(demande);
	}
	
	// get demande by id rest api
	@GetMapping("/demandes/{id}")
	public ResponseEntity<Demande> getDemandeById(@PathVariable Long id) {
		Demande demande = demandeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Demande not exist with id :" + id));
		return ResponseEntity.ok(demande);
	}
	
	
	// update demande rest api
	@PutMapping("/demandes/{id}")
	public ResponseEntity<Demande> updateDemande(@PathVariable Long id, @RequestBody Demande demandeDetails){
		Demande demande = demandeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Demande not exist with id :" + id));
		
		demande.setNom(demandeDetails.getNom());
		demande.setQuantite(demandeDetails.getQuantite());
		demande.setEtat(demandeDetails.getEtat());
		demande.setCin(demandeDetails.getCin());
		demande.setLocalisation(demandeDetails.getLocalisation());
		demande.setNumTel(demandeDetails.getNumTel());
		demande.setCity(demandeDetails.getCity());
		demande.setDateRetour(demandeDetails.getDateRetour());
		demande.setUser(demandeDetails.getUser());
		demande.setPlante(demandeDetails.getPlante());
		
		Demande updatedDemande = demandeRepository.save(demande);
		return ResponseEntity.ok(updatedDemande);
	}
	
	
	// delete demande rest api
	@DeleteMapping("/demandes/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDemande(@PathVariable Long id){
		Demande demande = demandeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Demande not exist with id :" + id));
		
		demandeRepository.delete(demande);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}