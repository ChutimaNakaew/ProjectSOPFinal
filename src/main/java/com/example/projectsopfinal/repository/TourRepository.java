package com.example.projectsopfinal.repository;

import com.example.projectsopfinal.model.Tour;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends CrudRepository<Tour, String> {
    @Query(value = "{name: '?0'}")
    public Tour findByName (String name);
}
