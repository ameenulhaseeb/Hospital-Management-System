package com.ehk.dao.hospital;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ehk.model.hospital.Department;
import com.ehk.model.hospital.District;
import com.ehk.model.hospital.Gender;
import com.ehk.model.hospital.Hospital;
import com.ehk.model.hospital.HospitalVisit;
import com.ehk.model.hospital.Patient;
import com.ehk.vo.hospital.DepartmentVo;
import com.ehk.vo.hospital.DistrictVo;
import com.ehk.vo.hospital.HospitalVo;

@Repository
public class HospitalDAOImpl implements HospitalDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveAndUpdateHospital(Hospital hospital) {
		sessionFactory.getCurrentSession().saveOrUpdate(hospital);

	}

	@SuppressWarnings("unchecked")
	public List<Hospital> getAllHospital() {
		return sessionFactory.getCurrentSession().createQuery("from Hospital").list();
	}

	@Override
	public void deleteHospital(int hospitalId) {
		Hospital hospital = (Hospital) sessionFactory.getCurrentSession().load(Hospital.class, hospitalId);
		if (null != hospital) {
			this.sessionFactory.getCurrentSession().delete(hospital);
		}

	}

	public Hospital getHospital(int hospitalId) {
		return (Hospital) sessionFactory.getCurrentSession().get(Hospital.class, hospitalId);
	}

	@SuppressWarnings("unchecked")
	public List<District> getDistrictByStateId() {

		return sessionFactory.getCurrentSession().createQuery("from District ").list();
	}

	@SuppressWarnings("unchecked")
	public List<Gender> getGenderMasterList() {

		return sessionFactory.getCurrentSession().createQuery("from Gender ").list();
	}

	public void saveAndUpdatePatient(Patient patient) {
		sessionFactory.getCurrentSession().saveOrUpdate(patient);

	}

	@SuppressWarnings("unchecked")
	public List<Patient> getAllPatient() {
		return sessionFactory.getCurrentSession().createQuery("from Patient").list();
	}

	public Patient getPatientByPatientId(int patientId) {
		return (Patient) sessionFactory.getCurrentSession().get(Patient.class, patientId);
	}

	@Override
	public void deletePatient(int patientId) {
		Patient patient = (Patient) sessionFactory.getCurrentSession().load(Patient.class, patientId);
		if (null != patient) {
			this.sessionFactory.getCurrentSession().delete(patient);
		}

	}

	@SuppressWarnings("unchecked")
	public List<Hospital> getHospitalByDistrict(int districtId) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Hospital where district.district_id =" + districtId + "").list();
	}

	public void createHospitalVisit(HospitalVisit hospitalVisit) {
		sessionFactory.getCurrentSession().save(hospitalVisit);

	}

	public void saveDepartment(Department department) {
		sessionFactory.getCurrentSession().save(department);

	}

	@SuppressWarnings("unchecked")
	public List<Department> getDepartmentByHospital(int hospitalId) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Department where hospital.hospital_id =" + hospitalId + "").list();
	}

}