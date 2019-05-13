package com.nil.mpgs.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nil.mpgs.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String>{

}
