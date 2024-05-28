package com.business.customermanagement.converters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.business.customermanagement.dtos.CustomerDto;
import com.business.customermanagement.entities.Customer;
import com.business.customermanagement.exceptions.CustomerNotFoundException;

public class CustomerConverterTest {

	@InjectMocks
	private CustomerConverter customerConverter;
	private Customer customer;
	private CustomerDto customerDto;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		customer = new Customer();
		customer.setFirstName("Santhosh");
		customer.setLastName("Babu");
		customer.setMobileNumber("9876543210");
		customer.setAge(22);
		customer.setSpendingLimit(20000d);
		customer.setId(2221);
		customer.setAddress(new ArrayList<>());
		customerDto = new CustomerDto();
		customerDto.setFirstName("Dinesh");
		customerDto.setLastName("Babu");
		customerDto.setLastName("Babu");
		customerDto.setMobileNumber("9876543210");
		customerDto.setAge(22);
		customerDto.setSpendingLimit(20000d);
		customerDto.setId(2221);
		customerDto.setAddress(new ArrayList<>());
	}

	@Test
	public void testEntityToDto() {
        assertThat(customerConverter.entityToDto(customer).getFirstName()).isEqualTo("Santhosh");
	}

	@Test
	public void testEntityToDtoForList() {
       List<Customer> customers = new ArrayList<>();
       customers.add(customer);
       assertThat(customerConverter.entityToDto(customers).size()).isEqualTo(1);
	}
	
	@Test
	public void testEntityToDtoForEmptyList() {
       List<Customer> customers = new ArrayList<>();
       Throwable thrown = catchThrowable(() -> {
    	   customerConverter.entityToDto(customers);
    	});
       assertThat(thrown).isInstanceOf(CustomerNotFoundException.class);
	}

	@Test
	public void testDtoToEntity() {
		assertThat(customerConverter.dtoToEntity(customerDto).getFirstName()).isEqualTo("Dinesh");
	}

	@Test
	public void testDtoToEntityForList() {
		List<CustomerDto> customerDtos = new ArrayList<>();
		customerDtos.add(customerDto);
	    assertThat(customerConverter.dtoToEntity(customerDtos).size()).isEqualTo(1);
	}

}
