package com.example.auto_garage.controller;

import com.example.auto_garage.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.example.auto_garage.repository.CustomerRepository;

import java.net.URI;
import java.util.Map;


@RequestMapping("/customers")

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(value = "")
    public ResponseEntity<Object> getCustomers() {
        return ResponseEntity.ok().body(customerRepository.findAll());
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getCustomer(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(customerRepository.findById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
        Customer newBook = customerRepository.save(customer);
        long newId = newBook.getId();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body(location);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
        if (customerRepository.existsById(id)) {
            Customer existingbook = customerRepository.findById(id).get();
            existingbook.setName(customer.getName());
            existingbook.setLastName(customer.getLastName());
            existingbook.setEmail(customer.getEmail());
            existingbook.setMobile(customer.getMobile());
            customerRepository.save(existingbook);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Object> updateCustomerPartial(@PathVariable("id") long id, @RequestBody Map<String, Object> fields) {
        if (customerRepository.existsById(id)) {
            Customer customer = customerRepository.findById(id).get();
            for (String field : fields.keySet()) {
                switch (field.toLowerCase()) {
                    case "name":
                        customer.setName((String) fields.get(field));
                        break;
                    case "lastName":
                        customer.setLastName((String) fields.get(field));
                        break;
                    case "email":
                        customer.setEmail((String) fields.get(field));
                        break;
                    case "mobile":
                        customer.setMobile((String) fields.get(field));
                        break;


                }
            }
            ;
            customerRepository.save(customer);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("id") long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
