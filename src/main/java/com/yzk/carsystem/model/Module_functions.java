package com.yzk.carsystem.model;

import java.util.Set;

public class Module_functions {
	private int fid;
	private String functions_code;
	private String description;
	private Modules modules;
	private Set<Roles> roleList;

	public Module_functions(String functions_code, String description, Modules modules) {
		super();
		this.functions_code = functions_code;
		this.description = description;
		this.modules = modules;
	}

	public Module_functions(int fid, String functions_code, String description, Modules modules) {
		super();
		this.fid = fid;
		this.functions_code = functions_code;
		this.description = description;
		this.modules = modules;
	}

	public Module_functions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFunctions_code() {
		return functions_code;
	}

	public void setFunctions_code(String functions_code) {
		this.functions_code = functions_code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Modules getModules() {
		return modules;
	}

	public void setModules(Modules modules) {
		this.modules = modules;
	}

	public Set<Roles> getRoleList() {
		return roleList;
	}

	public void setRoleList(Set<Roles> roleList) {
		this.roleList = roleList;
	}

	@Override
	public String toString() {
		return "Module_functions [fid=" + fid + ", functions_code=" + functions_code + ", description=" + description
				+ ", modules= ";
	}

}
