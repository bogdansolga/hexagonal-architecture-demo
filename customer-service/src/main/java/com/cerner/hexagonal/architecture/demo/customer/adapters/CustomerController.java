package com.cerner.hexagonal.architecture.demo.customer.adapters;

import com.cerner.hexagonal.architecture.demo.customer.dto.CustomerDTO;
import com.cerner.hexagonal.architecture.demo.customer.marker.adapter.InboundAdapter;
import com.cerner.hexagonal.architecture.demo.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController implements InboundAdapter {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody final CustomerDTO customerDTO) {
        customerService.createCustomer(customerDTO);

        return ResponseEntity.ok("The customer was successfully created");
    }
}
