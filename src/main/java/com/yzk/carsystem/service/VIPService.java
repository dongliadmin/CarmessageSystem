package com.yzk.carsystem.service;

import java.util.List;

import com.yzk.carsystem.model.Vip;

public interface VIPService {
	List<Vip> showallVip();

	List<String> showallVipName();

	Vip selectVipByName(String name);
}
