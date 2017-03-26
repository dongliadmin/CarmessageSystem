package com.yzk.carsystem.service;

import java.util.List;

import com.yzk.carsystem.model.Roles;

public interface RolesService {
	List<Roles> showAllRoles();
	void addRoles(Roles roles);
	void deleteRoles(int id);
	void updateRoles(Roles roles,int id);
	Roles selectRolesById(int id);
}
