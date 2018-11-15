package com.yzk.carsystem.control;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yzk.carsystem.model.User;
import com.yzk.carsystem.service.RolesService;
import com.yzk.carsystem.service.UserService;
import com.yzk.carsystem.util.Pager;

@Controller
@RequestMapping("/usercontrol")
public class UserControl {
	private int mCurrentPager = 1; // 当前页
	@Autowired
	private UserService userService;
	@Autowired
	private RolesService rolesService;

	@RequestMapping("/main")
	public String main(Map<String, Object> map) {
		return "adduser";
	}

	@RequestMapping("/showuser")
	public String showalluser(Integer page, Map<String, Object> map) {
		if (page != null && page > 0) {
			mCurrentPager = page;
		}
		Pager pager = new Pager(userService.getTotalCount(), mCurrentPager);
		pager.setUrl("http://localhost:8080/CarSystem_Page/usercontrol/showuser.spring");
		map.put("url", pager.getPageStr());
		List<User> userLists = userService.showPageUser(pager);
		map.put("list", userLists);
		return "showalluser";
	}

	@RequestMapping("/adduser")
	public String adduser(int role_id, User user, Map<String, Object> map) {
		if (userService.selectUserByName(user.getUsername()) != null) {
			map.put("error", "用户存在");
			return "adduser";
		}
		user.setRoles(rolesService.selectRolesById(role_id));
		user.setState(1);
		userService.addUser(user);
		map.put("list", userService.showallUser());
		return "redirect:/usercontrol/showuser.spring";
	}

	@RequestMapping("/deleteuser")
	public String deleteuser(@RequestParam("id") Integer id, Map<String, Object> map) {
		userService.deleteUserByid(id);
		map.put("list", userService.showallUser());
		return "redirect:/usercontrol/showuser.spring";
	}

	@RequestMapping("/selectuser")
	public String selecteuser(@RequestParam("id") Integer id, Map<String, Object> map) {
		map.put("user", userService.selectUserById(id));
		map.put("role", rolesService.showAllRoles());
		return "updateUser";
	}

	@RequestMapping("/updateuser")
	public String updateuser(int role_id, int state, User user, Map<String, Object> map) {
		user.setRoles(rolesService.selectRolesById(role_id));
		userService.updateUser(user, user.getUser_id());
		map.put("list", userService.showallUser());
		return "redirect:/usercontrol/showuser.spring";
	}

	@RequestMapping("/userlogin")
	public String userlogin(User user, String save, Map<String, Object> map, HttpSession session,
			HttpServletResponse response, HttpServletRequest request) {
		if (userService.userLogin(user, save, map, session, response, request)) {
			map.put("username", user.getUsername());
			// return "redirect:/usercontrol/index.spring?username=?" + user.getUsername();
			return "redirect:/usercontrol/index.spring";
		}
		map.put("username", user.getUsername());
		map.put("error", "用户名或密码错误或者未通过审核!");
		return "login";
	}

	@RequestMapping("/index")
	public String main(String username, Map<String, Object> map) {
		map.put("username", username);
		return "index";
	}

	@RequestMapping("/exitlogin")
	public String exitlogin(HttpSession session) {
		// session.removeAttribute("username");
		session.setMaxInactiveInterval(1);
		return "login";
	}

	@RequestMapping("/registered")
	public String registered(User user, Map<String, Object> map) {

		if (userService.registered(user)) {
			return "login";
		}
		map.put("error", "用户名存在");
		return "registered";
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
