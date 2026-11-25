package com.example.accessingdatajpa.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="incidents")
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titol;
    @Column()
    private String descripcio;
    @Column(name= "data_obertura", nullable = false)
    private LocalDateTime dataObertura = LocalDateTime.now();
    @Column(nullable = false)
    private String estat; //
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customer_id")
    private Customer c;

    public Incident(String titol, String descripcio, String estat) {
        this.titol = titol;
        this.descripcio=descripcio;
        this.estat=estat;
    }

    public Incident(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public LocalDateTime getDataObertura() {
        return dataObertura;
    }

    public void setDataObertura(LocalDateTime dataObertura) {
        this.dataObertura = dataObertura;
    }

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }

    public Customer getC() {
        return c;
    }

    public void setC(Customer c) {
        this.c = c;
    }
}
