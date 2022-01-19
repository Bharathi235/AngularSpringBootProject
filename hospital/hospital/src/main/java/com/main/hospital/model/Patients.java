package com.main.hospital.model;
import java.sql.Date;

//id, name , visitedDoctor, dateOfVisit.

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "patientsLists")
public class Patients{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="doctorsid")
	private Doctors doctor;
	private String  disease;
	private Date dateOfVisit;

		public void setDateOfVisit(Date dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public Patients() {

	}

	@Override
	public String toString() {
		return "Patients [name=" + name + ", Doctorvisited=" + doctor + ", Disease=" + disease + ", dateOfVisit="
				+ dateOfVisit + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Doctors getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctors doctor) {
		this.doctor = doctor;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public Date getDateOfVisit() {
		return dateOfVisit;
	}

	
}
