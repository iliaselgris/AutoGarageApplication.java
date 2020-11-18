package com.example.auto_garage.repository;

import com.example.auto_garage.model.employee.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface UserRepository extends JpaRepository<User, String> {
}
