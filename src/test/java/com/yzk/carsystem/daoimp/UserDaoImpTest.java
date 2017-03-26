package com.yzk.carsystem.daoimp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yzk.carsystem.dao.EmployeesDao;
import com.yzk.carsystem.model.CarMaster;
import com.yzk.carsystem.model.Employees;

public class UserDaoImpTest {
	@SuppressWarnings("resource")
	@Test
	public void testModule() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeesDao employeesDao = (EmployeesDao) applicationContext.getBean("employeesDaoImp");
		// Employees employees = new Employees(3, "小网", 500, currentTime);
		// employeesDao.updateEmployees(employees);
		CarMaster carMaster = new CarMaster();
		carMaster.getVip().getLevel();
	}
}
