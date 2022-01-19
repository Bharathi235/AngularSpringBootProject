package com.main.hospital.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.hospital.model.Patients;
import com.main.hospital.repository.PatientsRepository;

import com.main.hospital.exception.ResourceNotFoundException;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class PatientsController {

	@Autowired
	private PatientsRepository patientsRepository;
	
	// get all employees
	@GetMapping("/PatientsList")
	public List<Patients> getAllPatients(){
		return patientsRepository.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/PatientsList")
	public Patients createPatients(@RequestBody Patients patients) {
		return patientsRepository.save(patients);
	}
	
	// get employee by id rest api
	@GetMapping("/PatientsList/{id}")
	public ResponseEntity<Patients> getPatientsById(@PathVariable Long id) {
		Patients patients = patientsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patients not exist with id :" + id));
		return ResponseEntity.ok(patients);
	}
	
	// update employee rest api
	
	@PutMapping("/PatientsList/{id}")
	public ResponseEntity<Patients> updateEmployee(@PathVariable Long id, @RequestBody Patients PatientsDetails){
		Patients patients = patientsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patients not exist with id :" + id));
		
		patients.setName(PatientsDetails.getName());
		patients.setDoctor(PatientsDetails.getDoctor());
		patients.setId(PatientsDetails.getId());
		patients.setDisease(PatientsDetails.getDisease());
		patients.setDateOfVisit(PatientsDetails.getDateOfVisit());

		Patients updatedPatients = patientsRepository.save(patients);
		return ResponseEntity.ok(updatedPatients);
	}
	
	// delete employee rest api
	@DeleteMapping("/PatientsList/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Patients patients = patientsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patients not exist with id :" + id));
		
		patientsRepository.delete(patients);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}