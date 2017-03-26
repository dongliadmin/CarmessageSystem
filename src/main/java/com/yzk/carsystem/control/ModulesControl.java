package com.yzk.carsystem.control;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yzk.carsystem.model.Modules;
import com.yzk.carsystem.service.ModulesService;

@Controller
@RequestMapping("/modulescontrol")
public class ModulesControl {
	@Autowired
	private ModulesService modulesService;

	@RequestMapping("/showallModules")
	public String main(Map<String, Object> map) {
		map.put("list", modulesService.showallModules());
		return "showallmodules";
	}

	@RequestMapping("/deletellModules")
	public String deletellModules(int id, Map<String, Object> map) {
		modulesService.deleteModulesById(id);
		map.put("list", modulesService.showallModules());
		return "showallmodules";
	}

	@RequestMapping("/addModules")
	public String addModules(Modules modules, Map<String, Object> map) {
		modulesService.addModules(modules);
		map.put("list", modulesService.showallModules());
		return "showallmodules";
	}

	@RequestMapping("/updateModules")
	public String updateModules(Modules modules, Map<String, Object> map) {
		modulesService.updateModules(modules);
		map.put("list", modulesService.showallModules());
		return "showallmodules";
	}

	@RequestMapping("/selectModulesById")
	public String selectModules(int id, Map<String, Object> map) {
		map.put("module", modulesService.selectModulesByid(id));
		return "updatemodule";
	}

	@RequestMapping("/selectallModulesfunction")
	public String selectallModulesfunction(int id, Map<String, Object> map) {
		System.out.println(id);
		Modules modules = modulesService.selectModulesByid(id);
		map.put("functionlist", modules.getFlist());
		map.put("id",id);
		return "showallmodulesfunction";
	}

	public void setModulesService(ModulesService modulesService) {
		this.modulesService = modulesService;
	}
}
