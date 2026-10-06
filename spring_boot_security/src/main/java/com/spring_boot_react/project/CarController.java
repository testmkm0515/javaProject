package com.spring_boot_react.project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot_react.project.domain.Car;
import com.spring_boot_react.project.domain.CarRepository;

@RestController
public class CarController {
	private final CarRepository repository;

	public CarController(CarRepository repository) {
		this.repository = repository;
	}
	
//	@GetMapping("/")
//	public String index() {
//		return "Home";
//	}

	@GetMapping("/cars")
	public Iterable<Car> getCars() {
		return repository.findAll();
	}
}
