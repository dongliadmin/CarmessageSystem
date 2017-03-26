package com.yzk.carsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yzk.carsystem.model.User;
import com.yzk.carsystem.util.Pager;

public interface UserService {
	public boolean addUser(User user);

	public ArrayList<User> showallUser();

	public void deleteUserByid(int id);

	public void updateUser(User user, int id);

	public User selectUserByName(String name);

	public User selectUserById(int id);

	public List<User> showPageUser(Pager pager);
	public boolean registered(User user);
	public int getTotalCount();

	public boolean userLogin(User user, String save, Map<String, Object> map, HttpSession session,
			HttpServletResponse response, HttpServletRequest request);
}
