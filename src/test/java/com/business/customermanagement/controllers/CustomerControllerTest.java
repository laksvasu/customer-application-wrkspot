package com.business.customermanagement.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.business.customermanagement.dtos.CustomerDto;
import com.business.customermanagement.services.impl.CustomerServiceImpl;

public class CustomerControllerTest {

	@Mock
	private CustomerServiceImpl customerService;

	@InjectMocks
	private CustomerController controller;

	CustomerDto customerDto;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		customerDto = new CustomerDto();
		customerDto.setFirstName("Santhosh");
		customerDto.setLastName("Babu");
	}

	@Test
	@Order(1)
	public void TestAddCustomer() {
		when(customerService.addCustomer(customerDto)).thenReturn(customerDto);
		assertThat(controller.addCustomer(customerDto).getFirstName()).isEqualTo("Santhosh");
	}

	@Test
	public void TestGetCustomersWithNoParam() {
		List<CustomerDto> customerDtos = new ArrayList<>();
		customerDtos.add(customerDto);
		when(customerService.getAllCustomers()).thenReturn(customerDtos);
		assertThat(controller.getCustomers(Optional.empty(), Optional.empty(), Optional.empty()).size()).isEqualTo(1);
	}

	@Test
	public void TestGetCustomersWithFirstName() {
		List<CustomerDto> customerDtos = new ArrayList<>();
		customerDtos.add(customerDto);
		when(customerService.getByCustomerFields(Optional.of("Santhosh"), Optional.empty(),Optional.empty())).thenReturn(customerDtos);
		assertThat(controller.getCustomers(Optional.of("Santhosh"), Optional.empty(),Optional.empty()).size()).isEqualTo(1);
	}

	@Test
	public void TestGetCustomersWithCity() {
		List<CustomerDto> customerDtos = new ArrayList<>();
		customerDtos.add(customerDto);
		when(customerService.getByCustomerFields(Optional.empty(), Optional.of("Bangalore"), Optional.empty())).thenReturn(customerDtos);
		assertThat(controller.getCustomers(Optional.empty(), Optional.of("Bangalore"), Optional.empty()).size()).isEqualTo(1);
	}

	@Test
	public void TestGetCustomersWithState() {
		List<CustomerDto> customerDtos = new ArrayList<>();
		customerDtos.add(customerDto);
		when(customerService.getByCustomerFields(Optional.empty(), Optional.empty(), Optional.of("Karnataka"))).thenReturn(customerDtos);
		assertThat(controller.getCustomers(Optional.empty(), Optional.empty(), Optional.of("Karnataka")).size()).isEqualTo(1);
	}

	@Test
	public void TestGetCustomersWithNameAndCity() {
		List<CustomerDto> customerDtos = new ArrayList<>();
		customerDtos.add(customerDto);
		when(customerService.getByCustomerFields(Optional.of("Santhosh"), Optional.of("Bangalore"), Optional.empty())).thenReturn(customerDtos);
		assertThat(controller.getCustomers(Optional.of("Santhosh"), Optional.of("Bangalore"), Optional.empty()).size()).isEqualTo(1);
	}

	@Test
	public void TestGetCustomersWithNameAndState() {
		List<CustomerDto> customerDtos = new ArrayList<>();
		customerDtos.add(customerDto);
		when(customerService.getByCustomerFields(Optional.of("Santhosh"), Optional.empty(), Optional.of("Karnataka"))).thenReturn(customerDtos);
		assertThat(controller.getCustomers(Optional.of("Santhosh"), Optional.empty(), Optional.of("Karnataka")).size()).isEqualTo(1);
	}

}
