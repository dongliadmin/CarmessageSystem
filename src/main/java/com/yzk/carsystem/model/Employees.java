package com.yzk.carsystem.model;

import java.util.Date;

public class Employees {
	private int eid;
	private String name;
	private int salary;
	private Date startDate;

	public Employees(int eid, String name, int salary, Date startDate) {
		super();
		this.eid = eid;
		this.name = name;
		this.salary = salary;
		this.startDate = startDate;
	}

	public Employees() {
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "Employees [eid=" + eid + ", name=" + name + ", salary=" + salary + ", startDate=" + startDate + "]";
	}

}
