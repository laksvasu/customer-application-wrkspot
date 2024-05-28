package com.business.customermanagement.converters;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.business.customermanagement.dtos.AddressDto;
import com.business.customermanagement.entities.Address;
import org.springframework.stereotype.Component;

import com.business.customermanagement.constants.ErrorConstant;
import com.business.customermanagement.dtos.CustomerDto;
import com.business.customermanagement.entities.Customer;
import com.business.customermanagement.exceptions.CustomerNotFoundException;

/**
 * The Class CustomerConverter - has methods to convert DTO to entity and vice versa
 */
@Component
public class CustomerConverter {
	
	/**
	 * Converts Entity to Dto.
	 *
	 * @param customer - customer fetched from database
	 * @return the customer - dto
	 */
	public CustomerDto entityToDto(Customer customer) {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setId(customer.getId());
		customerDto.setFirstName(customer.getFirstName());
		customerDto.setLastName(customer.getLastName());
		customerDto.setAge(customer.getAge());
		customerDto.setSpendingLimit(customer.getSpendingLimit());
		customerDto.setMobileNumber(customer.getMobileNumber());
		List<AddressDto> addressesDto = getAddressDtos(customer);
		customerDto.setAddress(addressesDto);
		return customerDto;
	}

	private static List<AddressDto> getAddressDtos(Customer customer) {
		List<AddressDto> addressesDto = new ArrayList<>();
		for (Address address : customer.getAddress()) {
			AddressDto addressDto = new AddressDto();
			addressDto.setAddress1(address.getAddress1());
			addressDto.setAddress2(address.getAddress2());
			addressDto.setType(address.getType());
			addressDto.setCity(address.getCity());
			addressDto.setState(address.getState());
			addressDto.setCountry(address.getCountry());
			addressDto.setZipcode(address.getZipcode());
			addressesDto.add(addressDto);
		}
		return addressesDto;
	}

	/**
	 * Converts list of entities to list of dtos.
	 *
	 * @param customers - list of customers fetched from database
	 * @return the list
	 */
	public List<CustomerDto> entityToDto(List<Customer> customers) {
		if(customers.isEmpty()) {
			throw new CustomerNotFoundException(ErrorConstant.CUSTOMERS_NOT_FOUND);
		}
		return customers.stream().map(this::entityToDto).collect(Collectors.toList());
	}
	
	/**
	 * Converts dto to entity.
	 *
	 * @param customerDto - customer to be converted to entity
	 * @return the customer - Entity
	 */
	public Customer dtoToEntity(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setAge(customerDto.getAge());
		customer.setSpendingLimit(customerDto.getSpendingLimit());
		customer.setMobileNumber(customerDto.getMobileNumber());
		List<AddressDto> addressDtos = customerDto.getAddress();
		List<Address> addresses = new ArrayList<>();
		for(AddressDto addressDto : addressDtos){
			Address address = new Address();
			address.setAddress1(addressDto.getAddress1());
			address.setAddress2(addressDto.getAddress2());
			address.setType(addressDto.getType());
			address.setCustomer(addressDto.getCustomer());
			address.setCountry(addressDto.getCountry());
			address.setState(addressDto.getState());
			address.setZipcode(addressDto.getZipcode());
			address.setCity(addressDto.getCity());
			address.setCustomer(customer);
			addresses.add(address);
		}
		customer.setAddress(addresses);
		return customer;
	}
	
	/**
	 * Converts list of dto to list of entities.
	 *
	 * @param customerDtos - list of customers to be converted to entities
	 * @return the list of entities
	 */
	public List<Customer> dtoToEntity(List<CustomerDto> customerDtos) {
		return customerDtos.stream().map(this::dtoToEntity).collect(Collectors.toList());
	}
}
