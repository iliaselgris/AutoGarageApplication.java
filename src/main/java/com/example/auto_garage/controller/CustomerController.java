package com.example.auto_garage.controller;

import com.example.auto_garage.model.Customer;
import com.example.auto_garage.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.Map;


@RequestMapping("/customers")

@RestController
@PreAuthorize("hasAnyRole('ADMIN','FRONTDESK')")
public class CustomerController {


    @Autowired
    private CustomerService customerService;


    @GetMapping(value = "")
    @PreAuthorize("hasAnyRole('ADMIN','FRONTDESK','MONTEUR','KASSIERE')")
    public ResponseEntity<Object> getCustomers() {
        return ResponseEntity.ok().body(customerService.getAllCustomers());
    }


    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','FRONTDESK','MONTEUR','KASSIERE')")
    public ResponseEntity<Object> getCustomer(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(customerService.getCustomerById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
        long newId = customerService.createCustomer(customer);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body(location);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
        customerService.updateCustomer(id, customer);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Object> updateCustomerPartial(@PathVariable("id") long id, @RequestBody Map<String, String> fields) {
        customerService.partialUpdateCustomer(id, fields);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteCustomerById(@PathVariable("id") long id) {
        customerService.deleteCustomerById(id);
        return ResponseEntity.noContent().build();
    }


}
