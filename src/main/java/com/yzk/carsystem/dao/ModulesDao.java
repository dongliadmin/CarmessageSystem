package com.yzk.carsystem.dao;

import java.util.List;

import com.yzk.carsystem.model.Modules;

public interface ModulesDao {
	void addModules(Modules modules);

	void deleteModulesById(int id);

	void updateModules(Modules modules);

	Modules selectModulesByid(int id);

	List<Modules> showallModules();
	void deleteModulesFunctionByMId(int id);
}
