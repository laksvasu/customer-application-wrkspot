package com.business.customermanagement.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import lombok.Data;

/**
 * Represents a Customer entity.
 */
@Entity
@Data
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "Firstname is mandatory")
	@Column(name = "first_name")
	private String firstName;

	@NotBlank(message = "Lastname is mandatory")
	@Column(name = "last_name")
	private String lastName;

	@Positive(message = "Age should be greater than 0")
	@Column(name = "age")
	private int age;

	@Positive(message = "Spending Limit should be greater than 0")
	@Column(name = "spending_limit")
	private Double spendingLimit;

	@NotBlank(message = "Mobile Number is mandatory")
	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "address")
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL,  orphanRemoval = true)
	private List<Address> address = new ArrayList<>();

}
