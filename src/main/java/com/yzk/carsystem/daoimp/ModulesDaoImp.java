package com.yzk.carsystem.daoimp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yzk.carsystem.dao.ModulesDao;
import com.yzk.carsystem.model.Modules;
import com.yzk.carsystem.util.MyHIbernateDaoSupport;

@Transactional
@Repository("modulesDao")
public class ModulesDaoImp extends MyHIbernateDaoSupport implements ModulesDao {

	@Override
	public void addModules(Modules modules) {
		getHibernateTemplate().save(modules);
	}

	@SuppressWarnings("unchecked")
	public List<Modules> showallModules() {
		return (List<Modules>) getHibernateTemplate().find("FROM Modules");
	}

	@Override
	public void updateModules(Modules modules) {
		Modules temp = selectModulesByid(modules.getModule_id());
		temp.setDescription(modules.getDescription());
		temp.setName(modules.getName());
		getHibernateTemplate().update(temp);
	}

	@Override
	public Modules selectModulesByid(int id) {
		return getHibernateTemplate().get(Modules.class, id);
	}

	@Override
	public void deleteModulesById(int id) {
		Modules modules = new Modules();
		modules.setModule_id(id);
		getHibernateTemplate().delete(modules);
	}

	@Override
	public void deleteModulesFunctionByMId(int id) {
		getHibernateTemplate().execute(new HibernateCallback<Modules>() {
			@Override
			public Modules doInHibernate(Session session) throws HibernateException {
				String sql = "delete from  module_functions where module_id=?";
				SQLQuery query = session.createSQLQuery(sql);
				query.setInteger(0, id);
				query.executeUpdate();
				return null;
			}
		});
	}

}
