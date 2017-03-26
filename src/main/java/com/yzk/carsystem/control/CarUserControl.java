package com.yzk.carsystem.control;

/*
		                _ooOoo_
		               o8888888o
		               88" . "88
		               (| -_- |)
		               O\  =  /O
					____/`---'\____
					.'  \\|     |//  `.
				/  \\|||  :  |||//  \
				/  _||||| -:- |||||-  \
				|   | \\\  -  /// |   |
				| \_|  ''\---/''  |   |
				\  .-\__  `-`  ___/-. /
			   ___`. .'  /--.--\  `. . __
			."" '<  `.___\_<|>_/___.'  >'"".
		   | | :  `- \`.;`\ _ /`;.`/ - ` : | |
			\  \ `-.   \_ __\ /__ _/   .-` /  /
	   ======`-.____`-.___\_____/___.-`____.-'======
				          `=---='
	^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
				佛祖保佑       永无BUG
				*/
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yzk.carsystem.model.CarMaster;
import com.yzk.carsystem.service.CarUserService;
import com.yzk.carsystem.service.VIPService;
import com.yzk.carsystem.util.Pager;

@Controller
@RequestMapping("/carcontrol")
public class CarUserControl {
	private int mCurrentPager = 1; // 当前页
	@Autowired
	private CarUserService caruserService;
	@Autowired
	private VIPService vipService;

	public void setCarUserService(CarUserService caruserService) {
		this.caruserService = caruserService;
	}

	@RequestMapping("/main")
	public String main(Map<String, Object> map) {
		map.put("list", vipService.showallVipName());
		return "addcaruser";
	}

	@RequestMapping("/showcar")
	public String showallcar(Integer page, Map<String, Object> map) {
		if (page != null && page > 0) {
			mCurrentPager = page;
		}
		Pager pager = new Pager(caruserService.getTotalCount(), mCurrentPager);
		pager.setUrl("http://localhost:8080/Permissions/carcontrol/showcar.spring");
		map.put("url", pager.getPageStr());
		List<CarMaster> carLists = caruserService.showPageUser(pager);
		map.put("list", carLists);
		return "showallcaruser";
	}

	@RequestMapping("/addcaruser")
	public String addcaruser(CarMaster carMaster, String level, Map<String, Object> map) {
		System.out.println("<><><><><><><><><><><>><" + level);
		if (caruserService.selectCarUserByName(carMaster.getName()) != null) {
			map.put("error", "客户存在");
			return "addcaruser";
		}
		caruserService.AddUser(carMaster, level);
		return "redirect:/carcontrol/showcar.spring";
	}

	@RequestMapping("/deletecar")
	public String deletecar(@RequestParam("id") Integer id, Map<String, Object> map) {
		caruserService.deleteCarUser(id);
		return "redirect:/carcontrol/showcar.spring";

	}

	@RequestMapping("/selectcar")
	public String selectcar(@RequestParam("id") Integer id, Map<String, Object> map) {
		CarMaster carMaster = caruserService.selectCarUser(id);
		List<String> vipNmaelist = vipService.showallVipName();
		map.put("carMaster", carMaster);
		map.put("vipNmaelist", vipNmaelist);
		return "updateCarUser";
	}

	@RequestMapping("/selectcarbytype")
	public String selectcarByType(@RequestParam("type") String type, @RequestParam("value") String value,
			Map<String, Object> map) {
		String identifier = null;
		CarMaster carMaster = caruserService.selectCarUserByType(type, value);
		if (carMaster == null) {
			identifier = "identifier";
		}
		map.put("identifier", identifier);
		map.put("carmaster", carMaster);
		return "selectshowcar";
	}

	@RequestMapping("/updatecar")
	public String updatecar(CarMaster carMaster, String level, Map<String, Object> map) {
		carMaster.setVip(vipService.selectVipByName(level));
		caruserService.updateCarUser(carMaster, carMaster.getId());
		return "redirect:/carcontrol/showcar.spring";
	}

}
