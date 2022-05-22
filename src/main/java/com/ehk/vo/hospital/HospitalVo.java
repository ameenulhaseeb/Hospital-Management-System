package com.ehk.vo.hospital;

import java.util.List;

import com.ehk.model.hospital.District;

public class HospitalVo {

	private int hospital_id;
	private String hospital_name;
	private List<DistrictVo> districtList;
	private DistrictVo district;

	public HospitalVo() {
		// TODO Auto-generated constructor stub
	}

	public int getHospital_id() {
		return hospital_id;
	}

	public HospitalVo(int hospital_id, String hospital_name, List<DistrictVo> districtList, DistrictVo district) {
		super();
		this.hospital_id = hospital_id;
		this.hospital_name = hospital_name;
		this.districtList = districtList;
		this.district = district;
	}

	public void setHospital_id(int hospital_id) {
		this.hospital_id = hospital_id;
	}

	public String getHospital_name() {
		return hospital_name;
	}

	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}

	public DistrictVo getDistrict() {
		return district;
	}

	public void setDistrict(DistrictVo district) {
		this.district = district;
	}

	public List<DistrictVo> getDistrictList() {
		return districtList;
	}

	public void setDistrictList(List<DistrictVo> districtList) {
		this.districtList = districtList;
	}

}