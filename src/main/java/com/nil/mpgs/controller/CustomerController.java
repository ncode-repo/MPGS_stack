package com.nil.mpgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nil.mpgs.cache.CustomerCache;
import com.nil.mpgs.model.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerCache customerCache;
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Customer> getCustomer(@PathVariable String id){
		System.out.println("RestController..");
        long start = System.currentTimeMillis();
        Customer customer = customerCache.getCustomer(id);
        long end = System.currentTimeMillis();
        System.out.println("Took : " + ((end - start) / 1000+" sec."));
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	@PutMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer cust){
		if(cust != null){
			customerCache.updateCustomer(cust);
		}
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Void> deleteCustomer(@PathVariable String id){
		customerCache.deleteCustomer(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
}
