package com.ehk.vo.hospital;

import java.util.List;
import java.util.Set;

import com.ehk.model.hospital.District;
import com.ehk.model.hospital.Hospital;
import com.ehk.model.hospital.Patient;

public class HospitalVisitVo {


	private int visit_id;
	private HospitalVo hospital;
	private List<HospitalVo> hospitalList;
	private PatientVo patient;
	private List<PatientVo> patientList;
	private List<DistrictVo> districtList;
	private DistrictVo district;
	private List<DepartmentVo> DepartmentVoList;
	private DepartmentVo departmentVo;
	private Set<Integer> deptSet;

	public HospitalVisitVo() {
		// TODO Auto-generated constructor stub
	}



	public HospitalVisitVo(int visit_id, HospitalVo hospital, List<HospitalVo> hospitalList, PatientVo patient,
			List<PatientVo> patientList, List<DistrictVo> districtList, DistrictVo district) {
		super();
		this.visit_id = visit_id;
		this.hospital = hospital;
		this.hospitalList = hospitalList;
		this.patient = patient;
		this.patientList = patientList;
		this.districtList = districtList;
		this.district = district;
	}



	public int getVisit_id() {
		return visit_id;
	}

	public void setVisit_id(int visit_id) {
		this.visit_id = visit_id;
	}



	public HospitalVo getHospital() {
		return hospital;
	}



	public void setHospital(HospitalVo hospital) {
		this.hospital = hospital;
	}



	public PatientVo getPatient() {
		return patient;
	}



	public void setPatient(PatientVo patient) {
		this.patient = patient;
	}



	public List<HospitalVo> getHospitalList() {
		return hospitalList;
	}

	public void setHospitalList(List<HospitalVo> hospitalList) {
		this.hospitalList = hospitalList;
	}



	public List<PatientVo> getPatientList() {
		return patientList;
	}

	public void setPatientList(List<PatientVo> patientList) {
		this.patientList = patientList;
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



	public List<DepartmentVo> getDepartmentVoList() {
		return DepartmentVoList;
	}



	public void setDepartmentVoList(List<DepartmentVo> departmentVoList) {
		DepartmentVoList = departmentVoList;
	}



	public DepartmentVo getDepartmentVo() {
		return departmentVo;
	}



	public void setDepartmentVo(DepartmentVo departmentVo) {
		this.departmentVo = departmentVo;
	}



	public Set<Integer> getDeptSet() {
		return deptSet;
	}



	public void setDeptSet(Set<Integer> deptSet) {
		this.deptSet = deptSet;
	}
	
	
	
}