package com.example.projectsopfinal.repository;

import com.example.projectsopfinal.model.Tour;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends CrudRepository<Tour, String> {
}
