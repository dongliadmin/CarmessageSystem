package com.yzk.carsystem.serviceimp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzk.carsystem.dao.ModulesDao;
import com.yzk.carsystem.dao.ModulesFunctionDao;
import com.yzk.carsystem.model.Module_functions;
import com.yzk.carsystem.service.ModulesFunctionService;
import com.yzk.carsystem.util.Pager;

@Service("modulesfunctionService")
@Transactional
public class ModulesFunctionServiceImp implements ModulesFunctionService {
	@Autowired
	ModulesFunctionDao modulesfunctionDao;
	@Autowired
	ModulesDao modulesDao;

	@Override
	public boolean add(Module_functions function, int id) {
		function.setModules(modulesDao.selectModulesByid(id));
		modulesfunctionDao.add(function);
		return true;
	}

	@Override
	public List<Module_functions> showallModule_functions() {
		return modulesfunctionDao.showallModule_functions();
	}

	@Override
	public void deleteModule_functions(int function_id) {
		modulesfunctionDao.deleteModule_functions(function_id);
	}

	@Override
	public Module_functions selectModule_functionsByid(int id) {
		return modulesfunctionDao.selectModule_functionsByid(id);
	}

	@Override
	public void updateModule_function(Module_functions module_functions) {
		Module_functions functions = selectModule_functionsByid(module_functions.getFid());
		functions.setDescription(module_functions.getDescription());
		functions.setFunctions_code(module_functions.getFunctions_code());
		modulesfunctionDao.updateModule_function(functions);
	}

	@Override
	public List<Module_functions> showallMfByMid(int id) {
		return modulesfunctionDao.showallMfByMid(id);
	}

	@Override
	public int selectmoduleByModulefunctionid(int fid) {
		return modulesfunctionDao.selectmoduleByModulefunctionid(fid);
	}

	@Override
	public List<Module_functions> showPageUser(Pager pager) {
		return modulesfunctionDao.showallUser_Page(pager);
	}

	@Override
	public int getTotalCount() {
		return modulesfunctionDao.getTotalCount();
	}

}
