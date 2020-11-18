package com.example.auto_garage.model.employee;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, length = 255)
    private String password;
    @Column
    private String lastName;

    @Column
    private String email;
    @Column
    private String mobile;
    @Column
    private String apikey;
    @OneToMany(
            targetEntity = com.example.auto_garage.model.employee.Authority.class,
            mappedBy = "username",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private  Set<com.example.auto_garage.model.employee.Authority> authorities = new HashSet<>();

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public Set<com.example.auto_garage.model.employee.Authority> getAuthorities() {
        return authorities;
    }

    public void addAuthority(com.example.auto_garage.model.employee.Authority authority) {
        this.authorities.add(authority);
    }

    public void removeAuthority(com.example.auto_garage.model.employee.Authority authority) {
        this.authorities.remove(authority);
    }


}

