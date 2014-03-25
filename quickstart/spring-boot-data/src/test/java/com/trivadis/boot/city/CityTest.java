package com.trivadis.boot.city;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.trivadis.boot.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class CityTest {

	@Autowired
	private CityRepository cityRepository;

	@Test
	public void testMapping() {
		// when
		City retVal = cityRepository.findOne(1l);

		// then
		assertNotNull(retVal);
	}

}
