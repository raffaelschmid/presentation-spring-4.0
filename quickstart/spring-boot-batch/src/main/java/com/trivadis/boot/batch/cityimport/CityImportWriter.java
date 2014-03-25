package com.trivadis.boot.batch.cityimport;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.trivadis.boot.batch.City;

public class CityImportWriter implements ItemWriter<City> {

	private static final String SQL_INSERT = "INSERT INTO CITY (COUNTRY_CODE, CITY_NAME) VALUES (?,?)";

	private final JdbcTemplate jdbc;

	public CityImportWriter(JdbcTemplate jdbcTemplate) {
		this.jdbc = jdbcTemplate;
	}

	public void write(List<? extends City> items) throws Exception {
		for (City o : items) {
			jdbc.update(SQL_INSERT, o.getCountryCode(), o.getCityName());
		}
	}
}
