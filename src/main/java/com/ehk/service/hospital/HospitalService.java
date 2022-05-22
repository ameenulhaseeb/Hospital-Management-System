package com.ehk.service.hospital;

import java.util.List;

import com.ehk.model.hospital.Hospital;
import com.ehk.vo.hospital.DepartmentVo;
import com.ehk.vo.hospital.DistrictVo;
import com.ehk.vo.hospital.GenderVo;
import com.ehk.vo.hospital.HospitalVisitVo;
import com.ehk.vo.hospital.HospitalVo;
import com.ehk.vo.hospital.PatientVo;


public interface HospitalService {
	
	public void saveAndUpdateHospital(HospitalVo hospitalVo);

	public List<HospitalVo> getAllHospital();

	public void deleteHospital(int hospitalId);

	public HospitalVo getHospital(int hospitalId);
	
	public List<DistrictVo> getDistrictByStateId();
	
	public List<GenderVo> getGenderMasterList();
	
	public void saveAndUpdatePatient(PatientVo patientVo);
	
	public List<PatientVo> getAllPatient();
	
	public PatientVo getPatientByPatientId(int patientId);
	
	public void deletePatient(int patientId);
	
	public List<HospitalVo> getHospitalByDistrict(int districtId);
	
	public void createHospitalVisit(HospitalVisitVo hospitalVisitVo);
	
	public void saveDepartment(DepartmentVo departmentVo);
	
	public List<DepartmentVo> getDepartmentByHospital(int hospitalId);
}
