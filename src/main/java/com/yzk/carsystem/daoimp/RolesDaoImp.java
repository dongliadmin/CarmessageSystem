package com.yzk.carsystem.daoimp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yzk.carsystem.dao.RolesDao;
import com.yzk.carsystem.model.Module_functions;
import com.yzk.carsystem.model.Roles;
import com.yzk.carsystem.util.MyHIbernateDaoSupport;

@Transactional
@Repository("rolesDao")
public class RolesDaoImp extends MyHIbernateDaoSupport implements RolesDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Roles> showAllRoles() {
		return (List<Roles>) getHibernateTemplate().find("FROM Roles");
	}

	@Override
	public void addRoles(Roles roles) {
		getHibernateTemplate().save(roles);
	}

	@Override
	public void deleteRoles(int id) {
		Roles roles = selectRolesById(id);
		getHibernateTemplate().delete(roles);
	}

	@SuppressWarnings("unused")
	@Override
	public void updateRoles(Roles roles, int id) {
		Roles temp = selectRolesById(id);
		temp.setDescription(roles.getDescription());
		temp.setName(roles.getName());
		Set<Module_functions> list = new HashSet<Module_functions>();
		list = temp.getFunctionlist();
		temp.setFunctionlist(roles.getFunctionlist());
		getHibernateTemplate().update(temp);
	}
	// @Override
	// public void updateRoles(Roles roles, int id) {
	// Roles temp = selectRolesById(id);
	// temp.setDescription(roles.getDescription());
	// temp.setName(roles.getName());
	// temp.setFunctionlist(roles.getFunctionlist());
	// getHibernateTemplate().update(temp);
	// }

	@Override
	public Roles selectRolesById(int id) {
		return getHibernateTemplate().get(Roles.class, id);
	}
}
