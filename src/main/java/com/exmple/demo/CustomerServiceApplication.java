package com.exmple.demo;

import com.exmple.demo.dto.CustomerRequestDTO;
import com.exmple.demo.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerService customerService){
        return args -> {

            customerService.save(CustomerRequestDTO.builder()
                    .id("CO1")
                    .email("hasbilal@gmail.com")
                    .name("Hassan")
                    .build());

            customerService.save(CustomerRequestDTO.builder()
                    .id("CO2")
                    .email("hasbilal@gmail.com")
                    .name("BILAL")
                    .build());
        };
    }
}

