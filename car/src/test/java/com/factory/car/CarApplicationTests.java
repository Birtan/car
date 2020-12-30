package com.factory.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import com.factory.car.constants.Constants;
import com.factory.car.controller.CarFactoryController;
import com.factory.car.service.CarFactoryService;

@SpringBootTest
class CarApplicationTests {
	
	@Autowired
	CarFactoryService carFactoryService;
	
	@Autowired
	CarFactoryController carFactoryController;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(carFactoryController).isNotNull();
	}

	@Test
	void carsLoadTest() {
		assertThat(!CollectionUtils.isEmpty(carFactoryService.getCars()));
	}
	
	@Test
	void returnTypeMustBeCabrio() {
		assertThat(carFactoryService.getCar(Constants.CABRIO).getType().equals(Constants.CABRIO));
	}
	
	@Test
	void returnTypeMustBeSedan() {
		assertThat(carFactoryService.getCar(Constants.SEDAN).getType().equals(Constants.SEDAN));
	}
	
	@Test
	void returnTypeMustBeHatchBack() {
		assertThat(carFactoryService.getCar(Constants.HATCHBACK).getType().equals(Constants.HATCHBACK));
	}

}
