package com.trivadis.cities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityService {
	
	private CityRepository cityRepository;

	@Autowired
	public CityService(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}
	

	List<City> findAllByCountryIgnoreCase(String name){
		return cityRepository.findAllByNameStartsWith(name);
	}

}
