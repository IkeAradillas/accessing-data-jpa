package com.example.accessingdatajpa.model;

import jakarta.persistence.*;

@Entity
@Table (name="customers")
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column (name="first_name", nullable = false, length = 100)
    private String firstName;
    @Column (name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    protected Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.contains("@")) this.email = email;
        else throw new RuntimeException("El email no es valido");
    }
}
