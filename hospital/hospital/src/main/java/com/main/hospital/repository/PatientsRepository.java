package com.main.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.hospital.model.Patients;
         
@Repository
public interface PatientsRepository extends JpaRepository<Patients, Long>{

}
