package com.yzk.carsystem.control;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yzk.carsystem.model.Employees;
import com.yzk.carsystem.service.EmployeesService;

@Controller
@RequestMapping("/employeesControl")
public class EmployeesControl {
	@Autowired
	private EmployeesService employeesService;

	public EmployeesService getEmployeesService() {
		return employeesService;
	}

	@RequestMapping("/main")
	public String main(Map<String, Object> map) {
		map.put("list", employeesService.showallEmployees());
		return "showallemployees";
	}

	@RequestMapping("/addemployees")
	public String addemployees(Employees employees, Map<String, Object> map) {
		 employeesService.addEmployees(employees);
		map.put("list", employeesService.showallEmployees());
		return "showallemployees";
	}

	@RequestMapping("/deleteemployees")
	public String deleteemployees(int id, Map<String, Object> map) {
		employeesService.deleteEmployees(id);
		map.put("list", employeesService.showallEmployees());
		return "showallemployees";
	}

	@RequestMapping("/updateemployees")
	public String main(Employees employees, Map<String, Object> map) {
		employeesService.updateEmployees(employees);
		map.put("list", employeesService.showallEmployees());
		return "showallemployees";
	}

	@RequestMapping("/selectemployeesByid")
	public String selectemployeesByid(int id, Map<String, Object> map) {
		map.put("employees", employeesService.selectEmployeesByid(id));
		return "updateemployees";
	}

	@RequestMapping("/selectemployeesByname")
	public String selectemployeesByname(String name, Map<String, Object> map) {
		employeesService.selectEmployeesByName(name);
		map.put("list", employeesService.showallEmployees());
		return "showallemployees";
	}
}
