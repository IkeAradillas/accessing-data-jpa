package com.example.accessingdatajpa.controller.rest;

import com.example.accessingdatajpa.dto.CustomerDTO;
import com.example.accessingdatajpa.expections.EmailNotValidException;
import com.example.accessingdatajpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CustomerResource.CUSTOMERS)
public class CustomerResource {
    public static final String CUSTOMERS = "/customers";

    @Autowired
    CustomerService cs;
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(@RequestParam(name="lastName", required = false) String lastName, @RequestParam(name="email", required = false) String email){
        if (lastName != null && email != null) return ResponseEntity.ok(cs.getCustomerByLastNameAndEmail(lastName, email));
        else if (lastName != null) return ResponseEntity.ok(cs.getCustomerByLastName(lastName));
        else if (email != null) return ResponseEntity.ok(cs.getCustomerByEmail(email));
        else return ResponseEntity.ok(cs.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable("id") Long id){
        return ResponseEntity.ok(cs.getCustomer(id));

    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO c) throws EmailNotValidException {
        return ResponseEntity.ok(cs.addCustomer(c));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerDTO c) throws EmailNotValidException {
        CustomerDTO cdto = cs.updateCustomer(id, c);
        return ResponseEntity.ok(cdto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable("id") Long id){
        CustomerDTO c = cs.deleteCustomer(id);
        return ResponseEntity.ok(c);
    }
}
