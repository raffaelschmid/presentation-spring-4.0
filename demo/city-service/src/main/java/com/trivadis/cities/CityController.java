package com.trivadis.cities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@RequestMapping("/city")
public class CityController {

	private CityService cityService;

	@Autowired
	public CityController(CityService cityService) {
		this.cityService = cityService;
	}

	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public List<City> findByName(@RequestParam("startWith") String startsWith){
		return cityService.findAllByCountryIgnoreCase(startsWith);
	}
	
	@ResponseBody
	@RequestMapping(value="/{zip}", method=RequestMethod.GET)
	public List<City> findAllByZip(@PathVariable("zip") Long zip){
		return cityService.findAllByZip(zip);
	}
}
