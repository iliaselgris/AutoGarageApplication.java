package com.example.auto_garage.repository;

import com.example.auto_garage.model.DatabaseFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseFileRepository extends JpaRepository<DatabaseFile, String> {

}
