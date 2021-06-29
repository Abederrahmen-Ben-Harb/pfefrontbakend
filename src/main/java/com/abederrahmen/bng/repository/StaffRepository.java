package com.abederrahmen.bng.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abederrahmen.bng.models.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long>{
	Optional<Staff> findByEmail(String email);
	
	Optional<Staff> findByUsername(String username);
    
    List<Staff> findUserByUsername(String username);

    List<Staff> findByIdIn(List<Long> userIds);
    
    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

}
