package com.factory.car.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.car.bean.Car;
import com.factory.car.constants.Constants;

import lombok.Data;

@Service
@Data
public class CarFactoryService {
	
    private static final Map<String, Car> carCache = new HashMap<>();
	
	@Autowired
	private List<Car> cars;

	@PostConstruct
    public void initMyServiceCache() {
		cars.forEach(c->carCache.put(c.getType(), c));
    }
	
	public Car getCar(String type) {
		return carCache.getOrDefault(type.toLowerCase(), carCache.get(Constants.UNIDENTIFIED));
    }

}
