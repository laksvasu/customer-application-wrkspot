package com.business.customermanagement.services;

import java.util.List;
import java.util.Optional;

import com.business.customermanagement.dtos.CustomerDto;

/**
 * The Interface CustomerService.
 */
public interface CustomerService {
	
	/**
	 * Adds customer.
	 *
	 * @param customerDto - object representing customer
	 * @return the added customer with id
	 */
	CustomerDto addCustomer(CustomerDto customerDto);

	/**
	 * Gets all customers.
	 *
	 * @return the all customers
	 */
	List<CustomerDto> getAllCustomers();

	/**
	 * Gets the list of customers
	 *
	 * @param firstName - first name of the customer
	 * @param city - city of the customer
	 * @param state - state of the customer
	 * @return the list
	 */
	List<CustomerDto> getByCustomerFields(Optional<String> firstName, Optional<String> city, Optional<String> state);

}