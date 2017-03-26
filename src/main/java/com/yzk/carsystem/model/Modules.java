package com.yzk.carsystem.model;

import java.util.Set;

public class Modules {
	private int module_id;
	private String name;
	private String description;
	private Set<Module_functions> flist;

	
	public Modules(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Modules(int module_id, String name, String description) {
		super();
		this.module_id = module_id;
		this.name = name;
		this.description = description;
	}

	public Modules(int module_id, String name, String description, Set<Module_functions> flist) {
		this.module_id = module_id;
		this.name = name;
		this.description = description;
		this.flist = flist;
	}

	public Modules() {
	}

	public int getModule_id() {
		return module_id;
	}

	public void setModule_id(int module_id) {
		this.module_id = module_id;
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

	public Set<Module_functions> getFlist() {
		return flist;
	}

	public void setFlist(Set<Module_functions> flist) {
		this.flist = flist;
	}

	@Override
	public String toString() {
		return "Modules [module_id=" + module_id + ", name=" + name + ", description=" + description + ", flist="
				+ flist + "]";
	}
}
