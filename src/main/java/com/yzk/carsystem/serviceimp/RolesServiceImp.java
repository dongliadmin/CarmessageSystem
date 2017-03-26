package com.yzk.carsystem.serviceimp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzk.carsystem.dao.RolesDao;
import com.yzk.carsystem.model.Roles;
import com.yzk.carsystem.service.RolesService;

@Service("rolesService")
@Transactional
public class RolesServiceImp implements RolesService {
	@Autowired
	private RolesDao rolesDao;

	public void setRolesDao(RolesDao rolesDao) {
		this.rolesDao = rolesDao;
	}

	@Override
	public List<Roles> showAllRoles() {
		return rolesDao.showAllRoles();
	}

	@Override
	public void addRoles(Roles roles) {
		rolesDao.addRoles(roles);
	}

	@Override
	public void deleteRoles(int id) {
		rolesDao.deleteRoles(id);
	}

	@Override
	public void updateRoles(Roles roles, int id) {
		rolesDao.updateRoles(roles, id);
	}

	@Override
	public Roles selectRolesById(int id) {
		return rolesDao.selectRolesById(id);
	}

}