package com.yzk.carsystem.serviceimp;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzk.carsystem.dao.CarUserDao;
import com.yzk.carsystem.dao.VipDao;
import com.yzk.carsystem.model.CarMaster;
import com.yzk.carsystem.service.CarUserService;
import com.yzk.carsystem.util.Pager;

@Service("carService")
@Transactional
public class CarUserServiceImp implements CarUserService {
	@Autowired
	private CarUserDao carUserDao;
	@Autowired
	private VipDao vipDao;

	public void setCarUserDao(CarUserDao carUserDao) {
		this.carUserDao = carUserDao;
	}

	@Override
	public boolean AddUser(CarMaster carMaster, String vip) {
		carMaster.setVip(vipDao.selectVipByName(vip));
		carUserDao.addCarUser(carMaster);
		return false;
	}

	@Override
	public void deleteCarUser(int id) {

		carUserDao.deleteCarUser(id);
	}

	@Override
	public void updateCarUser(CarMaster carMaster, int id) {
		carUserDao.updateCarUser(carMaster, id);
	}

	@Override
	public ArrayList<CarMaster> showAllCarUser() {
		return carUserDao.ShowallCarUser();
	}

	@Override
	public CarMaster selectCarUser(int id) {
		return carUserDao.selectCarUser(id);
	}

	@Override
	public CarMaster selectCarUserByName(String name) {
		return carUserDao.selectCarUserByName(name);
	}

	@Override
	public CarMaster selectCarUserByNumber(String number) {
		return carUserDao.selectCarUserByNumber(number);
	}

	@Override
	public CarMaster selectCarUserByTel(Long tel) {
		return carUserDao.selectCarUserByTel(tel);
	}

	@Override
	public List<CarMaster> showPageUser(Pager pager) {
		return carUserDao.showPageUser(pager);
	}

	@Override
	public int getTotalCount() {
		return carUserDao.getTotalCount();
	}

	@Override
	public CarMaster selectCarUserByType(String type, String value) {
		CarMaster carMaster;
		if (type.equals("name")) {
			carMaster = carUserDao.selectCarUserByName(value);
			return carMaster;
		}
		if (type.equals("number")) {
			carMaster = carUserDao.selectCarUserByNumber(value);
			return carMaster;
		} else if (type.equals("tel")) {
			Long tel = Long.parseLong(value);
			carMaster = carUserDao.selectCarUserByTel(tel);
			return carMaster;
		}
		return null;
	}

}
