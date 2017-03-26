package com.yzk.carsystem.model;

import java.util.Set;

public class Roles {
	private int role_id;
	private String name;
	private String description;
	private Set<Module_functions> functionlist;
	private Set<User> users;
	
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Module_functions> getFunctionlist() {
		return functionlist;
	}

	public void setFunctionlist(Set<Module_functions> functionlist) {
		this.functionlist = functionlist;
	}

	public Roles(int role_id, String name, String description, Set<Module_functions> functionlist) {
		super();
		this.role_id = role_id;
		this.name = name;
		this.description = description;
		this.functionlist = functionlist;
	}

	public Roles() {
		super();
	}

	public Roles(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Roles [role_id=" + role_id + ", name=" + name + ", description=" + description + "=" + "]";
	}

}
