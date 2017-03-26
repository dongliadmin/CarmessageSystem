package com.yzk.carsystem.model;

import java.util.Set;

public class Vip {
	private int id;
	private String level;
	private int discount;
	private Set<CarMaster> carlist;

	public Set<CarMaster> getCarlist() {
		return carlist;
	}

	public void setCarlist(Set<CarMaster> carlist) {
		this.carlist = carlist;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public Vip(int id, String level, int discount) {
		super();
		this.id = id;
		this.level = level;
		this.discount = discount;
	}

	public Vip(String level, int discount) {
		super();
		this.level = level;
		this.discount = discount;
	}

	public Vip() {
	}

	@Override
	public String toString() {
		return "Vip [id=" + id + ", level=" + level + ", discount=" + discount + "]";
	}

}
