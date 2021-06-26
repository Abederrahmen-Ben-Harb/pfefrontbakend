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
import com.abederrahmen.bng.models.Type;
import com.abederrahmen.bng.repository.TypeRepository;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/types")
public class TypeController {
	
	
	@Autowired
	private TypeRepository typeRepository;
	
	// get all types
	@GetMapping("/types")
	public List<Type> getAllITypes(){
		return typeRepository.findAll();
	}
	
	// create type rest api
	@PostMapping("/types")
	public Type createType(@RequestBody Type type) {
		return typeRepository.save(type);
		}
	
	// get type by id rest api
	@GetMapping("/types/{id}")
	public ResponseEntity<Type> getTypeById(@PathVariable Long id) {
		Type type = typeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Type not exist with id :" + id));
		return ResponseEntity.ok(type);
	}
	
	
	// update type rest api
	@PutMapping("/types/{id}")
	public ResponseEntity<Type> updateType(@PathVariable Long id, @RequestBody Type typeDetails){
		Type type = typeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Type not exist with id :" + id));
		
		type.setName(typeDetails.getName());
		
		Type updateType = typeRepository.save(type);
		return ResponseEntity.ok(updateType);
	}
	
	// delete type rest api
		@DeleteMapping("/types/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteType(@PathVariable Long id){
			Type type = typeRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Type not exist with id :" + id));
			
			typeRepository.delete(type);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}

}
