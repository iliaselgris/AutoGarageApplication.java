package com.example.auto_garage.service;


import com.example.auto_garage.model.employee.Authority;
import com.example.auto_garage.model.employee.User;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public interface UserServiceInterface {
    public abstract String createUser(User user);
    public abstract void updateUser(String username, User user);
    public abstract void deleteUser(String username);
    public abstract Collection<User> getAllUsers();
    public abstract Optional<User> getUser(String username);
    public abstract Set<Authority> getAuthorities(String username);
    public abstract void addAuthority(String username, String authority);
    public abstract void removeAuthority(String username, String authority);

}
