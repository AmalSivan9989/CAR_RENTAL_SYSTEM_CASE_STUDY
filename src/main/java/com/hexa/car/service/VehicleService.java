package com.hexa.car.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hexa.car.exception.ResourceNotFoundException;
import com.hexa.car.model.VehicleType;
import com.hexa.car.model.Vehicles;
import com.hexa.car.repository.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	
	public String addVehicle(Vehicles vehicle) {
		vehicleRepository.save(vehicle);
		return "Vehicle Record Inserted Successfully...";
	}
	
	public List<Vehicles>showAllVehiclesInfo(){
		return vehicleRepository.findAll();
	}
	
	 public ResponseEntity<Vehicles> searchById(int vehicleId) throws ResourceNotFoundException{
		 Vehicles vehicle= vehicleRepository.findById(vehicleId).
				 orElseThrow(()-> new ResourceNotFoundException("Vehicle with Id:"+vehicleId+" Data not found..."));
		 return new ResponseEntity<>(vehicle,HttpStatus.OK);
	 }
	 
	 public List<Vehicles> searchByVehicleType(String type){
			VehicleType vehicleType = VehicleType.valueOf(type.toUpperCase());
		 return vehicleRepository.findByVehicleType(vehicleType);
		 
	 }
	
	public List<Vehicles> searchByTypeAndModel(String type,String model){
		VehicleType vehicleType = VehicleType.valueOf(type.toUpperCase());
		return vehicleRepository.findByVehicleTypeAndModel(vehicleType, model);
	}
	
	public String deleteVehicle(int vehicleId) throws ResourceNotFoundException{
		Vehicles vehicle=vehicleRepository.findById(vehicleId).orElseThrow(()->new ResourceNotFoundException("Vehicle with Id:"+vehicleId+" Data not found..."));
		vehicleRepository.delete(vehicle);
		return "Vehicle deleted Successfully...";
	}
	 
	 
}
