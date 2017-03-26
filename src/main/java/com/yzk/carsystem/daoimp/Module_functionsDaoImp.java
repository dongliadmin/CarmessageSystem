package com.yzk.carsystem.daoimp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yzk.carsystem.dao.ModulesFunctionDao;
import com.yzk.carsystem.model.Module_functions;
import com.yzk.carsystem.util.MyHIbernateDaoSupport;
import com.yzk.carsystem.util.Pager;

@Transactional
@Repository("modules_functionDao")
public class Module_functionsDaoImp extends MyHIbernateDaoSupport implements ModulesFunctionDao {

	@Override
	public void add(Module_functions function) {
		getHibernateTemplate().save(function);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Module_functions> showallModule_functions() {
		return (List<Module_functions>) getHibernateTemplate().find("FROM Module_functions");
	}

	@Override
	public void deleteModule_functions(int function_id) {
		Module_functions functions = selectModule_functionsByid(function_id);
		getHibernateTemplate().delete(functions);
	}

	@Override
	public Module_functions selectModule_functionsByid(int id) {
		return getHibernateTemplate().get(Module_functions.class, id);
	}

	@Override
	public void updateModule_function(Module_functions module_functions) {
		getHibernateTemplate().update(module_functions);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Module_functions> showallMfByMid(int id) {
		return (List<Module_functions>) getHibernateTemplate().find("FROM Module_functions where module_id=" + id);
	}

	@Override
	public Module_functions selectModuleFunctionByid(int id) {
		return getHibernateTemplate().get(Module_functions.class, id);
	}

	@Override
	public int selectmoduleByModulefunctionid(int fid) {
		Module_functions functions = selectModule_functionsByid(fid);
		return functions.getModules().getModule_id();
	}

	@Override
	public List<Module_functions> showallUser_Page(Pager pager) {
		List<Module_functions> lists = getHibernateTemplate().execute(new HibernateCallback<List<Module_functions>>() {
			@SuppressWarnings("unchecked")
			public List<Module_functions> doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("FROM Module_functions").setFirstResult(pager.getIStart())
						.setMaxResults(pager.getIStep());
				return query.list();
			}
		});
		return lists;
	}

	@Override
	public int getTotalCount() {
		long count = getHibernateTemplate().execute(new HibernateCallback<Long>() {
			@Override
			public Long doInHibernate(Session session) throws HibernateException {
				Long count = (Long) session.createQuery("SELECT count(*) from Module_functions").uniqueResult();
				return count;
			}
		});
		return (int) count;
	}
}
