package com.business.customermanagement.services.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.business.customermanagement.dtos.AddressDto;
import com.business.customermanagement.entities.Address;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.business.customermanagement.converters.CustomerConverter;
import com.business.customermanagement.dtos.CustomerDto;
import com.business.customermanagement.entities.Customer;
import com.business.customermanagement.exceptions.CustomerNotFoundException;
import com.business.customermanagement.repositories.CustomerRepository;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerServiceImplTest {

	@InjectMocks
	private CustomerServiceImpl customerService;

	@Mock
	private CustomerRepository customerRepository;

	@Mock
	private CustomerConverter customerConverter;

	private Customer customer;
	private CustomerDto customerDto;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		customerDto = new CustomerDto();
		AddressDto addressDto = new AddressDto();
		customerDto.setFirstName("Santhosh");
		customerDto.setLastName("Babu");
		customerDto.setMobileNumber("9876543210");
		customerDto.setAge(22);
		customerDto.setSpendingLimit(20000d);
		customerDto.setId(3342);
		addressDto.setAddress1("abs street");
		addressDto.setAddress2("cde nagar");
		addressDto.setCity("Bangalore");
		addressDto.setState("Karnataka");
		addressDto.setType("zone 1");
		addressDto.setCountry("india");
		addressDto.setZipcode("567789");
		customerDto.setAddress(Arrays.asList(addressDto));
		customer = new Customer();
		Address address = new Address();
		customer.setFirstName("Santhosh");
		customer.setLastName("Babu");
		customer.setMobileNumber("9876543210");
		customer.setAge(22);
		customer.setSpendingLimit(20000d);
		customer.setId(3342);
		address.setAddress1("abs street");
		address.setAddress2("cde nagar");
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setType("zone 1");
		address.setCountry("india");
		address.setZipcode("567789");
		address.setId(2111);
		address.setCustomer(customer);
		//customer.setAddress(Arrays.asList(address));
		addressDto.setCustomer(customer);
	}

	@Test
	@Order(1)
	public void testAddCustomer() {
		when(customerConverter.dtoToEntity(customerDto)).thenReturn(customer);
		when(customerRepository.save(customer)).thenReturn(customer);
		when(customerConverter.entityToDto(customer)).thenReturn(customerDto);

		CustomerDto addedCustomer = customerService.addCustomer(customerDto);
		assertThat(addedCustomer.getFirstName()).isEqualTo(customer.getFirstName());

	}

	@Test
	@Order(2)
	public void testGetAllCustomersForException() {
		List<Customer> customers = new ArrayList<>();
		when(customerRepository.findAll()).thenReturn(customers);
		Throwable thrown = catchThrowable(() -> {
			customerService.getAllCustomers();
		});
		assertThat(thrown).isInstanceOf(CustomerNotFoundException.class);
	}

	@Test
	@Order(3)
	public void testGetAllCustomers() {
		List<Customer> customers = new ArrayList<>();
		customers.add(customer);
		List<CustomerDto> customerDtos = new ArrayList<>();
		customerDtos.add(customerDto);
		when(customerRepository.findAll()).thenReturn(customers);
		when(customerConverter.entityToDto(customers)).thenReturn(customerDtos);
		assertThat(customerService.getAllCustomers().size()).isEqualTo(1);
	}
	
	@Test
	@Order(4)
	public void testGetCustomerByNameWithNameAndCity() {
		List<Customer> customers = new ArrayList<>();
		customers.add(customer);
		List<CustomerDto> customerDtos = new ArrayList<>();
		customerDtos.add(customerDto);
		when(customerRepository.findByCustomerFields("Santhosh","Bangalore",null)).thenReturn(customers);
		when(customerConverter.entityToDto(customers)).thenReturn(customerDtos);
		assertThat(customerService.getByCustomerFields(Optional.of("Santhosh"), Optional.of("Bangalore"), Optional.empty()).size()).isEqualTo(1);
	}
	
	@Test
	@Order(5)
	public void testGetCustomerByNameForException() {
		List<Customer> customers = new ArrayList<>();
		when(customerRepository.findByCustomerFields("Santhosh",null,null)).thenReturn(customers);
		Throwable thrown = catchThrowable(() -> {
			customerService.getByCustomerFields(Optional.of("Santhosh"), Optional.empty(), Optional.empty());
		});
		assertThat(thrown).isInstanceOf(CustomerNotFoundException.class);
	}
}
