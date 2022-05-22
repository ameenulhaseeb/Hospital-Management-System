package com.ehk.vo.hospital;

public class GenderVo {

	public GenderVo(int gender_id, String gender_name, String gender_code) {
		super();
		this.gender_id = gender_id;
		this.gender_name = gender_name;
		this.gender_code = gender_code;
	}

	public GenderVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int gender_id;

	private String gender_name;

	private String gender_code;

	public int getGender_id() {
		return gender_id;
	}

	public void setGender_id(int gender_id) {
		this.gender_id = gender_id;
	}

	public String getGender_name() {
		return gender_name;
	}

	public void setGender_name(String gender_name) {
		this.gender_name = gender_name;
	}

	public String getGender_code() {
		return gender_code;
	}

	public void setGender_code(String gender_code) {
		this.gender_code = gender_code;
	}

}