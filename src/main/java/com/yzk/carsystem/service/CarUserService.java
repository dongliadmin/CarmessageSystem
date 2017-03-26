package com.yzk.carsystem.service;

import java.util.ArrayList;
import java.util.List;

import com.yzk.carsystem.model.CarMaster;
import com.yzk.carsystem.util.Pager;

public interface CarUserService {
	public boolean AddUser(CarMaster carMaster,String vip);

	public void deleteCarUser(int id);

	public void updateCarUser(CarMaster carMaster, int id);

	public ArrayList<CarMaster> showAllCarUser();

	public CarMaster selectCarUser(int id);

	public CarMaster selectCarUserByName(String name);

	public CarMaster selectCarUserByNumber(String number);

	public CarMaster selectCarUserByTel(Long tel);
	public CarMaster selectCarUserByType(String type,String value);
	public List<CarMaster> showPageUser(Pager pager);
	public int getTotalCount();
}
