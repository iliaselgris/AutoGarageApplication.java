package com.example.auto_garage.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String examination;
    private String appointment2;
    private final double price = 45;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appointment")
    private List<Customer> customer = new ArrayList<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExamination() {
        return examination;
    }

    public void setExamination(String appointment1) {
        this.examination = appointment1;
    }

    public String getAppointment2() {
        return appointment2;
    }

    public void setAppointment2(String appointment2) {
        this.appointment2 = appointment2;
    }

    public double getPrice() {
        return price;
    }


}
