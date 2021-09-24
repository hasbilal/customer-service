package com.exmple.demo.services;

import com.exmple.demo.dto.CustomerRequestDTO;
import com.exmple.demo.dto.CustomerResponseDTO;
import com.exmple.demo.entities.Customer;
import com.exmple.demo.mappers.CustomerMapper;
import com.exmple.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerserviceImpl implements CustomerService {


    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    @Autowired
    public CustomerserviceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper){
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {


        Customer saveCustomer = customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
        customerRepository.save(saveCustomer);

        CustomerResponseDTO customerResponseDTO = customerMapper.customerToCustomerResponseDTO(saveCustomer);

        return customerResponseDTO;
    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {

        Customer customer = customerRepository.findById(id).get();

        CustomerResponseDTO customerResponseDTO = customerMapper.customerToCustomerResponseDTO(customer);

        return customerResponseDTO;
    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {

        Customer customer = customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
        Customer updatedCustomer = customerRepository.save(customer);

        CustomerResponseDTO customerResponseDTO = customerMapper.customerToCustomerResponseDTO(updatedCustomer);

        return customerResponseDTO;
    }

    @Override
    public List<CustomerResponseDTO> listCustomer() {

        List<Customer> customerList = customerRepository.findAll();
        List<CustomerResponseDTO> customerResponseDTOList = customerList.stream()
                .map(customer ->customerMapper.customerToCustomerResponseDTO(customer) )
                .collect(Collectors.toList());

        return customerResponseDTOList;
    }

    @Override
    public void deleteCustomer(String id) {

        customerRepository.deleteById(id);
    }
}
