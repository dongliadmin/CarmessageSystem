package com.yzk.carsystem.dao;

import java.util.ArrayList;
import java.util.List;

import com.yzk.carsystem.model.User;
import com.yzk.carsystem.util.Pager;

public interface UserDao {
	public void addUser(User user);

	public ArrayList<User> showallUser();

	public void deleteUserByid(int id);

	public void updateUser(User user, int id);

	public User selectUserByName(String name);

	public User selectUserById(int id);

	public boolean userLogin(User user);

	public List<User> showPageUser(Pager pager);
	public int getTotalCount();
	public void registered(User user);
}
