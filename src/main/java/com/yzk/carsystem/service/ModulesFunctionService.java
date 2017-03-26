package com.yzk.carsystem.service;

import java.util.List;

import com.yzk.carsystem.model.Module_functions;
import com.yzk.carsystem.util.Pager;

public interface ModulesFunctionService {
	boolean add(Module_functions function, int id);

	List<Module_functions> showallMfByMid(int id);

	List<Module_functions> showallModule_functions();

	void deleteModule_functions(int function_id);

	Module_functions selectModule_functionsByid(int id);

	void updateModule_function(Module_functions module_functions);

	int selectmoduleByModulefunctionid(int fid);

	public List<Module_functions> showPageUser(Pager pager);

	public int getTotalCount();
}
