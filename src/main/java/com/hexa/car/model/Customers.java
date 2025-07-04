package com.hexa.car.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int customerId;

	    private String firstName;
	    private String lastName;
	    private String email;
	    private String username;
	    private String password;
	    private String phoneNumber;
}
