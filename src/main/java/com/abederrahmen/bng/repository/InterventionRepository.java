package com.abederrahmen.bng.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abederrahmen.bng.models.Intervention;

@Repository
public interface InterventionRepository extends JpaRepository<Intervention, Long>{

}
