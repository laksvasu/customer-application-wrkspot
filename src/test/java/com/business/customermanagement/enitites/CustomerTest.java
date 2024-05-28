package com.business.customermanagement.enitites;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.business.customermanagement.entities.Address;
import com.business.customermanagement.entities.Customer;

public class CustomerTest {
	
	Customer customer;

	@BeforeEach
	public void setUp() {
		customer = new Customer();
	}
	
	@Test
	public void testGetId() {
		Integer id = 1;
		customer.setId(id);
        assertThat(id).isEqualTo(customer.getId());
	}
	
	@Test
	public void testGetFirstName() {
		String firstName = "Santhosh";
		customer.setFirstName(firstName);
		assertThat(firstName).isEqualTo(customer.getFirstName());
	}

	@Test
	public void testGetLastName() {
		String lastName = "Raghav";
		customer.setLastName(lastName);
		assertThat(lastName).isEqualTo(customer.getLastName());
	}

	@Test
	public void testGetMobileNumber() {
		String mobileNumber = "9876543210";
		customer.setMobileNumber(mobileNumber);
		assertThat(mobileNumber).isEqualTo(customer.getMobileNumber());
	}


	@Test
	public void testSpendingLimit() {
		Double spendingLimit = 30000d;
		customer.setSpendingLimit(spendingLimit);
		assertThat(spendingLimit).isEqualTo(customer.getSpendingLimit());
	}

	@Test
	public void testGetAge() {
		int age = 50;
		customer.setAge(age);
        assertThat(age).isEqualTo(customer.getAge());
	}
	@Test
	public void testGetAddress() {
		Address address = new Address();
		address.setCity("Bangalore");
		List<Address> addresses = new ArrayList<>();
		addresses.add(address);
		customer.setAddress(addresses);
		assertThat("Bangalore").isEqualTo(customer.getAddress().get(0).getCity());
	}
}
