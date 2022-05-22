package com.ehk.vo.hospital;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

public class PatientVo {

	private int patient_id;

	private String patient_name;

	// private GenderVo gender;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;

	private String patient_image;

	private int gender_id;

	private String phone;

	// private List<GenderVo> genderList;

	private List<DistrictVo> districtList;
	private DistrictVo district;

	public PatientVo(int patient_id, String patient_name, Date dob, String patient_image, int gender_id, String phone,
			List<DistrictVo> districtList, DistrictVo district) {
		super();
		this.patient_id = patient_id;
		this.patient_name = patient_name;
		this.dob = dob;
		this.patient_image = patient_image;
		this.gender_id = gender_id;
		this.phone = phone;
		this.districtList = districtList;
		this.district = district;
	}

	public PatientVo() {
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

	/*
	 * public GenderVo getGender() { return gender; }
	 * 
	 * public void setGender(GenderVo gender) { this.gender = gender; }
	 */

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

	public List<DistrictVo> getDistrictList() {
		return districtList;
	}

	public void setDistrictList(List<DistrictVo> districtList) {
		this.districtList = districtList;
	}

	public DistrictVo getDistrict() {
		return district;
	}

	public void setDistrict(DistrictVo district) {
		this.district = district;
	}

	public int getGender_id() {
		return gender_id;
	}

	public void setGender_id(int gender_id) {
		this.gender_id = gender_id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	/*
	 * public List<GenderVo> getGenderList() { return genderList; }
	 * 
	 * public void setGenderList(List<GenderVo> genderList) { this.genderList =
	 * genderList; }
	 */

}