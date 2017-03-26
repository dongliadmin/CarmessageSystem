package com.yzk.carsystem.control;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yzk.carsystem.model.Module_functions;
import com.yzk.carsystem.service.ModulesFunctionService;

@Controller
@RequestMapping("/modulefunctionControl")
public class ModuleFunctionControl {
	@Autowired
	private ModulesFunctionService functionService;

	public void setFunctionService(ModulesFunctionService functionService) {
		this.functionService = functionService;
	}

	@RequestMapping("/showallfunction")
	public String main(Map<String, Object> map) {
		map.put("list", functionService.showallModule_functions());
		return "showallfunction";
	}

	@RequestMapping("/addfunction")
	public String addfunction(int mid, Module_functions functions, Map<String, Object> map) {
		functionService.add(functions, mid);
		map.put("functionlist", functionService.showallMfByMid(mid));
		map.put("id", mid);
		return "showallmodulesfunction";
	}

	@RequestMapping("/deletefunction")
	public String deletefunction(int id, Module_functions functions, Map<String, Object> map) {
		int fid= functionService.selectmoduleByModulefunctionid(id);
		functionService.deleteModule_functions(id);
		map.put("functionlist", functionService.showallMfByMid(fid));
		map.put("id", fid);
		return "showallmodulesfunction";
	}

	@RequestMapping("/updatefunction")
	public String updatefunction(int id, Module_functions functions, Map<String, Object> map) {
		functions.setFid(id);
		functionService.updateModule_function(functions);
		int fid= functionService.selectmoduleByModulefunctionid(id);
		map.put("functionlist", functionService.showallMfByMid(fid));
		map.put("id", fid);
		return "showallmodulesfunction";
	}

	@RequestMapping("/selectMfbyid")
	public String selectModule_functionsByid(int id, Map<String, Object> map) {
		map.put("function", functionService.selectModule_functionsByid(id));
		map.put("id", id);
		return "updatefunction";
	}

	@RequestMapping("/selectallModulesfunction")
	public String selectallModulesfunction(int id, Map<String, Object> map) {
		map.put("functionlist", functionService.showallMfByMid(id));
		map.put("id", id);
		return "showallmodulesfunction";
	}
}
