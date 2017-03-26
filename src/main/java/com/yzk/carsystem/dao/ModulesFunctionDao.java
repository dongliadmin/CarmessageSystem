package com.yzk.carsystem.dao;

import java.util.List;

import com.yzk.carsystem.model.Module_functions;
import com.yzk.carsystem.util.Pager;

public interface ModulesFunctionDao {

	void add(Module_functions function);

	List<Module_functions> showallModule_functions();

	List<Module_functions> showallMfByMid(int id);

	void deleteModule_functions(int function_id);

	Module_functions selectModule_functionsByid(int id);

	Module_functions selectModuleFunctionByid(int id);

	void updateModule_function(Module_functions module_functions);

	int selectmoduleByModulefunctionid(int fid);

	public List<Module_functions> showallUser_Page(Pager pager);
	public int getTotalCount();
}
