package com.example.projectsopfinal.repository;

import com.example.projectsopfinal.model.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TourService {
    private TourRepository tourRepository;

    @Autowired
    public TourService(TourRepository tourRepository){
        this.tourRepository = tourRepository;
    }
    public Tour saveTour(Tour tour){
        return tourRepository.save(tour);
    }

    public Iterable<Tour> getAllTours(){
        return tourRepository.findAll();
    }

    public void deleteAllTours(){
        tourRepository.deleteAll();
    }

    public Tour detailTourByName(String name){
        return tourRepository.findByName(name);
    }

    public Optional<Tour> findTourById(String id){
        return tourRepository.findById(id);
    }

    public Iterable<Tour> getToursByProvince(String province){
        return tourRepository.findByProvince(province);
    }
}
