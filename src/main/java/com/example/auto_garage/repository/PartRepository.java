package com.example.auto_garage.repository;


import com.example.auto_garage.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository <Part, Long>{
}
