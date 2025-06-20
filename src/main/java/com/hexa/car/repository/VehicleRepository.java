package com.hexa.car.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexa.car.model.VehicleType;
import com.hexa.car.model.Vehicles;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicles,Integer>{
  
	List<Vehicles> findByVehicleType(VehicleType vehicleType);
    List<Vehicles> findByVehicleTypeAndModel(VehicleType vehicleType, String model);
    
}
