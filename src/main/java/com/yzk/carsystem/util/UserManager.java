package com.yzk.carsystem.util;

import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yzk.carsystem.dao.UserDao;
import com.yzk.carsystem.model.Module_functions;
import com.yzk.carsystem.model.Roles;
import com.yzk.carsystem.model.User;

public class UserManager {
	private static UserDao userDao;

	private static UserManager UMG = null;

	public static UserManager getInstance() {
		if (UMG == null) {
			UMG = new UserManager();
			initUserManager();
		}
		return UMG;
	}

	public boolean getGroupPermission(String userId, String action) {
		boolean results = false;
		// User user = (User) userDao.getUserById(Integer.parseInt(userId));
		User user = (User) userDao.selectUserById(Integer.parseInt(userId));
		Roles role = user.getRoles();
		Set<Module_functions> functionLists = role.getFunctionlist();
		System.out.println("请求的" + action);
		for (Module_functions fuction : functionLists) {
			if (fuction.getFunctions_code().equals(action)) {
				results = true;
				break;
			}
		}
		return results;
	}

	@SuppressWarnings("resource")
	public static void initUserManager() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		userDao = (UserDao) ctx.getBean("userDao");
	}

}
