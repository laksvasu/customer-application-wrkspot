package com.business.customermanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.business.customermanagement.entities.Customer;

/**
 * The Interface CustomerRepository.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	/**
	 * Find by first name ignore case,city and state ignore case.
	 *
	 * @param firstName represents firstName
	 * @param city represents city
	 * @param state represents state
	 * @return the list
	 */
	@Query("SELECT c FROM Customer c JOIN c.address a WHERE (:firstName is null or c.firstName = :firstName) AND (:city is null or a.city = :city) AND (:state is null or a.state = :state)")
	List<Customer> findByCustomerFields(String firstName, String city, String state);

}
