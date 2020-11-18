//package com.example.auto_garage.model;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "invoices")
//public class Invoice {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "appointment_price", referencedColumnName = "price")
//    private Appointment price;
//
//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "parts_price", referencedColumnName = "price")
//    private List<Part> partPrice;
//
//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "repairings_price", referencedColumnName = "price")
//    private List <Reparings> reparingsPrice;
//
//
//
//
//
//
//}
