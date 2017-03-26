package com.yzk.carsystem.util;

import java.util.List;
import java.util.Set;

import com.yzk.carsystem.model.Module_functions;

public class Settolist {
	public static List<Module_functions> settolist(Set<Module_functions> set, List<Module_functions> list) {
		for (Module_functions functions : set) {
			list.add(functions);
		}
		return list;
	}
}
