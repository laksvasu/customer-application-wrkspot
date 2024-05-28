package com.business.customermanagement.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.customermanagement.constants.ErrorConstant;
import com.business.customermanagement.converters.CustomerConverter;
import com.business.customermanagement.dtos.CustomerDto;
import com.business.customermanagement.entities.Customer;
import com.business.customermanagement.exceptions.CustomerNotFoundException;
import com.business.customermanagement.repositories.CustomerRepository;
import com.business.customermanagement.services.CustomerService;

/**
 * The Class CustomerServiceImpl - includes all business logic
 * required to perform operations on customer resource
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private CustomerConverter customerConverter;

	/**
	 * Adds customer.
	 *
	 * @param customerDto - object representing customer
	 * @return the added customer with id
	 */
	@Override
	public CustomerDto addCustomer(CustomerDto customerDto) {
		try {
			Customer customer = customerConverter.dtoToEntity(customerDto);
			return customerConverter.entityToDto(customerRepo.save(customer));
		}catch (Exception ex){
			System.out.println(ex);
		}
		return null;
	}

	/**
	 * Gets all customers.
	 *
	 * @return the all customers
	 */
	@Override
	public List<CustomerDto> getAllCustomers() {
		List<Customer> customers = customerRepo.findAll();
		if (customers.isEmpty()) {
			throw new CustomerNotFoundException(ErrorConstant.CUSTOMERS_NOT_FOUND);
		} else {
			return customerConverter.entityToDto(customers);
		}
	}

	/**
	 * Gets the list of customers
	 * 
	 * @param firstName - first name of the customer
	 * @param city - city of the customer
	 * @param state - state of the customer
	 * @return the list
	 */
	@Override
	public List<CustomerDto> getByCustomerFields(Optional<String> firstName, Optional<String> city, Optional<String> state) {
		List<Customer> customers = customerRepo.findByCustomerFields(firstName.orElse(null), city.orElse(null), state.orElse(null));
		if (customers.isEmpty()) {
			throw new CustomerNotFoundException(ErrorConstant.CUSTOMERS_NOT_FOUND);
		}

		return customerConverter.entityToDto(customers);
	}

}
