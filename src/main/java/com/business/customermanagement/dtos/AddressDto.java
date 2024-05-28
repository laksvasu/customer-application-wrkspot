package com.business.customermanagement.dtos;

import com.business.customermanagement.entities.Customer;
import lombok.Data;

/**
 * Represents a address dto.
 */
@Data
public class AddressDto {
    private String address1;
    private String address2;
    private String type;
    private String city;
    private String state;
    private String country;
    private String zipcode;
    private Customer customer;
}
