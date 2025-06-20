package com.hexa.car.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hexa.car.exception.ResourceNotFoundException;
import com.hexa.car.model.Vehicles;
import com.hexa.car.service.VehicleService;

@RestController
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@PostMapping(value="/addVehicle")
	public String addVehicle(@RequestBody Vehicles vehicles) {
		return vehicleService.addVehicle(vehicles);
	}
	
	@GetMapping(value="/showAllVehicles")
	public List<Vehicles>showAllVehiclesInfo(){
		return vehicleService.showAllVehiclesInfo();
	}
	
	@GetMapping(value="/searchById/{vehicleId}")
	public ResponseEntity<Vehicles>searchById(@PathVariable int vehicleId) throws ResourceNotFoundException{
		return vehicleService.searchById(vehicleId);
		
	}
	
	@GetMapping(value="/searchByVehicleType/{type}")
	public List<Vehicles> searchByVehicleType(@PathVariable String type){
		return vehicleService.searchByVehicleType(type);
	}
	
	@GetMapping(value="/searchByTypeAndModel/{type}/{model}")	
	public List<Vehicles> searchByTypeAndModel(@PathVariable String type,@PathVariable String model){
		return vehicleService.searchByTypeAndModel(type, model);
		
	}
	@DeleteMapping(value = "/deleteVehicle/{vehicleId}")
	public String deleteVehicle(@PathVariable int vehicleId) throws ResourceNotFoundException {
		return vehicleService.deleteVehicle(vehicleId);
		
	}
}
