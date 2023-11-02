package com.example.springbootdocker.entitys;

import jakarta.persistence.*;

@Entity
public class Observation {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String description;
     private String value;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
