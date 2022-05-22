package com.ehk.validator;

import java.sql.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.ehk.vo.hospital.PatientVo;

@Component
public class HospitalValidator {

	public void validate(Object o, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "patient_name", "NotEmpty", "Please Enter Patient Name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty", "Please Enter Phone Number");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dob", "NotEmpty", "Please Select DOB");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender_id", "NotEmpty", "Please Select Gender");
		PatientVo patientVo = (PatientVo) o;
		if (patientVo.getGender_id() == 0) {
			errors.rejectValue("gender_id", "NotEmpty", "Please Select Gender");
		}
		if (patientVo.getDistrict().getDistrict_id() == 0) {
			errors.rejectValue("district.district_id", "NotEmpty", "Please Select District");
		}

	}
}
