package com.abederrahmen.bng.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abederrahmen.bng.models.ContactStaff;


@Repository
public interface ContactStaffRepository extends JpaRepository<ContactStaff, Long>{

}
