package com.yzk.carsystem.serviceimp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzk.carsystem.dao.EmployeesDao;
import com.yzk.carsystem.model.Employees;
import com.yzk.carsystem.service.EmployeesService;

@Service("employeesService")
@Transactional
public class EmployeesServiceImp implements EmployeesService {
	@Autowired
	private EmployeesDao employeesDao;

	@Override
	public boolean addEmployees(Employees employees) {
		if (employeesDao.selectEmployeesByName(employees.getName()) != null) {
			return false;
		}
		employeesDao.addEmployees(employees);
		return true;
	}

	@Override
	public List<Employees> showallEmployees() {
		return employeesDao.showallEmployees();
	}

	@Override
	public Employees selectEmployeesByid(int id) {
		return employeesDao.selectEmployeesByid(id);
	}

	@Override
	public Employees selectEmployeesByName(String name) {
		return employeesDao.selectEmployeesByName(name);
	}

	@Override
	public void updateEmployees(Employees employees) {
		employeesDao.updateEmployees(employees);
	}

	@Override
	public void deleteEmployees(int id) {
		employeesDao.deleteEmployees(id);
	}

}
