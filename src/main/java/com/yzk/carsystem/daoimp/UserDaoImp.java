package com.yzk.carsystem.daoimp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;
import com.yzk.carsystem.dao.UserDao;
import com.yzk.carsystem.model.User;
import com.yzk.carsystem.util.MyHIbernateDaoSupport;
import com.yzk.carsystem.util.Pager;

@Repository("userDao")
public class UserDaoImp extends MyHIbernateDaoSupport implements UserDao {

	@Override
	public void addUser(User user) {
		getHibernateTemplate().execute(new HibernateCallback<User>() {
			@Override
			public User doInHibernate(Session session) throws HibernateException {
				session.save(user);
				return null;
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<User> showallUser() {
		ArrayList<User> list = (ArrayList<User>) getHibernateTemplate().find("FROM User");
		return list;
	}

	@Override
	public void deleteUserByid(int id) {
		getHibernateTemplate().delete(selectUserById(id));
	}

	@Override
	public void updateUser(User user, int id) {
		User temp = selectUserById(id);
		temp.setUsername(user.getUsername());
		temp.setPassword(user.getPassword());
		temp.setState(user.getState());
		temp.setUser_id(id);
		temp.setRoles(user.getRoles());
		getHibernateTemplate().update(temp);
	}

	@Override
	public User selectUserById(int id) {
		return getHibernateTemplate().get(User.class, id);
	}

	@Override
	public User selectUserByName(String name) {
		for (User temp : showallUser()) {
			if (temp.getUsername().equals(name)) {
				return temp;
			}
		}
		return null;
	}

	@Override
	public boolean userLogin(User user) {
		for (User temp : showallUser()) {
			if (temp.getUsername().equals(user.getUsername()) && temp.getPassword().equals(user.getPassword())) {
				if (temp.getState() == 2) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public List<User> showPageUser(Pager pager) {
		List<User> lists = getHibernateTemplate().execute(new HibernateCallback<List<User>>() {
			@SuppressWarnings("unchecked")
			@Override
			public List<User> doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("FROM User").setFirstResult(pager.getIStart())
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
				Long count = (Long) session.createQuery("SELECT count(*) from User").uniqueResult();
				return count;
			}
		});
		return (int) count;
	}

	@Override
	public void registered(User user) {
		getHibernateTemplate().execute(new HibernateCallback<User>() {
			@Override
			public User doInHibernate(Session session) throws HibernateException {
				session.save(user);
				return null;
			}
		});
	}

}