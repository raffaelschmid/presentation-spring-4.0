package com.trivadis.boot.city;

import java.util.List;

public interface CityService {

	List<City> getCity(String name);

	void saveCity(City city);

}
