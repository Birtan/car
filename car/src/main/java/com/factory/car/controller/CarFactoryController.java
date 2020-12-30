package com.factory.car.controller;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.factory.car.bean.Car;
import com.factory.car.service.CarFactoryService;

@RestController
public class CarFactoryController {
	
	@Autowired
	private CarFactoryService carFactoryService;
	

	@GetMapping("/car")
	public String getCar(@RequestParam final String input) {
		Car carForGivenInput = carFactoryService.getCar(input);
		return MessageFormat.format("{0} Car has produced", carForGivenInput.getType());
		
	}

}
