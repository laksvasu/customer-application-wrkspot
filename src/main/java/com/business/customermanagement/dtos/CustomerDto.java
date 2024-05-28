package com.business.customermanagement.dtos;

import lombok.Data;
import java.util.List;

/**
 * Represents a customer dto.
 */
@Data
public class CustomerDto {

	private Integer id;

	private String firstName;
	
	private String lastName;

	private int age;

	private Double spendingLimit;

	private String mobileNumber;
	
	private List<AddressDto> address;
}
