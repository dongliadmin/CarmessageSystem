package com.yzk.carsystem.serviceimp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzk.carsystem.dao.VipDao;
import com.yzk.carsystem.model.Vip;
import com.yzk.carsystem.service.VIPService;

@Service("vipService")
@Transactional
public class VipServiceImp implements VIPService {
	@Autowired
	private VipDao vipdao;

	public void setVipdao(VipDao vipdao) {
		this.vipdao = vipdao;
	}

	@Override
	public List<Vip> showallVip() {
		return vipdao.showallVip();
	}

	@Override
	public List<String> showallVipName() {
		return vipdao.showallVipName();
	}

	@Override
	public Vip selectVipByName(String name) {
		return vipdao.selectVipByName(name);
	}

}
