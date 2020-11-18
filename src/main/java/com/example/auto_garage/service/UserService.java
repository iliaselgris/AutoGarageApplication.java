package com.example.auto_garage.service;


import com.example.auto_garage.exceptions.RecordNotFoundException;
import com.example.auto_garage.exceptions.UsernameNotFoundException;
import com.example.auto_garage.model.employee.Authority;
import com.example.auto_garage.model.employee.User;
import com.example.auto_garage.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Service

public class UserService implements UserServiceInterface{
    @Autowired
    private UserRepository userRepository;

    @Override
    public Collection<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(String username) {
        return userRepository.findById(username);
    }



    @Override

    public String createUser(User user) {
        User newUser = userRepository.save(user);
        return newUser.getUsername();
    }
    @Override

    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }
    @Override

    public void updateUser(String username, User newUser) {
        if (!userRepository.existsById(username)) throw new RecordNotFoundException();
        User user = userRepository.findById(username).get();
        user.setPassword(newUser.getPassword());
        userRepository.save(user);
    }
    @Override

    public Set<Authority> getAuthorities(String username) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        return user.getAuthorities();
    }
    @Override

    public void addAuthority(String username, String authority) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        user.addAuthority(new Authority(username,authority));
        userRepository.save(user);
    }

    @Override

    public void removeAuthority(String username, String authority) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        Authority authorityToRemove = user.getAuthorities().stream().filter((a) -> a.getAuthority().equalsIgnoreCase(authority)).findAny().get();
        user.removeAuthority(authorityToRemove);
        userRepository.save(user);
    }



}

