package com.abederrahmen.bng.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abederrahmen.bng.models.AdminMet;

public interface AdminMetRepository extends JpaRepository<AdminMet, Long>{
	
	Optional<AdminMet> findByEmail(String email);
    
    List<AdminMet> findUserByUsername(String username);

    List<AdminMet> findByIdIn(List<Long> userIds);
    
    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
