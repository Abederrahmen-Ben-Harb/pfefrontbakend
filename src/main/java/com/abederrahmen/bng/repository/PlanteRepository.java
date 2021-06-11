package com.abederrahmen.bng.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abederrahmen.bng.models.Plante;


@Repository
public interface PlanteRepository extends JpaRepository<Plante, Long>{

}