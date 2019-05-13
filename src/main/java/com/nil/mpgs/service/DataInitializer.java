package com.nil.mpgs.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nil.mpgs.model.Customer;
import com.nil.mpgs.repository.CustomerRepository;

@Component
public class DataInitializer {

	@Autowired
	private static CustomerRepository repository;

	static {
		repository.save(createCustomers());
	}

	private static List<Customer> createCustomers() {
		return Arrays.asList(new Customer("1", "Sales", "Sales"), new Customer("2", "Sales", "Sales"),
				new Customer("3", "IT", "Sales"), new Customer("4", "Sales", "Sales"),
				new Customer("5", "Sales", "Sales"), new Customer("6", "IT", "Sales"));
	}
}
