package com.example.auto_garage.service.customer;

import com.example.auto_garage.model.Customer;
import com.example.auto_garage.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {

    List<Customer> getAllCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomerById(long id);

    void deleteCustomerById(long id);

    Page<Customer> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
