package com.yzk.carsystem.serviceimp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzk.carsystem.dao.ModulesDao;
import com.yzk.carsystem.dao.ModulesFunctionDao;
import com.yzk.carsystem.model.Modules;
import com.yzk.carsystem.service.ModulesService;

@Service("modulesService")
@Transactional
public class ModulesServiceImp implements ModulesService {
	@Autowired
	ModulesDao modulesDao;
	@Autowired
	ModulesFunctionDao modulesFunctionDao;

	public boolean addModules(Modules modules) {
		modulesDao.addModules(modules);
		return true;
	}

	@Override
	public void deleteModulesById(int id) {
		deleteModulesFunctionByMId(id);
		modulesDao.deleteModulesById(id);
	}

	@Override
	public void updateModules(Modules modules) {
		modulesDao.updateModules(modules);
	}

	@Override
	public Modules selectModulesByid(int id) {
		return modulesDao.selectModulesByid(id);
	}

	@Override
	public List<Modules> showallModules() {
		return modulesDao.showallModules();
	}

	@Override
	public void deleteModulesFunctionByMId(int id) {
		modulesDao.deleteModulesFunctionByMId(id);
	}

}
