package com.ehk.dao.hospital;

import java.util.List;

import com.ehk.model.hospital.Department;
import com.ehk.model.hospital.District;
import com.ehk.model.hospital.Gender;
import com.ehk.model.hospital.Hospital;
import com.ehk.model.hospital.HospitalVisit;
import com.ehk.model.hospital.Patient;
import com.ehk.vo.hospital.DepartmentVo;
import com.ehk.vo.hospital.DistrictVo;
import com.ehk.vo.hospital.HospitalVo;

public interface HospitalDAO {

	public void saveAndUpdateHospital(Hospital hospital);

	public List<Hospital> getAllHospital();

	public void deleteHospital(int hospitalId);

	public Hospital getHospital(int hospitalId);

	public List<District> getDistrictByStateId();

	public List<Gender> getGenderMasterList();

	public void saveAndUpdatePatient(Patient patient);

	public List<Patient> getAllPatient();

	public Patient getPatientByPatientId(int patientId);

	public void deletePatient(int patientId);

	public List<Hospital> getHospitalByDistrict(int districtId);

	public void createHospitalVisit(HospitalVisit hospitalVisit);

	public void saveDepartment(Department department);

	public List<Department> getDepartmentByHospital(int hospitalId);
}
