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

import com.abederrahmen.bng.models.ERole;
import com.abederrahmen.bng.models.Role;
import com.abederrahmen.bng.repository.RoleRepository;

import com.abederrahmen.bng.exception.ResourceNotFoundException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/roles")
public class RoleController {
	
	@Autowired
	private RoleRepository roleRepository;
	
	// get all roles
	@GetMapping("/roles")
	public List<Role> getAllRoles(){
		return roleRepository.findAll();
	}
	
	
	// create role rest api
	@PostMapping("/roles")
	public Role createRole(@RequestBody Role role) {
		return roleRepository.save(role);
	}
	
	
	// get role by id rest api
	@GetMapping("/roles/{id}")
	public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
		Role role = roleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Role not exist with id :" + id));
		return ResponseEntity.ok(role);
	}
	
	// get role by name rest api
	@GetMapping("/roles/{name}")
	public ResponseEntity<Role> getRoleByName(@PathVariable ERole name) {
		Role role = roleRepository.findByName(name)
				.orElseThrow(() -> new ResourceNotFoundException("Role not exist with name :" + name));
		return ResponseEntity.ok(role);
	}
	
	
	// update role rest api
	@PutMapping("/roles/{id}")
	public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role roleDetails){
		Role role = roleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Role not exist with id :" + id));
		
		role.setName(roleDetails.getName());
		
		Role updatedRole = roleRepository.save(role);
		return ResponseEntity.ok(updatedRole);
	}
	
	
	// delete role rest api
	@DeleteMapping("/roles/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteRole(@PathVariable Long id){
		Role role = roleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Role not exist with id :" + id));
		
		roleRepository.delete(role);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
