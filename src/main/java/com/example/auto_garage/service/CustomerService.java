package com.example.auto_garage.service;

import com.example.auto_garage.exceptions.RecordNotFoundException;
import com.example.auto_garage.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.auto_garage.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> getAllCustomers() {

        return customerRepository.findAll();
    }


    public long createCustomer(Customer customer) {
        Customer newCustomer = customerRepository.save(customer);
        return newCustomer.getId();
    }


    public Optional<Customer> getCustomerById(long id) {
        if (!customerRepository.existsById(id)) throw new RecordNotFoundException();
        return customerRepository.findById(id);
    }


    public void updateCustomer(long id, Customer customer) {
        if (!customerRepository.existsById(id)) throw new RecordNotFoundException();
        Customer existingCustomer = customerRepository.findById(id).get();
        existingCustomer.setName(customer.getName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setMobile(customer.getMobile());
        customerRepository.save(existingCustomer);
    }


    public void partialUpdateCustomer(long id, Map<String, String> fields) {
        if (!customerRepository.existsById(id)) throw new RecordNotFoundException();
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
        customerRepository.save(customer);
    }


    public void deleteCustomerById(long id) {
        if (!customerRepository.existsById(id)) throw new RecordNotFoundException();
        customerRepository.deleteById(id);
    }


}