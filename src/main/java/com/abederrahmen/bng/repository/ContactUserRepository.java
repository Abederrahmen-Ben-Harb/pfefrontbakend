package com.abederrahmen.bng.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abederrahmen.bng.models.ContactUser;

@Repository
public interface ContactUserRepository extends JpaRepository<ContactUser, Long>{

}
