package com.yzk.carsystem.model;

public class User {
	private int user_id;
	private String username;
	private String password;
	private int state;

	private Roles roles;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public User(int user_id, String username, String password, Roles roles) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", roles=" + roles
				+ "state"+state+"]";
	}

}