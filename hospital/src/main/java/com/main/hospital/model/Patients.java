package com.main.hospital.model;
import java.sql.Date;

//id, name , visitedDoctor, dateOfVisit.
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patients")
public class Patients{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "Doctor")
	private String  doctor;
	
	@Column(name = "Disease")
	private String  disease;

	@Column(name = "date_of_visit" ,columnDefinition="DATE DEFAULT CURENT_DATE" )
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

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
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
