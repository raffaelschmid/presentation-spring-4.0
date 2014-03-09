package com.trivadis.boot.city;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public List<City> getCity(@PathVariable("country") String name) {
		return this.cityService.getCity(name);
	}

	@RequestMapping(value = "city/{country}", method = { RequestMethod.POST, RequestMethod.PUT })
	@ResponseBody
	public String save(@RequestBody City city) {
		cityService.saveCity(city);
		return "success";
	}
}