package com.example.projectVishwa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories // Enable JPA Repositories explicitly
public class ProjectVishwaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectVishwaApplication.class, args);
    }
}
