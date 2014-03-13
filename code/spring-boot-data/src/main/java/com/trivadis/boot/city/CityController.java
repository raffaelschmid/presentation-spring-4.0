package com.trivadis.boot.city;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
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

	@ResponseBody
	@RolesAllowed("ROLE_USER")
	@RequestMapping("/city/{country}")
	public List<City> getCity(@PathVariable("country") String name) {
		return this.cityService.getCity(name);
	}

	@ResponseBody
	@RolesAllowed("ROLE_USER")
	@RequestMapping(value = "city/{country}", method = { RequestMethod.POST, RequestMethod.PUT })
	public String save(@RequestBody City city) {
		cityService.saveCity(city);
		return "success";
	}
}