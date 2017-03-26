package com.yzk.carsystem.daoimp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yzk.carsystem.dao.CarUserDao;
import com.yzk.carsystem.model.CarMaster;
import com.yzk.carsystem.util.MyHIbernateDaoSupport;
import com.yzk.carsystem.util.Pager;

@Transactional
@Repository("carDao")
public class CarDaoUserImp extends MyHIbernateDaoSupport implements CarUserDao {
	public void addCarUser(CarMaster carMaster) {
		getHibernateTemplate().save(carMaster);
	}

	@Transactional

	public void deleteCarUser(int id) {
		getHibernateTemplate().delete(selectCarUser(id));
	}

	public void updateCarUser(CarMaster carMaster, int id) {
		CarMaster temp = carMaster;
		temp.setId(id);
		temp.setVip(carMaster.getVip());
		getHibernateTemplate().update(temp);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<CarMaster> ShowallCarUser() {
		return (ArrayList<CarMaster>) getHibernateTemplate().find("FROM CarMaster");
	}

	public CarMaster selectCarUser(int id) {
		return getHibernateTemplate().get(CarMaster.class, id);
	}

	public CarMaster selectCarUserByName(String name) {
		for (CarMaster carMaster : ShowallCarUser()) {
			if (carMaster.getName().equals(name)) {
				return carMaster;
			}
		}
		return null;
	}

	public CarMaster selectCarUserByNumber(String number) {
		for (CarMaster carMaster : ShowallCarUser()) {
			if (carMaster.getNumber().equals(number)) {
				return carMaster;
			}
		}
		return null;
	}

	public CarMaster selectCarUserByTel(Long tel) {
		for (CarMaster carMaster : ShowallCarUser()) {
			if (carMaster.getTel().equals(tel)) {
				return carMaster;
			}
		}
		return null;
	}

	public List<CarMaster> showPageUser(Pager pager) {
		List<CarMaster> lists = getHibernateTemplate().execute(new HibernateCallback<List<CarMaster>>() {
			@SuppressWarnings("unchecked")

			public List<CarMaster> doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("FROM CarMaster").setFirstResult(pager.getIStart())
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
				Long count = (Long) session.createQuery("SELECT count(*) from CarMaster").uniqueResult();
				return count;
			}
		});
		return (int) count;
	}
}
