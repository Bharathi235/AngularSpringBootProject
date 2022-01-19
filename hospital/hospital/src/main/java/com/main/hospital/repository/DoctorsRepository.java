package com.main.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.main.hospital.model.Doctors;
         
@Repository
public interface DoctorsRepository extends JpaRepository<Doctors, Long>{

}
