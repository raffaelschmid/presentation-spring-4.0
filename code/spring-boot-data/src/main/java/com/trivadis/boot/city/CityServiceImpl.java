package com.trivadis.boot.city;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@Transactional
public class CityServiceImpl implements CityService {

	private CityRepository cityRepository;

	@Autowired
	public CityServiceImpl(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Override
	public List<City> getCity(String countryName) {
		Assert.notNull(countryName, "Name must not be null");
		return this.cityRepository.findAllByCountryIgnoreCase(countryName);
	}

	@Override
	public void saveCity(City city) {
		Assert.notNull(city, "Attempt to save null value");
		cityRepository.save(city);
	}
}
