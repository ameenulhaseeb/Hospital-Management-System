package com.ehk.model.hospital;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "patient")
public class Patient implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int patient_id;

	@Column
	private String patient_name;

	@Column
	private int gender_id;

	@Column

	private Date dob;

	@Column
	private String patient_image;

	@ManyToOne()
	@JoinColumn(name = "district_id")
	private District district;

	@Column
	private String phone;

	public Patient(int patient_id, String patient_name, int gender_id, Date dob, String patient_image,
			District district, String phone) {
		super();
		this.patient_id = patient_id;
		this.patient_name = patient_name;
		this.gender_id = gender_id;
		this.dob = dob;
		this.patient_image = patient_image;
		this.district = district;
		this.phone = phone;
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPatient_image() {
		return patient_image;
	}

	public void setPatient_image(String patient_image) {
		this.patient_image = patient_image;
	}

	public int getGender_id() {
		return gender_id;
	}

	public void setGender_id(int gender_id) {
		this.gender_id = gender_id;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}