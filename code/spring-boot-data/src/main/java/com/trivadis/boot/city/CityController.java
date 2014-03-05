package com.trivadis.boot.city;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CityController {

	private CityService cityService;
	
	@Autowired
	public CityController(CityService cityService) {
		this.cityService = cityService;
	}

	@RequestMapping("/city/{country}")
	@ResponseBody
	@Transactional(readOnly = true)
	public List<City> getCity(@PathVariable("country")String name) {
		return this.cityService.getCity(name);
	}
}