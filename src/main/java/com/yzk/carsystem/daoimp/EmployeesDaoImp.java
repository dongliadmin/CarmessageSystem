package com.yzk.carsystem.daoimp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yzk.carsystem.dao.EmployeesDao;
import com.yzk.carsystem.model.Employees;
import com.yzk.carsystem.util.MyHIbernateDaoSupport;

@Transactional
@Repository("employeesDaoImp")
public class EmployeesDaoImp extends MyHIbernateDaoSupport implements EmployeesDao {
	@Override
	public void addEmployees(Employees employees) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = sdf.parse(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
			employees.setStartDate(date);
			getHibernateTemplate().save(employees);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employees> showallEmployees() {
		return (List<Employees>) getHibernateTemplate().find("FROM Employees");
	}

	@Override
	public Employees selectEmployeesByid(int id) {
		return getHibernateTemplate().get(Employees.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Employees selectEmployeesByName(String name) {
		List<Employees> list = (List<Employees>) getHibernateTemplate().find(" FROM Employees WHERE name=?", name);
		if (list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public void updateEmployees(Employees employees) {
		Employees temp = getHibernateTemplate().get(Employees.class, employees.getEid());
		temp.setName(employees.getName());
		temp.setSalary(employees.getSalary());
		getHibernateTemplate().update(temp);
	}

	@Override
	public void deleteEmployees(int id) {
		Employees employees = new Employees();
		employees.setEid(id);
		getHibernateTemplate().delete(employees);
	}

}
