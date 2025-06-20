package com.hexa.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexa.car.model.Customers;


@Repository
public interface CustomerRepository extends JpaRepository<Customers,Integer>{

	Customers findByUsername(String username);
	Customers  findByUsernameAndPassword(String username, String password);
}
