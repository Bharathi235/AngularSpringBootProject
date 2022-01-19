package com.main.hospital.model;

import java.sql.Time;

//id, name , visitedDoctor, dateOfVisit.
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//id , name , age , gender ,specializedin,phone,Available,Avilabletime,email
@Entity
@Table(name = "doctors")
public class Doctors{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private String age;

	@Column(name = "gender")
	private String  gender;
	
	@Column(name = "specializedin")
	private String  specializedin;
	
	@Column(name = "phone")
	private long phone;
	
	@Column(name = "isAvailable")
	private String  isAvailable;
	
	@Column(name = "Avilabletime" )
	private Time Avilabletime;

	@Column(name = "email_id")
	private String emailId;	

	public Doctors() {

	}

	@Override
	public String toString() {
		return "Doctors [name=" + name + ", age=" + age + ", gender=" + gender + ", specializedin=" + specializedin
				+ ", phone=" + phone + ", isAvailable=" + isAvailable + ", Avilabletime=" + Avilabletime + ", emailId="
				+ emailId + "]";
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSpecializedin() {
		return specializedin;
	}

	public void setSpecializedin(String specializedin) {
		this.specializedin = specializedin;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Time getAvilabletime() {
		return Avilabletime;
	}

	public void setAvilabletime(Time avilabletime) {
		Avilabletime = avilabletime;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}
