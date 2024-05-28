package com.business.customermanagement.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.business.customermanagement.dtos.CustomerDto;
import com.business.customermanagement.services.CustomerService;

import io.swagger.annotations.ApiParam;

/**
 * The Class CustomerController - Rest Controller where services are exposed 
 * to perform operations on customer resource
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	/**
	 * Adds the customer
	 * 
	 * @param customer the customer who needs to be added
	 * @return customer with its newly generated id
	 */
	@PostMapping
	public CustomerDto addCustomer(@RequestBody CustomerDto customer) {
		return customerService.addCustomer(customer);
	}

	/**
	 * Gets the customers
	 *
	 * @param firstName - the first name of the customer
	 * @param city - the city of the customer
	 * @param state - the state of the customer
	 * @return the list of customers matching with given criteria if any exists,else fetches all the customers
	 */
	@GetMapping
	public List<CustomerDto> getCustomers(@RequestParam(name = "fname") @ApiParam(value = "firstname") Optional<String> firstName,@RequestParam(name = "city") @ApiParam(value = "city") Optional<String> city,@RequestParam(name = "state") @ApiParam(value = "state") Optional<String> state) {
		if(!firstName.isPresent() && !city.isPresent() && !state.isPresent()) {
			return customerService.getAllCustomers();
		} else {
			return customerService.getByCustomerFields(firstName, city, state);
		}
	}
}
