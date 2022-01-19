package com.main.hospital.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.hospital.model.Doctors;
import com.main.hospital.repository.DoctorsRepository;

import com.main.hospital.exception.ResourceNotFoundException;


//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class DoctorsController {

	@Autowired
	private DoctorsRepository DoctorsRepository;
	
	// get all employees
	@GetMapping("/DoctorsList")
	public List<Doctors> getAllDoctors(){
		return DoctorsRepository.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/DoctorsList")
	public Doctors createDoctors(@RequestBody Doctors doctors) {
		return DoctorsRepository.save(doctors);
	}
	
	// get employee by id rest api
	@GetMapping("/DoctorsList/{id}")
	public ResponseEntity<Doctors> getDoctorsById(@PathVariable Long id) {
		Doctors doctors = DoctorsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctors not exist with id :" + id));
		return ResponseEntity.ok(doctors);
	}
	
	// update employee rest api
	
	@PutMapping("/DoctorsListup/{id}")
	public ResponseEntity<Doctors> updateEmployee(@PathVariable Long id, @RequestBody Doctors DoctorsDetails){
		Doctors Doctors = DoctorsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctors not exist with id :" + id));
		
		Doctors.setName(DoctorsDetails.getName());
		Doctors.setAge(DoctorsDetails.getAge());
		Doctors.setId(DoctorsDetails.getId());
		Doctors.setEmailId(DoctorsDetails.getEmailId());
		Doctors.setAvilabletime(DoctorsDetails.getAvilabletime());
		Doctors.setGender(DoctorsDetails.getGender());
		Doctors.setIsAvailable(DoctorsDetails.getIsAvailable());
		Doctors.setPhone(DoctorsDetails.getPhone());
		Doctors.setSpecializedin(DoctorsDetails.getSpecializedin());
		

		Doctors updatedDoctors = DoctorsRepository.save(Doctors);
		return ResponseEntity.ok(updatedDoctors);
	}
	
	// delete employee rest api
	@DeleteMapping("/DoctorsListd/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Doctors doctors = DoctorsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctors not exist with id :" + id));
		
		DoctorsRepository.delete(doctors);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}