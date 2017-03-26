package com.yzk.carsystem.dao;

import java.util.ArrayList;
import java.util.List;

import com.yzk.carsystem.model.CarMaster;
import com.yzk.carsystem.util.Pager;

public interface CarUserDao {
	public void addCarUser(CarMaster carMaster);

	public void deleteCarUser(int id);

	public void updateCarUser(CarMaster carMaster, int id);

	public ArrayList<CarMaster> ShowallCarUser();

	public CarMaster selectCarUser(int id);

	public CarMaster selectCarUserByName(String name);

	public CarMaster selectCarUserByNumber(String number);

	public CarMaster selectCarUserByTel(Long tel);
	public List<CarMaster> showPageUser(Pager pager);
	public int getTotalCount();
}
