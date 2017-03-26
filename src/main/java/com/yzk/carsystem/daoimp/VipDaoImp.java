package com.yzk.carsystem.daoimp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yzk.carsystem.dao.VipDao;
import com.yzk.carsystem.model.Vip;
import com.yzk.carsystem.util.MyHIbernateDaoSupport;

@Transactional
@Repository("vipDao")
public class VipDaoImp extends MyHIbernateDaoSupport implements VipDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Vip> showallVip() {
		return (List<Vip>) getHibernateTemplate().find("FROM Vip");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> showallVipName() {
		List<Vip> list = (List<Vip>) getHibernateTemplate().find("FROM Vip");
		List<String> namelist = new ArrayList<String>();
		for (Vip vip : list) {
			namelist.add(vip.getLevel());
		}
		return namelist;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Vip selectVipByName(String name) {
		List<Vip> list = (List<Vip>) getHibernateTemplate().find("FROM Vip");
		for (Vip vip : list) {
			if (vip.getLevel().equals(name)) {
				return vip;
			}
		}
		return null;
	}

}
