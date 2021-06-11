package com.abederrahmen.bng.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abederrahmen.bng.models.Chercheur;


public interface ChercheurRepository extends JpaRepository<Chercheur, Long>{
	
	Optional<Chercheur> findByEmail(String email);
    
    List<Chercheur> findUserByUsername(String username);

    List<Chercheur> findByIdIn(List<Long> userIds);
    
    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
