package com.trivadis.cities;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityService {
	
	private CityRepository cityRepository;

	@Autowired
	public CityService(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}
	

//	@RolesAllowed("ROLE_USER")
	List<City> findAllByCountryIgnoreCase(String name){
		return cityRepository.findAllByNameStartsWith(name);
	}

//	@RolesAllowed("ROLE_USER")
	public List<City> findAllByZip(Long zip) {
		return cityRepository.findAllByZip(zip);
	}

}
