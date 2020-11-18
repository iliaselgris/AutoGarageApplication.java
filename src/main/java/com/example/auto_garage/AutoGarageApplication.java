package com.example.auto_garage;

import com.example.auto_garage.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)

public class AutoGarageApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoGarageApplication.class, args);

    }
}
