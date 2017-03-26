package com.yzk.carsystem.control;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yzk.carsystem.model.Module_functions;
import com.yzk.carsystem.model.Roles;
import com.yzk.carsystem.service.ModulesFunctionService;
import com.yzk.carsystem.service.RolesService;

@Controller
@RequestMapping("rolesControl")
public class RolesControl {
	@SuppressWarnings("unused")
	private int mCurrentPager = 1; // 当前页
	@Autowired
	private RolesService rolesService;
	@Autowired
	private ModulesFunctionService modulesFunctionService;

	public void setRolesService(RolesService rolesService) {
		this.rolesService = rolesService;
	}

	@RequestMapping("/showallRoles")
	public String showallRoles(Map<String, Object> map) {
		map.put("list", rolesService.showAllRoles());
		return "showallroles";
	}

	@RequestMapping("/addRoles")
	public String addRoles(Roles roles, Map<String, Object> map) {
		rolesService.addRoles(roles);
		map.put("list", rolesService.showAllRoles());
		return "showallroles";
	}

	@RequestMapping("/deleteRoles")
	public String deleteRoles(int id, Map<String, Object> map) {
		rolesService.deleteRoles(id);
		map.put("list", rolesService.showAllRoles());
		return "showallroles";
	}

	@RequestMapping("/updateRoles")
	public String updateRoles(Roles roles, Map<String, Object> map) {
		rolesService.updateRoles(roles, roles.getRole_id());
		map.put("list", rolesService.showAllRoles());
		return "showallroles";
	}

	@RequestMapping("/selectRolesByid")
	public String selectRolesByid(int id, Map<String, Object> map) {
		map.put("roles", rolesService.selectRolesById(id));
		return "updateroles";
	}

	@RequestMapping("/selectRAFunctionByid")
	public String selectRAFunctionByid(int id, Map<String, Object> map) {
		List<Module_functions> roleflist = new ArrayList<Module_functions>();
		for (Module_functions functions : rolesService.selectRolesById(id).getFunctionlist()) {
			roleflist.add(functions);
		}
		map.put("id", id);
		map.put("roleflist", roleflist);
		map.put("allflist", modulesFunctionService.showallModule_functions());
		return "showallrolesfunction";
	}
	/*
	 * 分页
	 * 
	 * @RequestMapping("/selectRAFunctionByid") public String showallcar(Integer
	 * page, Map<String, Object> map) { if (page != null && page > 0) {
	 * mCurrentPager = page; } int id = 6; Pager pager = new
	 * Pager(modulesFunctionService.getTotalCount(), mCurrentPager);
	 * pager.setUrl(
	 * "http://localhost:8080/Permissions/rolesControl/selectRAFunctionByid.spring"
	 * ); map.put("url", pager.getPageStr()); List<Module_functions> roleflist =
	 * new ArrayList<Module_functions>(); for (Module_functions functions :
	 * rolesService.selectRolesById(id).getFunctionlist()) {
	 * roleflist.add(functions); } map.put("id", id); map.put("roleflist",
	 * roleflist); map.put("allflist",
	 * modulesFunctionService.showPageUser(pager)); return
	 * "showallrolesfunction"; }
	 */

	@RequestMapping("/showallRolesname")
	public String showallRolesname(Map<String, Object> map) {
		map.put("list", rolesService.showAllRoles());
		return "adduser";
	}

	@RequestMapping("/submitfunction")
	public String submitfunction(Integer roleId, Integer[] selectId) {
		List<Module_functions> list = new ArrayList<Module_functions>();
		Roles roles = rolesService.selectRolesById(roleId);
		if (selectId != null) {
			for (int i : selectId) {
				list.add(modulesFunctionService.selectModule_functionsByid(i));
			}
			Set<Module_functions> functionlist = new HashSet<>();
			for (Module_functions functions : list) {
				functionlist.add(functions);
			}
			roles.setFunctionlist(functionlist);
			for (int i : selectId) {
				System.out.println(i);
			}
			System.out.println(">>>>>>>>>" + roleId);
			rolesService.updateRoles(roles, roleId);
			return "redirect:/rolesControl/showallRoles.spring";
		}
		roles.getFunctionlist().clear();
		rolesService.updateRoles(roles, roleId);
		return "redirect:/rolesControl/showallRoles.spring";
	}
}
