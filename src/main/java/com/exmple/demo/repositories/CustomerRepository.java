package com.exmple.demo.repositories;

import com.exmple.demo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {

}
