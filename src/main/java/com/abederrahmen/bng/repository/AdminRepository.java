package com.abederrahmen.bng.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abederrahmen.bng.models.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{
	
	Optional<Admin> findByEmail(String email);
    
    List<Admin> findUserByUsername(String username);

    List<Admin> findByIdIn(List<Long> userIds);
    
    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
