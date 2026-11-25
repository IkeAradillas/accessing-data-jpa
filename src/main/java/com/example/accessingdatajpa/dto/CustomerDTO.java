package com.example.accessingdatajpa.dto;

import com.example.accessingdatajpa.model.Incident;

import java.util.List;

public record CustomerDTO(String firstName, String lastName, String email, List<Incident> i) {

}
