package com.ehk.vo.hospital;

import java.util.List;

public class DepartmentVo {


	public DepartmentVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int department_id;
	private String department_name;
	private HospitalVo hospitalVo;
	private List<DistrictVo> districtList;

	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public HospitalVo getHospitalVo() {
		return hospitalVo;
	}
	public void setHospitalVo(HospitalVo hospitalVo) {
		this.hospitalVo = hospitalVo;
	}
	public DepartmentVo(int department_id, String department_name, HospitalVo hospitalVo) {
		super();
		this.department_id = department_id;
		this.department_name = department_name;
		this.hospitalVo = hospitalVo;
	}
	public List<DistrictVo> getDistrictList() {
		return districtList;
	}
	public void setDistrictList(List<DistrictVo> districtList) {
		this.districtList = districtList;
	}
	public DepartmentVo(int department_id, String department_name, HospitalVo hospitalVo,
			List<DistrictVo> districtList) {
		super();
		this.department_id = department_id;
		this.department_name = department_name;
		this.hospitalVo = hospitalVo;
		this.districtList = districtList;
	}
	


	

	
	

	

}