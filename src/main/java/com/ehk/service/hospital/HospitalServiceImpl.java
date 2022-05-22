package com.ehk.service.hospital;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ehk.dao.hospital.HospitalDAO;
import com.ehk.model.hospital.Department;
import com.ehk.model.hospital.District;
import com.ehk.model.hospital.Gender;
import com.ehk.model.hospital.Hospital;
import com.ehk.model.hospital.HospitalVisit;
import com.ehk.model.hospital.Patient;
import com.ehk.vo.hospital.DepartmentVo;
import com.ehk.vo.hospital.DistrictVo;
import com.ehk.vo.hospital.GenderVo;
import com.ehk.vo.hospital.HospitalVisitVo;
import com.ehk.vo.hospital.HospitalVo;
import com.ehk.vo.hospital.PatientVo;

@Service
@Transactional
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	private HospitalDAO hospitalDAO;

	@Override
	@Transactional
	public void saveAndUpdateHospital(HospitalVo hospitalVo) {

		Hospital hospital = new Hospital();
		if (hospitalVo.getHospital_id() != 0) {
			// hospital =hospitalDAO.getHospital(hospitalVo.getHospital_id());
			hospital.setHospital_id(hospitalVo.getHospital_id());
		}
		hospital.setHospital_name(hospitalVo.getHospital_name());
		District district = new District();
		district.setDistrict_id(hospitalVo.getDistrict().getDistrict_id());
		hospital.setDistrict(district);
		hospitalDAO.saveAndUpdateHospital(hospital);
	}

	@Override
	public List<HospitalVo> getAllHospital() {
		// BeanUtils.copyProperties(sourceObject, hospitalVo);
		List<Hospital> hospitalList = hospitalDAO.getAllHospital();
		List<HospitalVo> hospitalVo = hospitalList.stream().map(s -> new HospitalVo(s.getHospital_id(),
				s.getHospital_name(), new ArrayList<DistrictVo>(), new DistrictVo(s.getDistrict().getDistrict_id(),
						s.getDistrict().getDistrict_name(), s.getDistrict().getDistrict_code())))
				.collect(Collectors.toList());
		return hospitalVo;
	}

	@Override
	public void deleteHospital(int hospitalId) {
		hospitalDAO.deleteHospital(hospitalId);
	}

	public HospitalVo getHospital(int hospitalId) {
		HospitalVo hospitalVo = new HospitalVo();
		Hospital hospital = hospitalDAO.getHospital(hospitalId);
		hospitalVo.setHospital_id(hospital.getHospital_id());
		hospitalVo.setHospital_name(hospital.getHospital_name());
		hospitalVo.setDistrict(new DistrictVo(hospital.getDistrict().getDistrict_id(),
				hospital.getDistrict().getDistrict_name(), hospital.getDistrict().getDistrict_code()));
		return hospitalVo;
	}

	@Override
	public List<DistrictVo> getDistrictByStateId() {

		List<District> districtList = hospitalDAO.getDistrictByStateId();
		List<DistrictVo> districtVo = districtList.stream()
				.map(s -> new DistrictVo(s.getDistrict_id(), s.getDistrict_name(), s.getDistrict_code()))
				.collect(Collectors.toList());

		return districtVo;
	}

	@Override
	public List<GenderVo> getGenderMasterList() {

		List<Gender> genderList = hospitalDAO.getGenderMasterList();
		List<GenderVo> genderVoList = genderList.stream()
				.map(s -> new GenderVo(s.getGender_id(), s.getGender_name(), s.getGender_code()))
				.collect(Collectors.toList());

		return genderVoList;
	}

	@Override
	@Transactional
	public void saveAndUpdatePatient(PatientVo patientVo) {

		Patient patient = new Patient();
		if (patientVo.getPatient_id() != 0) {
			patient.setPatient_id(patientVo.getPatient_id());

		}
		patient.setPatient_name(patientVo.getPatient_name());
		patient.setGender_id(patientVo.getGender_id());
		patient.setPhone(patientVo.getPhone());
		patient.setDob(patientVo.getDob());
		District district = new District();
		district.setDistrict_id(patientVo.getDistrict().getDistrict_id());
		patient.setDistrict(district);
		patient.setPatient_image(patientVo.getPatient_image());
		hospitalDAO.saveAndUpdatePatient(patient);
	}

	@Override
	public List<PatientVo> getAllPatient() {
		List<Patient> patientList = hospitalDAO.getAllPatient();
		List<PatientVo> patientVo = patientList.stream()
				.map(s -> new PatientVo(
						s.getPatient_id(), s.getPatient_name(), s.getDob(), s.getPatient_image(), s.getGender_id(),
						s.getPhone(), new ArrayList<DistrictVo>(), new DistrictVo(s.getDistrict().getDistrict_id(),
								s.getDistrict().getDistrict_name(), s.getDistrict().getDistrict_code())))
				.collect(Collectors.toList());
		return patientVo;
	}

	public PatientVo getPatientByPatientId(int patientId) {
		PatientVo patientVo = new PatientVo();
		Patient patient = hospitalDAO.getPatientByPatientId(patientId);
		patientVo.setPatient_id(patient.getPatient_id());
		patientVo.setPatient_name(patient.getPatient_name());
		patientVo.setGender_id(patient.getGender_id());
		patientVo.setPhone(patient.getPhone());
		patientVo.setPatient_image(patient.getPatient_image());
		patientVo.setDob(patient.getDob());
		patientVo.setDistrict(new DistrictVo(patient.getDistrict().getDistrict_id(),
				patient.getDistrict().getDistrict_name(), patient.getDistrict().getDistrict_code()));
		return patientVo;
	}

	@Override
	public void deletePatient(int patientId) {
		hospitalDAO.deletePatient(patientId);
	}

	@Override
	public List<HospitalVo> getHospitalByDistrict(int districtId) {
		List<Hospital> hospitalList = hospitalDAO.getHospitalByDistrict(districtId);
		List<HospitalVo> hospitalVo = hospitalList.stream().map(s -> new HospitalVo(s.getHospital_id(),
				s.getHospital_name(), new ArrayList<DistrictVo>(), new DistrictVo(s.getDistrict().getDistrict_id(),
						s.getDistrict().getDistrict_name(), s.getDistrict().getDistrict_code())))
				.collect(Collectors.toList());
		return hospitalVo;
	}

	@Override
	@Transactional
	public void createHospitalVisit(HospitalVisitVo hospitalVisitVo) {

		HospitalVisit hospitalVisit = new HospitalVisit();
		Hospital newHospital = new Hospital();
		newHospital.setHospital_id(hospitalVisitVo.getHospital().getHospital_id());
		hospitalVisit.setHospital(newHospital);
		Patient newPatient = new Patient();
		newPatient.setPatient_id(hospitalVisitVo.getPatient().getPatient_id());
		hospitalVisit.setPatient(newPatient);
		Set<Integer> deptSet = hospitalVisitVo.getDeptSet();
		List<Department> deptlist = new ArrayList<Department>();
		deptSet.stream().forEach(deptId -> {
			deptlist.add(new Department(deptId));
		});
		hospitalVisit.setHospDeptVisitList(deptlist);
		hospitalDAO.createHospitalVisit(hospitalVisit);
	}

	@Override
	@Transactional
	public void saveDepartment(DepartmentVo departmentVo) {

		Department department = new Department();
		Hospital newHospital = new Hospital();
		department.setDepartment_name(departmentVo.getDepartment_name());
		newHospital.setHospital_id(departmentVo.getHospitalVo().getHospital_id());
		department.setHospital(newHospital);
		hospitalDAO.saveDepartment(department);
	}

	@Override
	public List<DepartmentVo> getDepartmentByHospital(int hospitalId) {
		List<Department> departmentList = hospitalDAO.getDepartmentByHospital(hospitalId);
		List<DepartmentVo> departmentVo = departmentList.stream()
				.map(s -> new DepartmentVo(s.getDepartment_id(), s.getDepartment_name(), new HospitalVo(
						s.getHospital().getHospital_id(), s.getHospital().getHospital_name(), null, null)))
				.collect(Collectors.toList());
		return departmentVo;
	}
}
