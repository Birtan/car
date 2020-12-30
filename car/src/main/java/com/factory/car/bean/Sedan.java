package com.factory.car.bean;

import org.springframework.stereotype.Component;

import com.factory.car.constants.Constants;

@Component
public class Sedan implements Car {

	@Override
	public String getType() {
		return Constants.SEDAN;
	}

}
