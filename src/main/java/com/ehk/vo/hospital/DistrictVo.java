package com.ehk.vo.hospital;

public class DistrictVo {

	private int district_id;
	private String district_name;
	private String district_code;

	public DistrictVo() {

	}

	public DistrictVo(int district_id, String district_name, String district_code) {
		super();
		this.district_id = district_id;
		this.district_name = district_name;
		this.district_code = district_code;
	}

	public int getDistrict_id() {
		return district_id;
	}

	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}

	public String getDistrict_name() {
		return district_name;
	}

	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}

	public String getDistrict_code() {
		return district_code;
	}

	public void setDistrict_code(String district_code) {
		this.district_code = district_code;
	}

}