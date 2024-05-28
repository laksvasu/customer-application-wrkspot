package com.business.customermanagement.dtos;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.business.customermanagement.entities.Address;

import java.util.ArrayList;
import java.util.List;

public class CustomerDtoTest {
	
	CustomerDto customerDto;
	
	@BeforeEach
	public void setUp() {
		customerDto = new CustomerDto();
	}
	
	@Test
	public void testGetId() {
		Integer id = 1;
		customerDto.setId(id);
        assertThat(id).isEqualTo(customerDto.getId());
	}
	
	@Test
	public void testGetFirstName() {
		String firstName = "Santhosh";
		customerDto.setFirstName(firstName);
		assertThat(firstName).isEqualTo(customerDto.getFirstName());
	}

	@Test
	public void testGetLastName() {
		String lastName = "Raghav";
		customerDto.setLastName(lastName);
		assertThat(lastName).isEqualTo(customerDto.getLastName());
	}
	@Test
	public void testGetAge() {
		int age = 50;
		customerDto.setAge(age);
        assertThat(age).isEqualTo(customerDto.getAge());
	}

	@Test
	public void testGetSpendingLimit() {
		Double spendingLimit = 50000d;
		customerDto.setSpendingLimit(spendingLimit);
		assertThat(spendingLimit).isEqualTo(customerDto.getSpendingLimit());
	}

	@Test
	public void testGetMobileNumber() {
		String mobileNumber = "9876543210";
		customerDto.setMobileNumber(mobileNumber);
		assertThat(mobileNumber).isEqualTo(customerDto.getMobileNumber());
	}

	@Test
	public void testGetAddress() {
		AddressDto addressDto = new AddressDto();
		addressDto.setCity("Bangalore");
		List<AddressDto> addresses = new ArrayList<>();
		addresses.add(addressDto);
		customerDto.setAddress(addresses);
		assertThat("Bangalore").isEqualTo(customerDto.getAddress().get(0).getCity());
	}
}
