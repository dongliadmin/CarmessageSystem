package com.yzk.carsystem.serviceimp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzk.carsystem.dao.UserDao;
import com.yzk.carsystem.model.Roles;
import com.yzk.carsystem.model.User;
import com.yzk.carsystem.service.UserService;
import com.yzk.carsystem.util.Pager;

@Service("userService")
@Transactional
public class UserServiceImp implements UserService {
	@Autowired
	UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean addUser(User user) {
		User temp = userDao.selectUserByName(user.getUsername());
		if (temp == null) {
			userDao.addUser(user);
			return true;
		}
		return false;
	}

	public ArrayList<User> showallUser() {
		return userDao.showallUser();
	}

	public void deleteUserByid(int id) {
		userDao.deleteUserByid(id);
	}

	public void updateUser(User user, int id) {
		userDao.updateUser(user, id);
	}

	public User selectUserByName(String name) {
		return userDao.selectUserByName(name);
	}

	public User selectUserById(int id) {
		return userDao.selectUserById(id);
	}

	public boolean userLogin(User user) {
		return userDao.userLogin(user);
	}

	@Override
	public List<User> showPageUser(Pager pager) {
		return userDao.showPageUser(pager);
	}

	@Override
	public int getTotalCount() {
		return userDao.getTotalCount();
	}

	public boolean userLogin(User user, String save, Map<String, Object> map, HttpSession session,
			HttpServletResponse response, HttpServletRequest request) {
		if (userDao.userLogin(user)) {
			session.setAttribute("username", user.getUsername());
			session.setAttribute("userId", selectUserByName(user.getUsername()).getUser_id());
			session.setMaxInactiveInterval(60 * 60);
			map.put("list", showallUser());
			map.put("username", user.getUsername());
			if (save != null && save.equals("true")) {
				Cookie username = new Cookie("username", user.getUsername());
				Cookie password = new Cookie("password", user.getPassword());
				username.setMaxAge(60 * 60 * 24);
				password.setMaxAge(60 * 60 * 24);
				username.setPath("/");
				password.setPath("/");
				response.addCookie(username);
				response.addCookie(password);
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean registered(User user) {
		if (selectUserByName(user.getUsername()) == null) {
			user.setState(1);
			Roles roles = new Roles();
			roles.setRole_id(9);
			user.setRoles(roles);
			userDao.registered(user);
			return true;
		}
		return false;
	}

}
