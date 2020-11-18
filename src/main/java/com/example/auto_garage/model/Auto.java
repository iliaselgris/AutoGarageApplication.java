package com.example.auto_garage.model;

import javax.persistence.*;



@Entity
@Table(name = "auto")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

    private String plate;

    private String brand;

    private String model;

    private String buildYear;

    private String kiloStand;



    @ManyToOne
    @JoinColumn(name= "customer_id")
    private Customer customer;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(String buildYear) {
        this.buildYear = buildYear;
    }

    public String getKiloStand() {
        return kiloStand;
    }

    public void setKiloStand(String kiloStand) {
        this.kiloStand = kiloStand;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }



}
