package com.nil.mpgs.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.nil.mpgs.model.Customer;
import com.nil.mpgs.repository.CustomerRepository;

@Component
@CacheConfig(cacheNames = { "customers" })
public class CustomerCache {

	@Autowired
	CustomerRepository customerRepository;

	@Cacheable(key = "#id")
	public Customer getOnCache(String id) {
		System.out.println("### Backend processing...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
		}
		return customerRepository.findOne(id);
	}

	@CachePut(key = "#id")
	public Customer putOnCache(String firstName, String id) {
		Customer customer = customerRepository.findOne(id);
		customer.setFirstName(firstName);
		return customerRepository.save(customer);
	}

	@CacheEvict(key = "#id")
	public void evict(String id) {
	}

	@Cacheable(key = "#id")
	public Customer getCustomer(String id) {
		return customerRepository.findOne(id);
	}

	@Cacheable(key = "#id")
	public Customer updateCustomer(Customer cust) {
		return customerRepository.save(cust);
		
	}
	@CacheEvict(key = "#id")
	public void deleteCustomer(String id) {
		customerRepository.delete(id);
	}
}
