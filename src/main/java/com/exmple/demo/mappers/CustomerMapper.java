package com.exmple.demo.mappers;

import com.exmple.demo.dto.CustomerRequestDTO;
import com.exmple.demo.dto.CustomerResponseDTO;
import com.exmple.demo.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    public CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    public Customer  customerRequestDTOToCustomer(CustomerRequestDTO customerRequestDTO);

}
