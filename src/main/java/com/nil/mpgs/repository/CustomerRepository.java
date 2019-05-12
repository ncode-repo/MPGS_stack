package com.nil.mpgs.repository;

import org.springframework.data.repository.CrudRepository;

import com.nil.mpgs.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String>{

}
