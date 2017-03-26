package com.yzk.carsystem.service;

import java.util.List;

import com.yzk.carsystem.model.Modules;

public interface ModulesService {

	boolean addModules(Modules modules);

	void deleteModulesById(int id);

	void updateModules(Modules modules);

	Modules selectModulesByid(int id);

	List<Modules> showallModules();
	void deleteModulesFunctionByMId(int id);
}
