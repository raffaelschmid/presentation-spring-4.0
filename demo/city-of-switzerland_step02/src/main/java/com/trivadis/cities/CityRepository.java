package com.trivadis.cities;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long>{
	
	List<City> findAllByNameStartsWith(String name);

}
