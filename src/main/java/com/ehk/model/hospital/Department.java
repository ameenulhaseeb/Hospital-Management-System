package com.ehk.model.hospital;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department implements Serializable {

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(int department_id) {
		super();
		this.department_id = department_id;
	}

	private static final long serialVersionUID = -3465813074586302847L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int department_id;

	@Column
	private String department_name;

	@ManyToOne()
	@JoinColumn(name = "hospital_id")
	private Hospital hospital;

	@ManyToMany(mappedBy = "hospDeptVisitList")
	private List<HospitalVisit> hospitalVisits = new ArrayList<HospitalVisit>();

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public List<HospitalVisit> getHospitalVisits() {
		return hospitalVisits;
	}

	public void setHospitalVisits(List<HospitalVisit> hospitalVisits) {
		this.hospitalVisits = hospitalVisits;
	}

}