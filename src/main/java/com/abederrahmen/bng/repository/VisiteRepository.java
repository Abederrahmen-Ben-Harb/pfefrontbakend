package com.abederrahmen.bng.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abederrahmen.bng.models.Visite;


@Repository
public interface VisiteRepository extends JpaRepository<Visite, Long>{
	
	  List<Visite> findByEtat(String etat);
	  List<Visite> findByDateContaining(Date date);

}