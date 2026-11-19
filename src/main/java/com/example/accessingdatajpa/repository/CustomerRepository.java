package com.example.accessingdatajpa.repository;

import java.util.List;

import com.example.accessingdatajpa.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    Customer findById(long id);

    List<Customer> findByEmail(String email);

    //List<Customer> findByFirstNameAndLastName(String firstName, String lastName);
}