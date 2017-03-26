package com.yzk.carsystem.dao;

import java.util.List;

import com.yzk.carsystem.model.Vip;

public interface VipDao {
	List<Vip> showallVip();

	List<String> showallVipName();

	Vip selectVipByName(String name);

}
