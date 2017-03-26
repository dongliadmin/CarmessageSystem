package com.yzk.carsystem.dao;

import java.util.List;

import com.yzk.carsystem.model.Roles;

public interface RolesDao {
	List<Roles> showAllRoles();
	void addRoles(Roles roles);
	void deleteRoles(int id);
	void updateRoles(Roles roles,int id);
	Roles selectRolesById(int id);
//	List<Roles> selectallRolesName();
}
