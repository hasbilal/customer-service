package com.exmple.demo.web;


import com.exmple.demo.dto.CustomerRequestDTO;
import com.exmple.demo.dto.CustomerResponseDTO;
import com.exmple.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path="/api")
public class CustomerRestAPI {
    private CustomerService customerService;

    @Autowired
    public CustomerRestAPI(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping(path = "/save")
    public CustomerResponseDTO saveCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){

        customerRequestDTO.setId(UUID.randomUUID().toString());
        CustomerResponseDTO customerResponseDTO = customerService.save(customerRequestDTO);

        return customerResponseDTO;
    }

    @PostMapping(path = "/update")
    public CustomerResponseDTO updateCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){

        CustomerResponseDTO customerResponseDTO = customerService.save(customerRequestDTO);

        return customerResponseDTO;
    }

    @GetMapping(path = "customers/{id}")
    public CustomerResponseDTO findCustomerById(@PathVariable String id){

        CustomerResponseDTO customerResponseDTO = customerService.getCustomer(id);

        return customerResponseDTO;
    }

    @GetMapping(path="/customers")
    public List<CustomerResponseDTO> allCustomers(){

        List<CustomerResponseDTO> customerResponseDTOList = customerService.listCustomer();

        return customerResponseDTOList;
    }

    @DeleteMapping(path = "/customers/{id}")
    public void delete(@PathVariable String id){

        customerService.deleteCustomer(id);
    }


}
