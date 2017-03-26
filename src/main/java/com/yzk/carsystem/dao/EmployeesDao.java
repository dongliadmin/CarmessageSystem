package com.yzk.carsystem.dao;

import java.util.List;

import com.yzk.carsystem.model.Employees;

public interface EmployeesDao {
	void addEmployees(Employees employees);

	List<Employees> showallEmployees();

	Employees selectEmployeesByid(int id);

	Employees selectEmployeesByName(String name);

	void updateEmployees(Employees employees);

	void deleteEmployees(int id);
}
