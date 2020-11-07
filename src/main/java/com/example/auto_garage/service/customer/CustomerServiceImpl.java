package com.example.auto_garage.service.customer;

import com.example.auto_garage.model.Customer;
import com.example.auto_garage.model.Customer;
import com.example.auto_garage.model.Customer;
import com.example.auto_garage.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.auto_garage.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {

        return customerRepository.findAll();
    }

    @Override
    public void saveCustomer(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(long id) {
        Optional<Customer> optional = customerRepository.findById(id);
        Customer customer = null;
        if (optional.isPresent()) {
            customer = optional.get();
        } else {
            throw new RuntimeException(" Customer not found for id :: " + id);
        }
        return customer;
    }

    @Override
    public void deleteCustomerById(long id) {
        this.customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.customerRepository.findAll(pageable);
    }
}
