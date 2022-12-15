package com.example.projectsopfinal;

import com.example.projectsopfinal.repository.TourService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
@SpringBootApplication
@Slf4j
public class ProjectSopFinalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectSopFinalApplication.class, args);
    }

}


