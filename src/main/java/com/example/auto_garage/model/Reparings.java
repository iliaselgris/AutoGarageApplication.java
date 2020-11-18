package com.example.auto_garage.model;

import com.example.auto_garage.model.employee.AuthorityKey;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "reparings")
public class Reparings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double reparingPrice;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reparings")
    private List<Part> parts = new ArrayList<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getReparingPrice() {
        return reparingPrice;
    }

    public void setReparingPrice(double price) {
        this.reparingPrice = price;
    }
}
