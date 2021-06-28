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
import com.abederrahmen.bng.models.Staff;
import com.abederrahmen.bng.repository.StaffRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/staffs")
public class StaffController {
	
		@Autowired
	 	StaffRepository staffRepository;
	 
	 	// get all staffs
		@GetMapping("/staffs")
		public List<Staff> getAllStaff(){
			return staffRepository.findAll();
		}		
		
		// create staff rest api
		@PostMapping("/staffs")
		public Staff createStaff(@RequestBody Staff staff) {
			return staffRepository.save(staff);
		}
		
		// get staff by id rest api
		@GetMapping("/staffs/{id}")
		public ResponseEntity<Staff> getStaffById(@PathVariable Long id) {
			Staff staff = staffRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Staff not exist with id :" + id));
			return ResponseEntity.ok(staff);
		}
		
		// update staff rest api
		@PutMapping("/staffs/{id}")
		public ResponseEntity<Staff> updateStaff(@PathVariable Long id, @RequestBody Staff staffDetails){
			Staff staff = staffRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Staff not exist with id :" + id));
			
			staff.setUsername(staffDetails.getUsername());
			staff.setMatricule(staffDetails.getMatricule());
			staff.setEmail(staffDetails.getEmail());
			staff.setPassword(staffDetails.getPassword());
			staff.setRole(staffDetails.getRole());
			staff.setRoles(staffDetails.getRoles());
			
			Staff updatedStaff = staffRepository.save(staff);
			return ResponseEntity.ok(updatedStaff);
		}
		
		// delete staff rest api
		@DeleteMapping("/staffs/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteStaff(@PathVariable Long id){
			Staff staff = staffRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Staff not exist with id :" + id));
			
			staffRepository.delete(staff);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}

}
