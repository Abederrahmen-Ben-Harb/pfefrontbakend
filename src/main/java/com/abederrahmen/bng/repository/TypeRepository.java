package com.abederrahmen.bng.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.abederrahmen.bng.models.EType;
import com.abederrahmen.bng.models.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long>{
	Optional<Type> findByName(EType name);
}
