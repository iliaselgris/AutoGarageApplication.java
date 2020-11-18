package com.example.auto_garage.repository;

import com.example.auto_garage.model.Reparings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReparingsRepository extends JpaRepository<Reparings, Long> {
}
