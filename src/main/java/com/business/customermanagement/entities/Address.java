package com.business.customermanagement.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * Represents Address entity.
 */
@Entity
@Data
@Table(name = "address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "address1 is mandatory")
	@Column(name = "address1")
	private String address1;

	@NotBlank(message = "address2 is mandatory")
	@Column(name = "address2")
	private String address2;
	
	@NotBlank(message = "House number is mandatory")
	@Column(name = "house_number")
	private String type;
	
	@NotBlank(message = "City name is mandatory")
	@Column(name = "city")
	private String city;
	
	@NotBlank(message = "State name is mandatory")
	@Column(name = "state")
	private String state;
	
	@NotBlank(message = "Country is mandatory")
	@Column(name = "country")
	private String country;
	
	@NotBlank(message = "zipcode is mandatory")
	@Column(name = "zipcode")
	private String zipcode;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;
}
