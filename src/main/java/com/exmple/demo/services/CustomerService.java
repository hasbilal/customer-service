package com.exmple.demo.services;

import com.exmple.demo.dto.CustomerRequestDTO;
import com.exmple.demo.dto.CustomerResponseDTO;


import java.util.List;

public interface CustomerService {

    CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO getCustomer(String id);
    CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
    List<CustomerResponseDTO> listCustomer();
    void deleteCustomer(String id);
}
