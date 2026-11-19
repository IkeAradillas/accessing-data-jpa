package com.example.accessingdatajpa.service;

import com.example.accessingdatajpa.dto.CustomerDTO;
import com.example.accessingdatajpa.model.Customer;
import com.example.accessingdatajpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository cr;

    public List<CustomerDTO> getAllCustomers(){
        List<Customer> c = cr.findAll();
        return c.stream().map(customer -> new CustomerDTO(customer.getFirstName(), customer.getLastName(), customer.getEmail())).toList();
    }


    public CustomerDTO getCustomer(long id) {
        Customer c = cr.findById(id);
        return new CustomerDTO(c.getFirstName(), c.getLastName(), c.getEmail());
    }

    public List<CustomerDTO> getCustomerByLastName(String lastName) {
        List<Customer> c = cr.findByLastName(lastName);
        return c.stream().map(customer -> new CustomerDTO(customer.getFirstName(), customer.getLastName(), customer.getEmail())).toList();
    }

    public CustomerDTO addCustomer(CustomerDTO cdto) {
        Customer c = new Customer(cdto.firstName(), cdto.lastName());
        c = cr.save(c);
        return new CustomerDTO(c.getFirstName(), c.getLastName(), c.getEmail());
    }

    public CustomerDTO updateCustomer(Long id, CustomerDTO cdto) {
        Customer c = cr.findById(id).orElseThrow(() -> new RuntimeException("Customer not Found with id" + id));
        c.setFirstName(cdto.firstName());
        c.setLastName(cdto.lastName());
        cr.save(c);
        return new CustomerDTO(c.getFirstName(), c.getLastName(), c.getEmail());
    }

    public CustomerDTO deleteCustomer(Long id) {
        Customer c = cr.findById(id).orElseThrow(() -> new RuntimeException("Customer not Found with ID" + id));
        return new CustomerDTO(c.getFirstName(), c.getLastName(), c.getEmail());
    }

    public List<CustomerDTO> getCustomerByLastNameAndEmail(String lastName, String email) {
        List<Customer> cln = cr.findByLastName(lastName);
        List<Customer> ce = cr.findByEmail(email);
        cln.addAll(ce);
        return cln.stream().map(customer -> new CustomerDTO(customer.getFirstName(), customer.getLastName(), customer.getEmail())).toList();
    }

    public List<CustomerDTO> getCustomerByEmail(String email) {
        List<Customer> ce = cr.findByEmail(email);
        return ce.stream().map(customer -> new CustomerDTO(customer.getFirstName(), customer.getLastName(), customer.getEmail())).toList();
    }
}
