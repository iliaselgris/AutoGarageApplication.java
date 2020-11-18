package com.example.auto_garage.model;

import javax.persistence.*;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String appointment1;
    private String appointment2;
    private final double price = 45;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAppointment1() {
        return appointment1;
    }

    public void setAppointment1(String appointment1) {
        this.appointment1 = appointment1;
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
