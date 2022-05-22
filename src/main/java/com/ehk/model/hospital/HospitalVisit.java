package com.ehk.model.hospital;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hospital_visit")
public class HospitalVisit implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int visit_id;

	@ManyToOne()
	@JoinColumn(name = "hospital_id")
	private Hospital hospital;

	@ManyToOne()
	@JoinColumn(name = "patient_id")
	private Patient patient;
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinTable(name = "visit_department", joinColumns = {
			@JoinColumn(name = "visit_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "department_id", nullable = false, updatable = false) })
	private List<Department> hospDeptVisitList = new ArrayList<Department>();

	public int getVisit_id() {
		return visit_id;
	}

	public void setVisit_id(int visit_id) {
		this.visit_id = visit_id;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<Department> getHospDeptVisitList() {
		return hospDeptVisitList;
	}

	public void setHospDeptVisitList(List<Department> hospDeptVisitList) {
		this.hospDeptVisitList = hospDeptVisitList;
	}

}